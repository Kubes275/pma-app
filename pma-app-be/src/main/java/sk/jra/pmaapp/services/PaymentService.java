package sk.jra.pmaapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.jra.pmaapp.common.ListModel;
import sk.jra.pmaapp.data.mappers.PaymentMapper;
import sk.jra.pmaapp.data.models.PaymentModel;
import sk.jra.pmaapp.repositories.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {

  //repositories
  @Autowired(required = false)
  PaymentRepository paymentRepository;

  //mappers
  @Autowired
  PaymentMapper paymentMapper;

  public List<PaymentModel> getPayments() {
    return paymentMapper.mapPaymentEntityListToPaymentModelList(
      paymentRepository.findAllByOrderById()
    );
  }

}
