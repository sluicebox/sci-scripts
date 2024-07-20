;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 601)
(include sci.sh)
(use Motion)
(use Actor)
(use System)

(public
	spadeScript 0
	clubScript 1
	heartScript 2
	diamondScript 3
)

(local
	local0
	local1
	local2
	local3 = 150
)

(procedure (localproc_0)
	(switch (Random 0 2)
		(0
			(= local0 (Random 320 640))
			(= local1 0)
		)
		(1
			(= local0 640)
			(= local1 (Random 0 480))
		)
		(2
			(= local0 (Random 320 640))
			(= local1 480)
		)
	)
)

(instance vSpade of View
	(properties)
)

(instance vClub of View
	(properties)
)

(instance vHeart of View
	(properties)
)

(instance vDiamond of View
	(properties)
)

(instance spadeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(vSpade view: 50 loop: 0 cel: 12 posn: 48 20 setPri: 14 init:)
				(client moveSpeed: 0 setStep: local3 local3 setCycle: Fwd)
				(localproc_0)
				(client setMotion: MoveTo local0 local1 self)
			)
			(1
				(vSpade cel: 11)
				(localproc_0)
				(client
					view: 611
					posn: 48 20
					setMotion: MoveTo local0 local1 self
				)
			)
			(2
				(vSpade cel: 10)
				(localproc_0)
				(client
					view: 612
					posn: 48 20
					setMotion: MoveTo local0 local1 self
				)
			)
			(3
				(vSpade cel: 9)
				(localproc_0)
				(client
					view: 613
					posn: 48 20
					setMotion: MoveTo local0 local1 self
				)
			)
			(4
				(vSpade cel: 8)
				(localproc_0)
				(client
					view: 614
					posn: 48 20
					setMotion: MoveTo local0 local1 self
				)
			)
			(5
				(vSpade cel: 7)
				(localproc_0)
				(client
					view: 615
					posn: 48 20
					setMotion: MoveTo local0 local1 self
				)
			)
			(6
				(vSpade cel: 6)
				(localproc_0)
				(client
					view: 616
					posn: 48 20
					setMotion: MoveTo local0 local1 self
				)
			)
			(7
				(vSpade cel: 5)
				(localproc_0)
				(client
					view: 617
					posn: 48 20
					setMotion: MoveTo local0 local1 self
				)
			)
			(8
				(vSpade cel: 4)
				(localproc_0)
				(client
					view: 618
					posn: 48 20
					setMotion: MoveTo local0 local1 self
				)
			)
			(9
				(vSpade cel: 3)
				(localproc_0)
				(client
					view: 619
					posn: 48 20
					setMotion: MoveTo local0 local1 self
				)
			)
			(10
				(vSpade cel: 2)
				(localproc_0)
				(client
					view: 620
					posn: 48 20
					setMotion: MoveTo local0 local1 self
				)
			)
			(11
				(vSpade cel: 1)
				(localproc_0)
				(client
					view: 621
					posn: 48 20
					setMotion: MoveTo local0 local1 self
				)
			)
			(12
				(vSpade dispose:)
				(localproc_0)
				(client
					view: 622
					posn: 48 20
					setMotion: MoveTo local0 local1 self
				)
			)
			(13
				(if (== (++ local2) 4)
					(= local2 0)
					((ScriptID 600 3) cue:) ; roomScript
				)
				(client dispose:)
			)
		)
	)
)

(instance clubScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(vClub view: 51 loop: 0 cel: 12 posn: 48 212 setPri: 14 init:)
				(client moveSpeed: 0 setStep: local3 local3 setCycle: Fwd)
				(localproc_0)
				(client setMotion: MoveTo local0 local1 self)
			)
			(1
				(vClub cel: 11)
				(localproc_0)
				(client
					view: 637
					posn: 48 212
					setMotion: MoveTo local0 local1 self
				)
			)
			(2
				(vClub cel: 10)
				(localproc_0)
				(client
					view: 638
					posn: 48 212
					setMotion: MoveTo local0 local1 self
				)
			)
			(3
				(vClub cel: 9)
				(localproc_0)
				(client
					view: 639
					posn: 48 212
					setMotion: MoveTo local0 local1 self
				)
			)
			(4
				(vClub cel: 8)
				(localproc_0)
				(client
					view: 640
					posn: 48 212
					setMotion: MoveTo local0 local1 self
				)
			)
			(5
				(vClub cel: 7)
				(localproc_0)
				(client
					view: 641
					posn: 48 212
					setMotion: MoveTo local0 local1 self
				)
			)
			(6
				(vClub cel: 6)
				(localproc_0)
				(client
					view: 642
					posn: 48 212
					setMotion: MoveTo local0 local1 self
				)
			)
			(7
				(vClub cel: 5)
				(localproc_0)
				(client
					view: 643
					posn: 48 212
					setMotion: MoveTo local0 local1 self
				)
			)
			(8
				(vClub cel: 4)
				(localproc_0)
				(client
					view: 644
					posn: 48 212
					setMotion: MoveTo local0 local1 self
				)
			)
			(9
				(vClub cel: 3)
				(localproc_0)
				(client
					view: 645
					posn: 48 212
					setMotion: MoveTo local0 local1 self
				)
			)
			(10
				(vClub cel: 2)
				(localproc_0)
				(client
					view: 646
					posn: 48 212
					setMotion: MoveTo local0 local1 self
				)
			)
			(11
				(vClub cel: 1)
				(localproc_0)
				(client
					view: 647
					posn: 48 212
					setMotion: MoveTo local0 local1 self
				)
			)
			(12
				(vClub dispose:)
				(localproc_0)
				(client
					view: 648
					posn: 48 212
					setMotion: MoveTo local0 local1 self
				)
			)
			(13
				(if (== (++ local2) 4)
					(= local2 0)
					((ScriptID 600 3) cue:) ; roomScript
				)
				(client dispose:)
			)
		)
	)
)

