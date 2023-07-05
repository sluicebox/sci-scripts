;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use eRS)
(use ROsc)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm205 0
)

(local
	local0
)

(instance rm205 of FPRoom
	(properties
		picture 205
	)

	(method (init)
		(LoadMany rsSOUND 2204 2938 2208 2209 2207 2205)
		(LoadMany rsVIEW 208 207)
		(super init:)
		(fallSound number: 2207 loop: 1 play:)
		(gGame handsOff:)
		(++ gCurPuzzle)
		(gEgo put: 40) ; Open_Beer
		(gEgo get: -1 18) ; Empty_Bottles
		(freddy addToPic:)
		(snails init: setScript: sSnails)
		(people init: setCycle: Fwd setScript: sRandomHiccup)
		(vulture init: stopUpd: setScript: sGiggle)
	)

	(method (dispose)
		(gGameMusic1 fade: 0 30 12 1)
		(super dispose:)
	)
)

(instance sRandomHiccup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 240 480))
			)
			(1
				(hiccupSound number: (Random 2208 2209) play:)
				(self changeState: 0)
			)
		)
	)
)

(instance sSnails of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gGameMusic1 number: 206 flags: 1 loop: -1 play:)
				(= cycles 1)
			)
			(2
				(client setCycle: End self)
			)
			(3
				((faller new:) init: setScript: (sMarch new:))
				(client cel: 0)
				(self changeState: 2)
			)
		)
	)
)

(instance sGiggle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_9 200)
				(= seconds 30)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(giggleSound play:)
				(= local0 1)
				(people setScript: 0)
				(client setCycle: ROsc 8 1 3 self)
			)
			(3
				(= ticks 30)
			)
			(4
				(giggleSound stop:)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance sMarch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== (Random 1 10) 5) (not local0))
					(fallSound number: 2205 play:)
				)
				(client
					cycleSpeed: 6
					ignoreActors:
					setCycle: Fwd
					setLoop: 3
					setMotion: MoveTo 70 60 self
				)
			)
			(1
				(client setLoop: 4 cel: 0 setCycle: End self)
			)
			(2
				(client
					cycleSpeed: 30
					setCycle: Fwd
					setLoop: 1
					cel: 0
					setMotion: MoveTo 88 60 self
				)
			)
			(3
				(if (and (== (Random 1 10) 5) (not local0))
					(fallSound number: 2205 play:)
				)
				(client
					cycleSpeed: 6
					setCycle: Fwd
					setLoop: 3
					cel: 0
					setMotion: MoveTo 93 90 self
				)
			)
			(4
				(client setLoop: 4 cel: 0 setCycle: End self)
			)
			(5
				(client
					cycleSpeed: 30
					setCycle: Fwd
					setLoop: 1
					cel: 0
					setMotion: MoveTo 106 90 self
				)
			)
			(6
				(if (and (== (Random 1 10) 5) (not local0))
					(fallSound number: 2205 play:)
				)
				(client
					cycleSpeed: 6
					setCycle: Fwd
					setLoop: 3
					cel: 0
					setMotion: MoveTo 111 124 self
				)
			)
			(7
				(client setLoop: 4 cel: 0 setCycle: End self)
			)
			(8
				(client
					cycleSpeed: 30
					setCycle: Fwd
					ignoreActors:
					setLoop: 1
					cel: 0
					setMotion: MoveTo 149 124 self
				)
			)
			(9
				(client
					setCycle: Fwd
					setLoop: 2
					cel: 0
					setMotion: MoveTo 107 124 self
				)
			)
			(10
				(if (and (== (Random 1 10) 5) (not local0))
					(fallSound number: 2205 play:)
				)
				(client
					cycleSpeed: 6
					setLoop: 5
					cel: 0
					posn: 82 144
					setCycle: End self
				)
			)
			(11
				(if (not local0)
					(splashSound play:)
				)
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance faller of Actor
	(properties
		x 65
		y 40
		yStep 8
		view 207
		loop 3
		cel 1
		xStep 2
	)
)

(instance snails of Prop
	(properties
		y 40
		view 207
		cycleSpeed 30
	)
)

(instance people of Prop
	(properties
		x 238
		y 32
		view 208
		cel 1
		cycleSpeed 10
	)
)

(instance vulture of Prop
	(properties
		x 216
		y 89
		view 208
		loop 1
	)
)

(instance freddy of View
	(properties
		x 44
		y 35
		view 208
		loop 2
	)
)

(instance fallSound of FPSound
	(properties
		flags 1
		number 2205
	)
)

(instance hiccupSound of FPSound
	(properties
		flags 1
		number 2208
	)
)

(instance splashSound of FPSound
	(properties
		flags 1
		number 2938
	)
)

(instance giggleSound of FPSound
	(properties
		flags 1
		number 2204
		loop -1
	)
)

