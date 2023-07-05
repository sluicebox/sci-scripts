;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 169)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	daughter 0
	peepingTom 1
)

(instance daughter of Prop
	(properties
		y 94
		x 154
		view 393
	)

	(method (init)
		(super init:)
		(self setScript: daughterAppears)
	)

	(method (delete)
		(ClearFlag 168)
		(super delete:)
		(DisposeScript 169)
	)
)

(instance daughterAppears of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(daughter setCel: 0 setCycle: End self)
			)
			(1
				(daughter setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(global188 init:)
				(daughter setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(= seconds 5)
			)
			(4
				(daughter setLoop: 3 setCel: 0 setCycle: End self)
			)
			(5
				(= seconds 20)
			)
			(6
				(ClearFlag 159)
				(client setScript: 0)
				(client dispose:)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance girlWindow of SysWindow
	(properties
		color 15
		back 4
		brTop 5
		brBottom 80
	)
)

(instance peepingTom of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(or (== state 1) (== state 2))
				(or
					(not (gEgo inRect: 146 140 165 150))
					(!= (gEgo loop:) 3)
				)
			)
			(gEgo setScript: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj endTalk:)
				(gEgo setMotion: MoveTo 156 142 self)
			)
			(1
				(gEgo loop: 3)
				(RedrawCast)
				(if (not (IsFlag 168))
					(SetFlag 168)
					(Print 169 0) ; "Aye, a girl is inside, probably the butcher's daughter. And she is...ahem...Arthur, she is taking a bath."
					(= seconds 3)
				else
					(= cycles 8)
				)
				(HandsOn)
			)
			(2
				(Print 169 1) ; "Have you no shame? She is naked! Avert your eyes, quickly!"
				(= seconds 4)
			)
			(3
				(global185 setScript: (ScriptID 171 0)) ; FawazKill
			)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			((Said 'talk/girl,daughter')
				(HandsOff)
				(gTObj endTalk:)
				(Print 169 2 #window girlWindow) ; "EEEEEEEEEEK!"
				(self changeState: 3)
			)
			((or (Said 'look/window') (OnButton event 144 63 166 98))
				(Print 169 3) ; "Hmm...it looks like someone is in there."
			)
		)
	)
)

