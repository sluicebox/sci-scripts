;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use Feature)
(use Motion)
(use Game)
(use System)

(public
	kiz 0
	yoFlo 1
	sBeamOut 2
)

(class kiz of Rgn
	(properties
		modnum 301
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 16))
			(self setScript: sProdPlayer)
		)
		(if
			(or
				(== (gSq5Music1 number:) 35)
				(and (== (gSq5Music1 number:) 124) (== gCurRoomNum 325))
				(and (== (gSq5Music1 number:) 17) (!= gCurRoomNum 305))
			)
			(gSq5Music1 number: 15 loop: -1 play: 0 fade: 127 10 5 0)
		)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 300 305 310 315 320 325 330 335))
		(= initialized 0)
		(if
			(or
				(== (gSq5Music1 number:) 35)
				(and (== (gSq5Music1 number:) 124) (== newRoomNumber 325))
				(and (== (gSq5Music1 number:) 17) (!= newRoomNumber 305))
			)
			(gSq5Music1 fade: 0 5 10 1)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance yoFlo of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; Communicator
				(gCurRoom setScript: sBeamOut)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance sBeamOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(1
				(gEgo view: 14 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(cond
					((not (IsFlag 9))
						(cond
							((not (IsFlag 16))
								(= register 0)
								(gMessager say: 1 32 6 0 self 301) ; "Help! Get me out of here!"
							)
							((!= gCurRoomNum 300)
								(= register 0)
								(gMessager say: 1 32 2 0 self 301) ; "I'm ready to beam aboard. Energize."
							)
							((not (gEgo has: 20)) ; WD40_Head
								(= register 0)
								(gMessager say: 1 32 3 0 self 301) ; "I'm at the beam out coordinates. Energize when ready."
							)
							(else
								(= register 1)
								(gMessager say: 1 32 4 0 self 301) ; "Eureka, beam me up."
							)
						)
					)
					((not (IsFlag 212))
						(if (!= gCurRoomNum 325)
							(= register 0)
							(gMessager say: 1 32 2 0 self 301) ; "I'm ready to beam aboard. Energize."
						else
							(= register 1)
							(gMessager say: 1 32 4 0 self 301) ; "Eureka, beam me up."
						)
					)
					((!= gCurRoomNum 300)
						(= register 0)
						(gMessager say: 1 32 2 0 self 301) ; "I'm ready to beam aboard. Energize."
					)
					(else
						(= register 1)
						(gMessager say: 1 32 4 0 self 301) ; "Eureka, beam me up."
					)
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(cond
					((not register)
						(NormalEgo 0)
						(gEgo loop: 2)
						(gGame handsOn:)
						(self dispose:)
					)
					((and (not (& global169 $0020)) (== gCurRoomNum 325))
						(if ((ScriptID 325 1) script:) ; cliffy
							(((ScriptID 325 1) script:) dispose:) ; cliffy
						)
						((ScriptID 325 1) ; cliffy
							view: 33
							setLoop: -1
							setLoop: 0
							cel: ((ScriptID 325 1) lastCel:) ; cliffy
							x: 293
							y: 165
							setCycle: CT 2 -1 self
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(5
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(gEgo
					view: 6
					loop: 0
					cel: (gEgo lastCel:)
					cycleSpeed: 6
					setCycle: Beg self
				)
				(if (and (not (& global169 $0020)) (== gCurRoomNum 325))
					((ScriptID 325 1) setCycle: Beg) ; cliffy
				)
				(if (gEgo has: 17) ; Kiz_Branch
					(gEgo put: 17) ; Kiz_Branch
				)
			)
			(6
				(SetFlag 9)
				(if (gEgo has: 17) ; Kiz_Branch
					(gEgo put: 17) ; Kiz_Branch
				)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance sProdPlayer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(if (and (IsFlag 66) (not (IsFlag 67)))
					(SetFlag 67)
					(gMessager say: 3 0 0 0 self 301) ; "Phew!! That was too close! You'd better keep moving, Rog. That WD40 android won't give up till you're a smoldering pile of hero salsa."
				else
					(= cycles 1)
				)
			)
			(2
				(= seconds 180)
			)
			(3
				(if (not (IsFlag 16))
					(gMessager say: 2 0 0 (Random 1 3) self 301)
				else
					(self dispose:)
				)
			)
			(4
				(= state -1)
				(= cycles 1)
			)
			(5
				(self dispose:)
			)
		)
	)
)

