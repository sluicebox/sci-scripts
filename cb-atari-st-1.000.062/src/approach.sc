;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 782)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	approach 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(= local0 (Display &rest dsFONT 41 dsALIGN alCENTER dsCOORD local2 local3 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS))
)

(procedure (localproc_1)
	(= local1 (Display &rest dsFONT 41 dsALIGN alCENTER dsCOORD local2 local3 dsWIDTH 300 dsCOLOR 0 dsSAVEPIXELS))
)

(procedure (localproc_2)
	(Print &rest #at 10 94 #font 4 #width 145 #mode 0 #dispose)
)

(procedure (localproc_3)
	(Print &rest #at 160 94 #font 4 #width 142 #mode 0 #dispose)
)

(instance Laura of Prop
	(properties)
)

(instance Lillian of Prop
	(properties)
)

(instance lHead of Prop
	(properties)
)

(instance eHead of Prop
	(properties)
)

(instance light1 of Prop
	(properties)
)

(instance light2 of Prop
	(properties)
)

(instance Thunder of Sound
	(properties)
)

(instance approach of Rm
	(properties
		picture 28
	)

	(method (init)
		(super init:)
		(LoadMany rsFONT 4 41)
		(Load rsSOUND 18)
		(gAddToPics add: Sign Bird1 Bird2 doit:)
		(Thunder number: 18 loop: -1 play:)
		(light1 view: 128 loop: 2 cel: 1 posn: 86 42 init:)
		(light2 view: 128 loop: 3 cel: 1 posn: 157 51 init:)
		(Laura view: 128 loop: 4 cel: 0 posn: 148 187 init:)
		(Lillian view: 128 loop: 4 cel: 1 posn: 180 187 init:)
		(lHead view: 128 loop: 5 cel: 0 setPri: 15 posn: 179 147 init:)
		(eHead view: 128 loop: 6 cel: 0 setPri: 15 posn: 148 148 init:)
		(self setScript: openning)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(cond
					((or (== (event message:) KEY_S) (== (event message:) KEY_s))
						(event claimed: 1)
						(gCurRoom newRoom: 783) ; frontDoor
					)
					((or (== (event message:) KEY_RETURN) (== (event message:) KEY_SPACE))
						(SetFlag 50)
					)
				)
			)
			(evMOUSEBUTTON
				(SetFlag 50)
			)
		)
		(if (IsFlag 50)
			(event claimed: 1)
			(gCurRoom newRoom: 44)
		)
	)
)

(instance openning of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(or
				(and (== (Thunder prevSignal:) 50) (== state 0))
				(and (== (Thunder prevSignal:) 60) (== state 6))
				(and (== (Thunder prevSignal:) -1) (== state 11))
			)
			(Thunder prevSignal: 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
			)
			(1
				(light1 setCycle: Fwd)
				(light2 setCycle: Fwd)
				(= cycles 6)
			)
			(2
				(light1 setCycle: End)
				(light2 setCycle: End)
				(= seconds 2)
			)
			(3
				(= local2 11)
				(= local3 10)
				(localproc_1 782 0) ; "Animation by Douglas Herring Backgrounds by Douglas Herring & Jerry Moore"
				(= local2 10)
				(= local3 12)
				(localproc_0 782 0) ; "Animation by Douglas Herring Backgrounds by Douglas Herring & Jerry Moore"
				(= seconds 6)
			)
			(4
				(lHead setCycle: End self)
			)
			(5
				(Display 782 1 dsRESTOREPIXELS local0)
				(Display 782 1 dsRESTOREPIXELS local1)
				(localproc_3 782 2) ; "Well, what do you think?"
				(= seconds 4)
			)
			(6
				(cls)
				(lHead setCycle: Beg)
			)
			(7
				(light1 setCycle: Fwd)
				(light2 setCycle: Fwd)
				(= cycles 6)
			)
			(8
				(cls)
				(light1 setCycle: End)
				(light2 setCycle: End)
				(= seconds 3)
			)
			(9
				(eHead setCycle: End)
				(localproc_2 782 3) ; "It looks interesting, all right."
				(= seconds 5)
			)
			(10
				(cls)
				(lHead setCycle: End)
				(localproc_3 782 4) ; "Wait'll you meet the family!"
				(= seconds 5)
			)
			(11
				(cls)
				(lHead setCycle: Beg)
				(eHead setCycle: Beg)
				(Thunder fade: self)
			)
			(12
				(if (and (== (lHead cel:) 0) (== (eHead cel:) 0))
					(client setScript: 0)
					(gCurRoom newRoom: 783) ; frontDoor
				else
					(= state 11)
					(= cycles 1)
				)
			)
		)
	)
)

(instance Sign of PV
	(properties
		y 135
		x 145
		view 128
		loop 1
		cel 1
		priority 12
	)
)

(instance Bird1 of PV
	(properties
		y 103
		x 111
		view 128
		loop 1
		priority 12
	)
)

(instance Bird2 of PV
	(properties
		y 103
		x 207
		view 128
		loop 1
		priority 12
	)
)

