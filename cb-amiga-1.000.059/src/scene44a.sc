;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene44a 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= local0 (+ (/ (StrLen @temp0) 2) 1))
)

(procedure (localproc_1)
	(localproc_0 &rest)
	(LilMouth setScript: cycleMouth)
	(Print &rest #at 20 115 #font 4 #width 140 #mode 1 #draw #dispose)
)

(procedure (localproc_2)
	(localproc_0 &rest)
	(EthMouth setScript: cycleMouth)
	(Print &rest #at 160 115 #font 4 #width 140 #mode 1 #draw #dispose)
)

(instance scene44a of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(HandsOff)
		(myMusic number: 27 loop: -1 play:)
		(Lillian setPri: 1 init:)
		(LilMouth setPri: 2 init: hide:)
		(LilEyes
			setLoop: (Random 2 4)
			setPri: 2
			init:
			stopUpd:
			setScript: LillsEyes
		)
		(Ethel setPri: 1 init:)
		(EthMouth setPri: 2 init: hide:)
		(EthArm setLoop: 2 setCel: 0 setPri: 3 ignoreActors: 1 init:)
		(if (not (& gSpyFlags $0080))
			(self setScript: speech44a)
		else
			(EthArm setScript: TakeASip)
			(LilEyes setScript: LillsEyes)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(if (and (not (& gSpyFlags $0080)) global125)
			(|= gSpyFlags $0080)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance LillsEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LilEyes setLoop: (+ 4 (* (Random 0 2) 2)) stopUpd:)
				(= seconds (Random 2 5))
			)
			(1
				(LilEyes startUpd: setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance speech44a of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(and
				(not (event claimed:))
				(== evKEYBOARD (event type:))
				(or (== (event message:) KEY_S) (== (event message:) KEY_s))
			)
			(cls)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)

	(method (changeState newState)
		(if (cycleMouth client:)
			(= local1 1)
			(= cycles 1)
		else
			(switch (= state newState)
				(0
					(= cycles 7)
				)
				(1
					(= local2
						(Display 330 0 dsCOORD 48 8 dsWIDTH 256 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0 dsSAVEPIXELS) ; "Press the 'S' key to skip this scene."
					)
					(localproc_2 330 1) ; "Gertie isn't deserving of any of Henri's money! Why, she's not even a blood relative!"
					(= seconds 7)
				)
				(2
					(localproc_1 330 2) ; "What are you going to DO about it, Mother?"
					(EthArm setScript: TakeASip)
					(= seconds 5)
				)
				(3
					(if (and (EthArm script:) (< (TakeASip state:) 3))
						(-- state)
						(= cycles 1)
					else
						(localproc_2 330 3) ; "Well, I can certainly talk to Henri about her and those two brats of hers!"
						(= seconds 7)
					)
				)
				(4
					(localproc_1 330 4) ; "You never change, do you, Mother?"
					(EthArm setScript: TakeASip)
					(= seconds 5)
				)
				(5
					(if (and (EthArm script:) (< (TakeASip state:) 3))
						(-- state)
						(= cycles 1)
					else
						(localproc_2 330 5) ; "Never mind, Lillian. You and I will never agree on anything!"
						(= seconds 7)
					)
				)
				(6
					(EthArm setScript: TakeASip)
					(cls)
					(= seconds 7)
				)
				(7
					(if (and (EthArm script:) (< (TakeASip state:) 3))
						(-- state)
						(= cycles 1)
					else
						(gCurRoom newRoom: gPrevRoomNum)
					)
				)
			)
		)
	)
)

(instance TakeASip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& gSpyFlags $0080)
					(Print 330 6 #dispose) ; "As usual, Lillian and Ethel are having a disagreement."
				)
				(EthArm moveSpeed: 1 setMotion: MoveTo 191 113 self)
			)
			(1
				(EthArm setCycle: End self)
			)
			(2
				(EthMouth cel: 0 setCycle: Fwd show:)
				(= seconds 2)
			)
			(3
				(EthArm setCycle: Beg self)
				(EthMouth cel: 0 setCycle: 0 hide:)
			)
			(4
				(EthArm setMotion: MoveTo 165 136 self)
			)
			(5
				(client setScript: 0)
				(if (& gSpyFlags $0080)
					(gCurRoom newRoom: gPrevRoomNum)
				)
			)
		)
	)
)

(instance cycleMouth of Script
	(properties)

	(method (doit)
		(super doit:)
		(if local1
			(= local1 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: Fwd show:)
				(= cycles local0)
			)
			(1
				(client setScript: 0 hide:)
				(self client: 0)
			)
		)
	)
)

(instance Lillian of Prop
	(properties
		y 110
		x 96
		view 517
	)
)

(instance Ethel of Prop
	(properties
		y 110
		x 233
		view 324
	)
)

(instance LilMouth of Prop
	(properties
		y 88
		x 99
		view 517
		loop 2
		cycleSpeed 1
	)
)

(instance LilEyes of Prop
	(properties
		y 75
		x 98
		view 517
		loop 4
		cycleSpeed 1
	)
)

(instance EthMouth of Prop
	(properties
		y 94
		x 212
		view 324
		loop 1
		cycleSpeed 1
	)
)

(instance EthArm of Act
	(properties
		y 136
		x 165
		yStep 5
		view 324
		illegalBits 0
	)
)

(instance myMusic of Sound
	(properties)
)