(instance heartScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(vHeart view: 53 loop: 0 cel: 12 posn: 48 116 setPri: 14 init:)
				(client moveSpeed: 0 setStep: local3 local3 setCycle: Fwd)
				(localproc_0)
				(client setMotion: MoveTo local0 local1 self)
			)
			(1
				(vHeart cel: 11)
				(localproc_0)
				(client
					view: 624
					posn: 48 116
					setMotion: MoveTo local0 local1 self
				)
			)
			(2
				(vHeart cel: 10)
				(localproc_0)
				(client
					view: 625
					posn: 48 116
					setMotion: MoveTo local0 local1 self
				)
			)
			(3
				(vHeart cel: 9)
				(localproc_0)
				(client
					view: 626
					posn: 48 116
					setMotion: MoveTo local0 local1 self
				)
			)
			(4
				(vHeart cel: 8)
				(localproc_0)
				(client
					view: 627
					posn: 48 116
					setMotion: MoveTo local0 local1 self
				)
			)
			(5
				(vHeart cel: 7)
				(localproc_0)
				(client
					view: 628
					posn: 48 116
					setMotion: MoveTo local0 local1 self
				)
			)
			(6
				(vHeart cel: 6)
				(localproc_0)
				(client
					view: 629
					posn: 48 116
					setMotion: MoveTo local0 local1 self
				)
			)
			(7
				(vHeart cel: 5)
				(localproc_0)
				(client
					view: 630
					posn: 48 116
					setMotion: MoveTo local0 local1 self
				)
			)
			(8
				(vHeart cel: 4)
				(localproc_0)
				(client
					view: 631
					posn: 48 116
					setMotion: MoveTo local0 local1 self
				)
			)
			(9
				(vHeart cel: 3)
				(localproc_0)
				(client
					view: 632
					posn: 48 116
					setMotion: MoveTo local0 local1 self
				)
			)
			(10
				(vHeart cel: 2)
				(localproc_0)
				(client
					view: 633
					posn: 48 116
					setMotion: MoveTo local0 local1 self
				)
			)
			(11
				(vHeart cel: 1)
				(localproc_0)
				(client
					view: 634
					posn: 48 116
					setMotion: MoveTo local0 local1 self
				)
			)
			(12
				(vHeart dispose:)
				(localproc_0)
				(client
					view: 635
					posn: 48 116
					setMotion: MoveTo local0 local1 self
				)
			)
			(13
				(if (== (++ local2) 4)
					(= local2 0)
					((ScriptID 600 3) cue:) ; roomScript
				)
				(client dispose:)
			)
		)
	)
)

(instance diamondScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(vDiamond
					view: 52
					loop: 0
					cel: 12
					posn: 48 308
					setPri: 14
					init:
				)
				(client moveSpeed: 0 setStep: local3 local3 setCycle: Fwd)
				(localproc_0)
				(client setMotion: MoveTo local0 local1 self)
			)
			(1
				(vDiamond cel: 11)
				(localproc_0)
				(client
					view: 650
					posn: 48 308
					setMotion: MoveTo local0 local1 self
				)
			)
			(2
				(vDiamond cel: 10)
				(localproc_0)
				(client
					view: 651
					posn: 48 308
					setMotion: MoveTo local0 local1 self
				)
			)
			(3
				(vDiamond cel: 9)
				(localproc_0)
				(client
					view: 652
					posn: 48 308
					setMotion: MoveTo local0 local1 self
				)
			)
			(4
				(vDiamond cel: 8)
				(localproc_0)
				(client
					view: 653
					posn: 48 308
					setMotion: MoveTo local0 local1 self
				)
			)
			(5
				(vDiamond cel: 7)
				(localproc_0)
				(client
					view: 654
					posn: 48 308
					setMotion: MoveTo local0 local1 self
				)
			)
			(6
				(vDiamond cel: 6)
				(localproc_0)
				(client
					view: 655
					posn: 48 308
					setMotion: MoveTo local0 local1 self
				)
			)
			(7
				(vDiamond cel: 5)
				(localproc_0)
				(client
					view: 656
					posn: 48 308
					setMotion: MoveTo local0 local1 self
				)
			)
			(8
				(vDiamond cel: 4)
				(localproc_0)
				(client
					view: 657
					posn: 48 308
					setMotion: MoveTo local0 local1 self
				)
			)
			(9
				(vDiamond cel: 3)
				(localproc_0)
				(client
					view: 658
					posn: 48 308
					setMotion: MoveTo local0 local1 self
				)
			)
			(10
				(vDiamond cel: 2)
				(localproc_0)
				(client
					view: 659
					posn: 48 308
					setMotion: MoveTo local0 local1 self
				)
			)
			(11
				(vDiamond cel: 1)
				(localproc_0)
				(client
					view: 660
					posn: 48 308
					setMotion: MoveTo local0 local1 self
				)
			)
			(12
				(vDiamond dispose:)
				(localproc_0)
				(client
					view: 661
					posn: 48 308
					setMotion: MoveTo local0 local1 self
				)
			)
			(13
				(if (== (++ local2) 4)
					(= local2 0)
					((ScriptID 600 3) cue:) ; roomScript
				)
				(client dispose:)
			)
		)
	)
)

