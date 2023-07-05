;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 221)
(include sci.sh)
(use Main)
(use rm201)
(use eureka)
(use Scaler)
(use Osc)
(use Rev)
(use ScaleTo)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	asteroids 0
	asteroid1 1
	asteroid2 2
	asteroid3 3
	asteroid4 4
	sGoliathAttacks 5
	sInTheAsteroids 6
	sApproachThrakus 8
)

(local
	local0
	local1
	local2
)

(instance staticSound of Sound
	(properties
		number 222
	)
)

(instance sInTheAsteroids of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
				(gGame handsOff:)
			)
			(1
				(= global142 2)
				(= seconds 1)
			)
			(2
				(proc201_6 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 17 0 16 1 self 202) ; "We're being hailed by the Goliath, Captain. Putting it on screen."
			)
			(5
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
			)
			(6
				(self setScript: (ScriptID 209 0) self 204) ; sStartViewPort
				(gSq5Music1 number: 35 loop: -1 play:)
			)
			(7
				(gMessager say: 17 0 0 0 self 202) ; "Hello again Wilco, you insignificant little pimple on the behind of humanity."
			)
			(8
				(self setScript: (ScriptID 209 1) self) ; sStopViewPort
			)
			(9
				(gSq5Music1 number: 101 loop: -1 play: 127)
				(= seconds 3)
			)
			(10
				((ScriptID 202 13) init:) ; monitor1
				(= cycles 1)
			)
			(11
				(gMessager say: 18 0 0 0 self 202) ; "Captain, I'm going to have to make an EVA to repair the damage from the Goliath's attack."
			)
			(12
				((ScriptID 202 13) dispose:) ; monitor1
				(= seconds 4)
			)
			(13
				(staticSound loop: 1 play:)
				(= ticks 10)
			)
			(14
				(staticSound stop:)
				(gMessager say: 18 0 17 1 self 202) ; "I'm heading towards the port stabilizer."
			)
			(15
				(staticSound loop: 1 play:)
				(= ticks 10)
			)
			(16
				(staticSound stop:)
				(= seconds 3)
			)
			(17
				(gSq5Music2 number: 233 setLoop: 1 play: self)
			)
			(18
				(gSq5Music2 stop:)
				(staticSound loop: 1 play:)
				(= ticks 10)
			)
			(19
				(staticSound stop:)
				(gMessager say: 18 0 17 2 self 202) ; "Made it."
				(= register 5)
			)
			(20
				(= cycles 1)
			)
			(21
				(staticSound loop: 1 play:)
				(= ticks 10)
			)
			(22
				(staticSound stop:)
				(gSq5Music2 number: 232 loop: -1 play:)
				(= seconds 3)
			)
			(23
				(gSq5Music2 stop:)
				(staticSound loop: 1 play:)
				(= ticks 20)
			)
			(24
				(staticSound stop:)
				(gMessager say: 18 0 17 3 self 202) ; "This will only take a minute. I just need to make a few minor adjustments..."
			)
			(25
				(= cycles 1)
			)
			(26
				(staticSound loop: 1 play:)
				(= ticks 10)
			)
			(27
				(staticSound stop:)
				(gSq5Music2 number: 230 setLoop: -1 play:)
				(= seconds 4)
			)
			(28
				(gSq5Music2 stop:)
				(staticSound loop: 1 play:)
				(= ticks 10)
			)
			(29
				(staticSound stop:)
				(gMessager say: 18 0 17 4 self 202) ; "Oops."
				(Palette palSET_INTENSITY 0 255 50)
				(= register 10)
			)
			(30
				(= cycles 1)
			)
			(31
				(staticSound loop: 1 play:)
				(= ticks 10)
			)
			(32
				(staticSound stop:)
				(gSq5Music2 number: 231 loop: -1 play:)
				(= seconds 3)
			)
			(33
				(gSq5Music2 stop:)
				(staticSound loop: 1 play:)
				(= ticks 10)
			)
			(34
				(staticSound stop:)
				(gMessager say: 18 0 17 5 self 202) ; "O.K. Cap'n that's got her."
				(Palette palSET_INTENSITY 1 255 100)
			)
			(35
				(= cycles 1)
			)
			(36
				(staticSound loop: 1 play:)
				(= ticks 10)
			)
			(37
				(staticSound stop:)
				(gMessager say: 18 0 17 6 self 202) ; "I'm coming ba..."
			)
			(38
				(= cycles 1)
			)
			(39
				(staticSound loop: 1 play:)
				(= ticks 10)
			)
			(40
				(ShakeScreen 3 ssUPDOWN)
				(staticSound dispose:)
				(gSq5Music2 number: 233 setLoop: 1 play:)
				(eureka damaged: 0 hits: 0)
				(= global130 0)
				(= cycles 1)
			)
			(41
				(gSq5Music1 number: 101 loop: -1 play:)
				(= cycles 1)
			)
			(42
				(gSq5Music2 number: 206 loop: -1 play:)
				(cliffy init: setMotion: MoveTo 296 74 self)
			)
			(43
				(proc201_7 self)
			)
			(44
				(gMessager say: 18 0 59 0 self 202) ; "Say Captain, am I just seeing things, or is that gentleman floating out there in space with the surprised expression on his face our chief engineer?"
			)
			(45
				(self setScript: (ScriptID 201 8) self) ; sTurnDrooleBack
			)
			(46
				(gGame handsOn:)
				(cliffy dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sGoliathAttacks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSq5Music1 number: 38 loop: -1 play:)
				(= cycles 1)
			)
			(1
				(goliath setScript: sGoliathFires self)
			)
			(2 0)
			(3
				(cond
					((== (eureka hits:) 1)
						(self setScript: sGoliathComments self)
					)
					((and (== (eureka hits:) 2) (IsFlag 40))
						(= cycles 1)
					)
					(else
						(gCurRoom setScript: (ScriptID 210 3) 0 12) ; sBlowUpEureka
						(self dispose:)
					)
				)
			)
			(4
				(eureka setScript: 0)
				(eureka setScript: (ScriptID 210 1) 0 30) ; sGoliathTimer
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoliathComments of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc201_6 self)
			)
			(1
				(gMessager say: 13 0 13 1 self 202) ; "They shot at us!"
			)
			(2
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
				(proc201_7)
			)
			(3
				(gMessager say: 13 0 6 0 self 202) ; "A brilliant observation, Flo."
			)
			(4
				(self setScript: (ScriptID 201 8) self) ; sTurnDrooleBack
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sGoliathFires of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goliath init: setScale: ScaleTo 127 4 self)
				(torpedo init: hide:)
			)
			(1
				(torpedo setScript: sFireBall sGoliathAttacks)
				(= cycles 2)
			)
			(2
				(goliath setScale: 0 setCycle: End self)
			)
			(3
				(goliath moveSpeed: 0 setMotion: MoveTo 110 40 self)
			)
			(4
				(goliath dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sFireBall of Script
	(properties)

	(method (doit)
		(switch state
			(2
				(if (>= register 100)
					(self cue:)
				)
			)
			(3
				(if (<= register 0)
					(self cue:)
				)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(torpedo show: setMotion: MoveTo 246 27 self)
				(= cycles 2)
			)
			(1
				(gSq5Music2 number: 657 setLoop: 1 play:)
				(fireBall init:)
			)
			(2
				(for ((= register -20)) (<= register 100) ((+= register 40))
					(Palette palSET_INTENSITY 236 255 register)
				)
				(ShakeScreen 3 ssFULL_SHAKE)
				(gSq5Music2 number: 202 setLoop: 1 play:)
			)
			(3
				(for ((= register 100)) (>= register 0) ((-= register 20))
					(Palette palSET_INTENSITY 236 255 register)
				)
			)
			(4
				(eureka damaged: 1 hits: (+ (eureka hits:) 1))
				(torpedo dispose:)
				(fireBall dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sApproachThrakus of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(proc201_5 0)
				(gMessager say: 5 0 0 1 self 202) ; "No readings for the Goliath, Captain. But I am picking up an escape pod locator beacon on the planet's surface."
				(SetFlag 94)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance asteroids of View
	(properties
		view 224
		loop 2
		priority 5
		signal 16400
	)

	(method (init)
		(switch (eureka state:)
			(2
				(= local0 45)
				(= local1 10)
				(self x: (+ 130 local0) y: (+ 75 local1))
			)
			(3
				(= local1 20)
				(= local0 90)
				(if (== global113 16)
					(self x: (+ -252 local0) y: (+ 58 local1))
				else
					(self x: (+ 48 local0) y: (+ 58 local1))
				)
			)
		)
		(self
			setLoop: 2
			setCel: 0
			scaleSignal: 1
			scaleX: ((ScriptID 201 9) scaleX:) ; bigPlanet
			scaleY: ((ScriptID 201 9) scaleY:) ; bigPlanet
			maxScale: ((ScriptID 201 9) maxScale:) ; bigPlanet
			signal: 24592
		)
		(super init: &rest)
	)

	(method (doit)
		(self
			x: (+ ((ScriptID 201 9) x:) local0) ; bigPlanet
			y: (+ ((ScriptID 201 9) y:) local1) ; bigPlanet
			scaleX: ((ScriptID 201 9) scaleX:) ; bigPlanet
			scaleY: ((ScriptID 201 9) scaleY:) ; bigPlanet
			maxScale: ((ScriptID 201 9) maxScale:) ; bigPlanet
		)
		(super doit: &rest)
	)
)

(instance asteroid1 of Actor
	(properties
		x 95
		y 111
		view 220
		priority 5
		signal 16400
	)

	(method (init)
		(self setCycle: Fwd cycleSpeed: 4)
		(super init: &rest)
	)

	(method (doit)
		(self x: (+ ((ScriptID 201 9) x:) 47)) ; bigPlanet
		(super doit: &rest)
	)
)

(instance asteroid2 of Actor
	(properties
		x 253
		y 139
		view 220
		loop 1
		cel 7
		priority 5
		signal 16400
	)

	(method (init)
		(self setCycle: Rev cycleSpeed: 8)
		(super init: &rest)
	)

	(method (doit)
		(self x: (+ ((ScriptID 201 9) x:) 205)) ; bigPlanet
		(super doit: &rest)
	)

	(method (dispose)
		(gSq5Music2 stop:)
		(super dispose: &rest)
	)
)

(instance asteroid3 of Actor
	(properties
		x 174
		y 89
		view 220
		loop 2
		cel 7
		priority 5
		signal 16400
	)

	(method (doit)
		(self x: (+ ((ScriptID 201 9) x:) 126) cel: (asteroid2 cel:)) ; bigPlanet
		(super doit: &rest)
	)
)

(instance asteroid4 of Actor
	(properties
		x 206
		y 102
		view 220
		loop 3
		cel 8
		priority 5
		signal 16400
	)

	(method (doit)
		(self x: (+ ((ScriptID 201 9) x:) 158) cel: (asteroid2 cel:)) ; bigPlanet
		(super doit: &rest)
	)
)

(instance fireBall of View
	(properties
		x 183
		y 39
		view 224
		loop 5
		priority 5
		signal 16401
	)

	(method (init)
		(super init: &rest)
		(Palette palSET_INTENSITY 236 255 0)
	)
)

(instance torpedo of Actor
	(properties
		view 224
		loop 4
		priority 6
		signal 16400
	)

	(method (init)
		(self
			setLoop: 4
			setCel: 0
			x: 148
			y: 67
			scaleSignal: 1
			setStep: 20 20
			moveSpeed: 0
			ignoreActors: 1
			setScale: Scaler 20 100 67 37
		)
		(super init: &rest)
	)
)

(instance cliffy of Actor
	(properties
		view 2201
	)

	(method (init)
		(self setLoop: 4 x: 26 y: 125 setPri: 7 setCycle: Osc setSpeed: 9)
		(super init: &rest)
	)
)

(instance goliath of Actor
	(properties
		view 224
		loop 3
		priority 5
		signal 24592
	)

	(method (init)
		(self
			x: 135
			y: 65
			setLoop: 3
			setSpeed: 2
			setStep: 10 10
			ignoreActors: 1
			scaleSignal: 1
			scaleX: 8
			scaleY: 8
			maxScale: 8
		)
		(super init: &rest)
	)
)

