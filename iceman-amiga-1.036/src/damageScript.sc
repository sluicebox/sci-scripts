;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 367)
(include sci.sh)
(use Main)
(use Interface)
(use Submarine_806)
(use System)

(public
	damageScript 0
)

(instance damageScript of Script
	(properties)

	(method (init)
		(gIceMouseDownHandler add: self)
		(gIceKeyDownHandler add: self)
		(super init: &rest)
	)

	(method (dispose)
		(gIceMouseDownHandler delete: self)
		(gIceKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (or (& (event type:) evMOUSEBUTTON) (& (event type:) evKEYBOARD))
			(self seconds: 0 cue:)
		)
	)

	(method (changeState newState)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(switch (= state newState)
			(0
				(if (& (Submarine flags:) $0004)
					(Print 367 0 #title {SONAR} #at 10 10 #width 300 #font 30 #dispose) ; "LOST CLOSED CIRCUIT TV CAMERA."
				else
					(Print 367 1 #title {SONAR} #at 10 10 #width 300 #font 30 #dispose) ; "NEGATIVE DAMAGE... ALL SYSTEMS FUNCTIONAL."
				)
				(= seconds 5)
			)
			(1
				(cond
					((& (Submarine flags:) $0002)
						(Print 367 2 #title {RADIO} #at 10 10 #width 300 #font 30 #dispose) ; "RADIO INOPERABLE."
					)
					((& (Submarine flags:) $0001)
						(Print 367 3 #title {RADIO} #at 10 10 #width 300 #font 30 #dispose) ; "MINOR ANTENNA DAMAGE... SLUGGISH RESPONSE WHEN RAISING AND LOWERING."
					)
					(else
						(Print 367 1 #title {RADIO} #at 10 10 #width 300 #font 30 #dispose) ; "NEGATIVE DAMAGE... ALL SYSTEMS FUNCTIONAL."
					)
				)
				(= seconds 5)
			)
			(2
				(Print 367 1 #title {TORPEDO} #at 10 10 #width 300 #font 30 #dispose) ; "NEGATIVE DAMAGE... ALL SYSTEMS FUNCTIONAL."
				(= seconds 5)
			)
			(3
				(Print 367 1 #title {MACHINERY} #at 10 10 #width 300 #font 30 #dispose) ; "NEGATIVE DAMAGE... ALL SYSTEMS FUNCTIONAL."
				(= seconds 5)
			)
			(4
				(Print 367 1 #title {ENGINE} #at 10 10 #width 300 #font 30 #dispose) ; "NEGATIVE DAMAGE... ALL SYSTEMS FUNCTIONAL."
				(= seconds 5)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(self dispose:)
				(DisposeScript 367)
			)
		)
	)
)

