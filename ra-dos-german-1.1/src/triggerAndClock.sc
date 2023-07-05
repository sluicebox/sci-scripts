;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Inset)
(use Sound)
(use Actor)
(use System)

(public
	triggerAndClock 0
)

(local
	local0
	local1
	local2
	[local3 2] = [33 18]
	[local5 5]
)

(instance triggerAndClock of Code
	(properties)

	(method (doit param1 param2)
		(if (& param1 $ff00)
			(= local0 (>> (= local0 (& param1 $f000)) $000c))
			(= local1 (>> (= local1 (& param1 $0f00)) $0008))
			(switch (= local2 (+ (* local0 100) (* 15 local1)))
				(815
					(SetFlag 1)
				)
				(1015
					(SetFlag 2)
				)
				(1115
					(SetFlag 3)
				)
				(200
					(SetFlag 4)
				)
				(300
					(SetFlag 5)
					(= global111 15)
				)
				(315
					(SetFlag 6)
				)
			)
			(gCurRoom setInset: clockInset (if (> argc 1) param2 else 0))
			(&= param1 $00ff)
		)
		(+= gMustDos param1)
	)
)

(instance saveVolume of Code
	(properties)

	(method (doit param1)
		(if (param1 handle:)
			(= [local5 (gSounds indexOf: param1)] (param1 vol:))
			(if (> [local5 (gSounds indexOf: param1)] 50)
				(param1 setVol: 50)
			)
		)
	)
)

(instance restoreVolume of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (= temp0 [local5 (gSounds indexOf: param1)])
			(param1 fade: temp0 1 5 0)
		)
	)
)

(instance sShowClock of Script
	(properties)

	(method (changeState newState &tmp [temp0 40] temp40)
		(switch (= state newState)
			(0
				(quarterHand cel: local1 init:)
				(hourHand cel: local0 init:)
				(gSounds eachElementDo: #perform saveVolume)
				(= ticks 60)
			)
			(1
				(clockSound
					number:
						(switch local1
							(0 23)
							(1 20)
							(2 21)
							(3 22)
						)
					play: self
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(gSounds eachElementDo: #perform restoreVolume)
				(if
					(= temp40
						(switch register
							(1000 -24319)
							(1245 4104)
							(145 8224)
							(245 12290)
							(else 0)
						)
					)
					((ScriptID 90 15) setReal: (ScriptID 90 15) 0 15 0 temp40) ; meetingTimer, meetingTimer
				)
				(clockInset dispose:)
			)
		)
	)
)

(instance quarterHand of View
	(properties
		x 33
		y 19
		view 22
		loop 2
		priority 15
		signal 16400
	)
)

(instance hourHand of View
	(properties
		x 33
		y 19
		view 22
		loop 1
		priority 15
		signal 16400
	)
)

(instance clockInset of Inset
	(properties
		view 22
	)

	(method (init)
		(super init: &rest)
		(self setScript: sShowClock 0 local2)
	)

	(method (handleEvent event)
		(event claimed: 1)
		(super handleEvent: event)
	)

	(method (dispose)
		(clockSound dispose:)
		(super dispose: &rest)
		(switch local2
			(1015
				((ScriptID 90 3) moveTo: -2) ; aORiley
			)
			(1115
				((ScriptID 90 1) goTo: 440) ; aCountess
				((ScriptID 90 2) goTo: 520) ; aOlympia
				((ScriptID 90 4) moveTo: -1) ; aTut
			)
			(1245
				((ScriptID 90 6) moveTo: -2) ; aYvette
			)
			(145
				((ScriptID 90 1) goTo: 520) ; aCountess
				((ScriptID 90 4) goTo: 430) ; aTut
			)
			(215
				(if (== ((gInventory at: 14) owner:) 520) ; snakeOil
					((gInventory at: 14) owner: 630) ; snakeOil
				)
			)
			(245
				((ScriptID 90 4) goTo: 510) ; aTut
				((ScriptID 90 1) goTo: 520) ; aCountess
			)
		)
		(if (and (IsFlag 1) (gCast contains: (ScriptID 35 0))) ; aPippin
			((ScriptID 35 0) dispose:) ; aPippin
		)
		(if (and (IsFlag 2) (gCast contains: (ScriptID 90 7))) ; aZiggy
			((ScriptID 90 7) wandering: 0 setScript: 0 moveTo: -2) ; aZiggy
		)
		(if (and (IsFlag 3) (gCast contains: (ScriptID 90 5))) ; aWatney
			((ScriptID 90 5) wandering: 0 setScript: 0 moveTo: -2) ; aWatney
		)
		(if (and (IsFlag 5) (gCast contains: (ScriptID 90 6))) ; aYvette
			((ScriptID 90 6) wandering: 0 setScript: 0 moveTo: -2) ; aYvette
		)
		(if (and (IsFlag 6) (gCast contains: (ScriptID 90 1))) ; aCountess
			((ScriptID 90 1) wandering: 0 setScript: 0 room: -2) ; aCountess
		)
		(DisposeScript 22)
	)
)

(instance clockSound of Sound
	(properties
		flags 1
	)
)

