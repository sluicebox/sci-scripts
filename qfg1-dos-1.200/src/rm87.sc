;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 87)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm87 0
)

(local
	local0
	local1
	[local2 14] = [297 200 241 175 194 155 168 143 150 132 134 126 119 116]
)

(instance reflection of Act
	(properties
		view 87
	)

	(method (doit)
		(self
			loop: (gEgo loop:)
			cel: (gEgo cel:)
			x: (gEgo x:)
			y: (gEgo y:)
			forceUpd:
		)
		(super doit:)
	)

	(method (canBeHere)
		(return 1)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said '/reflection,monster') (MouseClaimed self event 3))
				(HighPrint 87 0) ; "You see your own reflection in the crystal-clear waters."
			)
		)
	)
)

(instance waterfall of Prop
	(properties
		y 46
		x 300
		view 87
		loop 4
		cycleSpeed 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said '/cascade') (MouseClaimed self event 3))
				(HighPrint 87 1) ; "You see a lovely waterfall in the distance, feeding the lake with ice cold mountain water."
			)
		)
	)
)

(instance ripple1 of Act
	(properties
		y 78
		x 290
		yStep 1
		view 87
		loop 5
		cycleSpeed 2
		illegalBits 0
		xStep 1
	)
)

(instance ripple2 of Act
	(properties
		y 78
		x 290
		yStep 1
		view 87
		loop 5
		cycleSpeed 2
		illegalBits 0
		xStep 1
	)
)

(instance geese of Act
	(properties
		y 135
		x 341
		view 87
		loop 6
		illegalBits 0
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said '/sky') (Said 'look<up/'))
				(HighPrint 87 2) ; "You see a flock of geese as it passes overhead."
			)
			((or (Said '/flock,bird') (MouseClaimed self event 3))
				(HighPrint 87 3) ; "You see the reflection of a flock of geese as it passes overhead."
			)
		)
	)
)

(instance periscope of Act
	(properties
		y 241
		x 399
		view 87
		loop 7
		illegalBits 0
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed self event 3)
				(HighPrint 87 4) ; "It must be your imagination. What would a submarine be doing in a fantasy adventure? Perhaps you'd rather be playing `Code Name: Iceman' -- it has a submarine."
			)
		)
	)
)

(instance tromp of Sound
	(properties
		number 66
		priority 1
	)
)

(instance rm87 of Rm
	(properties
		picture 87
		style 0
		horizon 64
		north 81
	)

	(method (dispose)
		(SetFlag 77)
		(super dispose:)
	)

	(method (init)
		(if (and (IsFlag 77) (not (IsFlag 246)))
			(Load rsSOUND (SoundFX 66))
		)
		(Load rsVIEW 87)
		(super init:)
		(SolvePuzzle 703 1)
		(SL enable:)
		(self setLocales: 804)
		(EgoGait 0 0) ; walking
		(gEgo posn: 105 65 init: setMotion: MoveTo 105 75)
		(reflection
			ignoreActors: 1
			ignoreHorizon: 1
			setPri: 1
			posn: (gEgo x:) (gEgo y:)
			init:
		)
		(waterfall setLoop: 4 init: setCycle: Fwd)
		(if (!= gHowFast 0)
			(ripple1 setLoop: 5 ignoreActors: 1 init: setScript: rip1Script)
			(ripple2 setLoop: 5 ignoreActors: 1 init: setScript: rip2Script)
		)
		(cond
			((and (IsFlag 77) (not (IsFlag 246)))
				(periscope setLoop: 7 init: setScript: periScript)
				(SetFlag 246)
			)
			((!= gHowFast 0)
				(geese setLoop: 6 init: setScript: flockScript)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((or (Said '[use]/stealth') (Said 'run,sneak'))
						(HighPrint 87 5) ; "You don't want to do that. A walking pace is more appropriate for enjoying the majestic beauty of this scene."
					)
					((or (Said 'swim') (Said 'enter,go/water,lake'))
						(HighPrint 87 6) ; "Swimming in the Spiegelsee is a bad idea. The lake is fed from mountain run-off, and the water is ice cold."
					)
					((Said 'drink[/water]')
						(HighPrint 87 7) ; "The lake water tastes pretty good, if a bit flat."
						(if (IsFlag 201)
							(HighPrint 87 8) ; "... but this is not the water you want."
						)
					)
					(
						(or
							(Said 'use/bottle')
							(Said 'get,put/water[/bottle]')
							(Said 'get/bottle/water')
						)
						(if (gEgo has: 26) ; empty bottle
							(gEgo get: 29 use: 26 1) ; water, empty bottle
							(SetFlag 330)
							(HighPrint 87 9) ; "You fill a flask with the clear lake water."
						else
							(HighPrint 87 10) ; "You don't have anything in which to carry the water."
						)
					)
					((Said 'look>')
						(cond
							((Said '/periscope,submarine')
								(HighPrint 87 4) ; "It must be your imagination. What would a submarine be doing in a fantasy adventure? Perhaps you'd rather be playing `Code Name: Iceman' -- it has a submarine."
							)
							((or (Said '/lake,water') (Said '/[!*]'))
								(HighPrint 87 11) ; "It's the beautiful Spiegelsee (Mirror Lake). You pause for some peaceful reflection."
							)
						)
					)
				)
			)
		)
	)
)

(instance periScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< local1 7)
					(client
						setCel: local1
						setMotion:
							MoveTo
							[local2 (+ local1 local1)]
							[local2 (+ local1 local1 1)]
							self
					)
				else
					(self changeState: 2)
				)
			)
			(1
				(++ local1)
				(self changeState: 0)
			)
			(2
				(client setCel: local1)
				(tromp number: (SoundFX 66) init: play:)
				(ShakeScreen 8)
				(= seconds 2)
			)
			(3
				(client setCel: -1 cycleSpeed: 3 setCycle: End self)
			)
			(4
				(ShakeScreen 4)
				(= seconds 2)
			)
			(5
				(ShakeScreen 2)
				(client dispose:)
			)
		)
	)
)

(instance flockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(client setCycle: Fwd setMotion: MoveTo 167 221 self)
			)
			(2
				(client dispose:)
			)
		)
	)
)

(instance rip1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client posn: 300 300 setCycle: 0 stopUpd:)
				(if (not local0)
					(= local0 1)
					(self cue:)
				)
			)
			(1
				(client
					posn: (+ 290 (Random 0 10)) (Random 78 90)
					setCycle: Fwd
					setMotion: MoveTo (+ 245 (Random 0 10)) 145 self
				)
			)
			(2
				(rip2Script changeState: 1)
				(client setMotion: MoveTo (+ 200 (Random 0 24)) 189 self)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance rip2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client posn: 400 400 setCycle: 0 stopUpd:)
			)
			(1
				(client
					posn: (+ 290 (Random 0 10)) (Random 78 90)
					setCycle: Fwd
					setMotion: MoveTo (+ 245 (Random 0 10)) 145 self
				)
			)
			(2
				(rip1Script changeState: 1)
				(client setMotion: MoveTo (+ 200 (Random 0 24)) 189 self)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

