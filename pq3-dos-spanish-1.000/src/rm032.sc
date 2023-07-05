;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm032 0
)

(local
	local0
)

(instance rm032 of PQRoom
	(properties
		picture 32
	)

	(method (init)
		(super init:)
		(oliver init:)
		(jim init:)
		(marie init:)
		(mHand init:)
		(= local0 jMouth)
		(jMouth init:)
		(oEye setScript: eyeScript init:)
		(jEye setScript: (eyeScript new:) init:)
		(HandsOff)
		(self setScript: loadScript)
	)

	(method (dispose)
		(gLongSong fade:)
		(super dispose:)
	)
)

(instance eyeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 10))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance loadScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(= save1 1)
				(Print 32 0 #at 10 10 #dispose) ; "OH NO!" you think... "This just can't be!! Not Marie!"
				(= seconds 7)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(= seconds 7)
				(= state 6)
			)
			(3
				(= save1 1)
				(HandsOff)
				(sInset init:)
				(Say sInset 32 1) ; "What's wrong with her!"
				(= seconds 4)
			)
			(4
				(= save1 1)
				(sInset dispose:)
				(local0 setCycle: RandCycle init:)
				(Say local0 32 2) ; "Multiple stab wounds. Damage unclear."
				(= seconds 5)
			)
			(5
				(= save1 1)
				(Say local0 32 3) ; "It doesn't look good. We have to get her to the hospital STAT."
				(= seconds 6)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local0 setCycle: 0)
				(if (gEgo has: 29) ; necklace
					(= cycles 1)
				else
					(HandsOn)
					(= seconds 4)
				)
			)
			(7
				(= save1 1)
				(HandsOff)
				(oMouth dispose:)
				(jMouth setCycle: RandCycle)
				(Say jMouth 32 4) ; "We're ready. If you're goin', you'd better climb in, Officer."
				(= seconds 5)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(jMouth dispose:)
				(= cycles 1)
			)
			(9
				(ClearFlag 59)
				(gCurRoom newRoom: 30)
			)
		)
	)
)

(instance jMouth of Prop
	(properties
		x 102
		y 73
		view 390
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(jim doVerb: theVerb)
	)
)

(instance oMouth of Prop
	(properties
		x 227
		y 69
		view 390
		loop 1
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(oliver doVerb: theVerb)
	)
)

(instance mHand of Prop
	(properties
		x 125
		y 189
		view 390
		loop 2
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(switch cel
					(1
						(Print 32 5) ; "You see something clutched in Marie's hand."
					)
					(else
						(Print 32 6) ; "It's empty."
					)
				)
			)
			(3 ; Do
				(switch cel
					(1
						(self cel: 0 forceUpd:)
						(gEgo get: 29) ; necklace
						(SetScore 125 5)
						(Animate (gCast elements:) 0)
						(Print 32 7) ; "You remove what appears to be a chain from Marie's hand."
						(Print 32 8) ; "Looking at the broken chain you think... "Marie must have pulled this from the attacker's neck!""
						(Print 32 9) ; "And you ponder the thought... "I just wonder if something else was on this chain.""
					)
					(else
						(Print 32 10) ; "Her hand feels cold."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance oEye of Prop
	(properties
		x 232
		y 65
		view 390
		loop 3
		cel 3
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(oliver doVerb: theVerb)
	)
)

(instance jEye of Prop
	(properties
		x 100
		y 69
		view 390
		loop 4
		cel 3
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(jim doVerb: theVerb)
	)
)

(instance oliver of Feature
	(properties
		onMeCheck 8192
		lookStr {It's one of the paramedics.}
	)

	(method (doVerb theVerb)
		(if 5
			((= local0 oMouth) init:)
			(loadScript changeState: 3)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance jim of Feature
	(properties
		onMeCheck 16384
		lookStr {It's one of the paramedics.}
	)

	(method (doVerb theVerb)
		(if 5
			((= local0 jMouth) init:)
			(loadScript changeState: 3)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance marie of Feature
	(properties
		onMeCheck 4096
		lookStr {Marie has no color in her face and is breathing very shallow.}
	)

	(method (doVerb theVerb)
		(if 5
			(Print 32 11) ; "You try waking her, but she doesn't respond."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sInset of Prop
	(properties
		x 268
		y 136
		view 391
		priority 15
		signal 16401
	)

	(method (init)
		(super init:)
		(sMouth x: (self x:) y: (self y:) setCycle: RandCycle init:)
	)

	(method (dispose)
		(super dispose:)
		(sMouth dispose:)
	)
)

(instance sMouth of Prop
	(properties
		view 391
		loop 1
		priority 15
		signal 16400
		cycleSpeed 8
	)
)

