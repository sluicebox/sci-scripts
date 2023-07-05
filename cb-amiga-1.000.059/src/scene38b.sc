;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 302)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene38b 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= local1 (+ (/ (StrLen @temp0) 3) 1))
)

(procedure (localproc_1)
	(localproc_0 &rest)
	(+= local1 (/ local1 4))
	(Mouth setScript: cycleMouth)
	(ParrotMouth setCycle: 0)
	(Print &rest #at 160 120 #font 4 #width 140 #mode 1 #dispose)
)

(procedure (localproc_2)
	(localproc_0 &rest)
	(ParrotMouth setScript: cycleMouth)
	(Mouth setCycle: 0)
	(Print &rest #at 20 120 #font 4 #width 140 #mode 1 #dispose)
)

(instance scene38b of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(HandsOff)
		(gAddToPics add: parrotBody doit:)
		(Ethel setPri: 1 init:)
		(Mouth setPri: 2 init:)
		(Eye setPri: 2 init: setScript: ethelEyes)
		(Arm setLoop: 8 setPri: 2 setCycle: 0 init: hide:)
		(ParrotMouth setPri: 2 init:)
		(myMusic number: 27 loop: -1 play:)
		(if (not (& gSpyFlags $0002))
			(self setScript: speech38)
		else
			(self setScript: Salute)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
		(|= gSpyFlags $0002)
	)

	(procedure (localproc_3 param1) ; UNUSED
		(super handleEvent: param1)
		(if
			(and
				(not (param1 claimed:))
				(== 4 (param1 type:))
				(or (== (param1 message:) 83) (== (param1 message:) 115))
			)
			(cls)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance speech38 of Script
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
			(= local2 1)
			(= cycles 1)
		else
			(switch (= state newState)
				(0
					(= local0
						(Display 302 0 dsCOORD 48 8 dsWIDTH 256 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0 dsSAVEPIXELS) ; "Press the 'S' key to skip this scene."
					)
					(localproc_1 302 1) ; "YOU know how shey all feel 'bout me, don'cha, Polly?"
					(= seconds 5)
				)
				(1
					(cls)
					(localproc_2 302 2) ; "AWWK!"
					(= seconds 5)
				)
				(2
					(cls)
					(localproc_1 302 3) ; "Wellll, I don' care what shey think! 'Specially, Gertie and shat connivin' daughter o' hers!"
					(= seconds 8)
				)
				(3
					(cls)
					(localproc_1 302 4) ; "I shink I'll have 'nother drink...okay, Polly?"
					(= seconds 6)
				)
				(4
					(cls)
					(localproc_2 302 5) ; "Have a drink...AWWK!"
					(= seconds 5)
				)
				(5
					(cls)
					(Arm setScript: Salute)
				)
			)
		)
	)
)

(instance cycleMouth of Script
	(properties)

	(method (doit)
		(super doit:)
		(if local2
			(= local2 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: Fwd show:)
				(= cycles local1)
			)
			(1
				(client setScript: 0 setCycle: 0 cel: 0)
				(if (== client Mouth)
					(client hide:)
				)
				(self client: 0)
			)
		)
	)
)

(instance ethelEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 5))
			)
			(1
				(Eye loop: (Random 5 7) setCycle: End self)
				(= state -1)
			)
		)
	)
)

(instance Salute of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& gSpyFlags $0002)
					(Print 302 6 #dispose) ; "Ethel is still drinking at the bar."
				)
				(Arm show: setMotion: MoveTo 183 99 self)
			)
			(1
				(if (not (& gSpyFlags $0002))
					(localproc_1 302 7) ; "Shere's to ya!"
				)
				(= seconds 3)
			)
			(2
				(Arm setMotion: MoveTo 205 106 self)
			)
			(3
				(if (not (& gSpyFlags $0002))
					(cls)
				)
				(Arm setCycle: End)
				(Mouth show: cycleSpeed: 2 setCycle: Fwd)
				(= seconds 2)
			)
			(4
				(Mouth hide:)
				(Arm setCel: 0 setMotion: MoveTo 199 134 self)
			)
			(5
				(client setScript: 0)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance parrotBody of PV
	(properties
		y 103
		x 84
		view 525
		priority 1
	)
)

(instance Arm of Act
	(properties
		y 134
		x 199
		view 324
	)
)

(instance Ethel of Prop
	(properties
		y 106
		x 222
		view 324
		loop 3
		signal 16384
	)
)

(instance ParrotMouth of Prop
	(properties
		y 69
		x 92
		view 525
		loop 1
	)
)

(instance Mouth of Prop
	(properties
		y 89
		x 212
		view 324
		loop 4
		signal 16384
		cycleSpeed 1
	)
)

(instance Eye of Prop
	(properties
		y 74
		x 212
		view 324
		loop 5
		signal 16384
	)
)

(instance myMusic of Sound
	(properties)
)

