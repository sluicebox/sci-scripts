;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 59)
(include sci.sh)
(use Main)
(use Interface)
(use DeltaurRegion)
(use eRS)
(use Elevator)
(use Polygon)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm59 0
)

(local
	[local0 16] = [319 88 319 189 0 189 0 0 319 0 319 77 66 77 43 88]
	[local16 17] = [319 189 0 189 0 0 319 0 319 175 57 175 31 185 319 185 0]
)

(instance rm59 of SQRoom
	(properties
		lookStr {You're in a hallway on the upper level of the Deltaur.}
		picture 59
		style 11
		east 60
	)

	(method (init)
		(HandsOff)
		(self setRegions: 703) ; DeltaurRegion
		(LoadMany rsVIEW 159 464 47)
		(gFeatures
			add:
				farRightLowerYellowMach
				farRightUpperBlueMach
				popcorn
				microwave
				generator
				variousMachines
				variousLowerMachines
				rowOfLights
				otherGadgets
			eachElementDo: #init
			doit:
		)
		(LoadMany rsSOUND 361 403 622)
		(upperPoly points: @local0 size: 8)
		(lowerPoly points: @local16 size: 8)
		(if (== global166 1)
			(self addObstacle: upperPoly)
		else
			(self addObstacle: lowerPoly)
		)
		(if
			(and
				(== global166 1)
				(== (DeltaurRegion egoStatus:) 1)
				(== gPrevRoomNum east)
			)
			(or (gEgo has: 13) (IsFlag 47) (gEgo has: 12)) ; Grenade, Pulseray_Laser_Pistol
			((ScriptID 703 17) dispose:) ; sarienOfficer4
		)
		(electBall setCycle: Fwd init:)
		(lights setCycle: Fwd setScript: pulse init:)
		(gEgo init:)
		(super init:)
		(DeltaurRegion eDoor1: e1Door)
		(DeltaurRegion eDoor2: e2Door)
		(e1Door
			view: 159
			locked: 0
			loop: 0
			posn: 91 76
			lookStr:
				{This is an elevator to one of the lower levels.}
			whereTo: e2Door
			level: 1
			setPri: 4
			exiting: (< gPrevRoomNum 10)
			polyCode: goUp
			init:
		)
		(e2Door
			view: 159
			loop: 0
			locked: 0
			posn: 91 172
			setPri: 13
			lookStr:
				{This is an elevator to one of the upper levels.}
			whereTo: e1Door
			level: 2
			polyCode: goDown
			init:
		)
		(HandsOn)
	)

	(method (doit)
		(cond
			((> (gGame detailLevel:) 1)
				(if (not (lights script:))
					(lights setScript: pulse)
				)
			)
			((lights script:)
				(lights show:)
				(electBall show:)
				(lights setScript: 0)
			)
		)
		(cond
			(script 0)
			((e1Door inFront:)
				(e1Door open:)
			)
			((e2Door inFront:)
				(e2Door open:)
			)
			(
				(and
					(== global166 1)
					(== (DeltaurRegion egoStatus:) 1)
					(<= (gEgo x:) 256)
					(or (gEgo has: 13) (IsFlag 47) (gEgo has: 12)) ; Grenade, Pulseray_Laser_Pistol
				)
				(self setScript: egoLosesHelmet)
			)
		)
		(super doit:)
	)
)

(instance e1Door of Elevator
	(properties
		description {elevator door}
		sightAngle 90
		priority 2
		signal 16400
	)

	(method (doVerb theVerb)
		(if (!= global166 level)
			(Print 59 0) ; "You are on the wrong level to do that."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance e2Door of Elevator
	(properties
		description {elevator door}
		sightAngle 90
		priority 2
		signal 16400
	)

	(method (doVerb theVerb)
		(if (!= global166 level)
			(Print 59 0) ; "You are on the wrong level to do that."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance helmet of Actor
	(properties
		x 175
		y 76
		view 159
		loop 3
		cel 1
		cycleSpeed 6
		moveSpeed 6
	)
)

(instance robot of Actor
	(properties
		x 330
		y 88
		view 464
		loop 1
		priority 6
		signal 16400
		cycleSpeed 6
		xStep 5
		moveSpeed 6
	)
)

(instance goDown of Code
	(properties)

	(method (doit)
		((gCurRoom obstacles:) delete: upperPoly)
		((gCurRoom obstacles:) add: lowerPoly)
		(= global166 2)
	)
)

(instance goUp of Code
	(properties)

	(method (doit)
		((gCurRoom obstacles:) delete: lowerPoly)
		((gCurRoom obstacles:) add: upperPoly)
		(= global166 1)
	)
)

(instance electBall of Prop
	(properties
		x 236
		y 51
		lookStr {A neat gizmo.}
		view 159
		loop 2
		cel 1
		priority 1
		signal 16400
		cycleSpeed 6
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(super doVerb: theVerb &rest)
		else
			(Print 59 0) ; "You are on the wrong level to do that."
		)
	)
)

(instance lights of Prop
	(properties
		x 235
		y 115
		lookStr {A panel of flashing lights.}
		view 159
		loop 1
		cel 3
		priority 15
		signal 16400
		cycleSpeed 6
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== global166 2)
			(super doVerb: theVerb &rest)
		else
			(Print 59 0) ; "You are on the wrong level to do that."
		)
	)
)

(instance upperPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance lowerPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance helmetFlysAcrossRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(helmet setPri: 15 setMotion: JumpTo 39 29 self)
			)
			(1
				(gSoundEffects number: 361 loop: 1 play:)
				(helmet setLoop: 4 setMotion: JumpTo 86 78 self)
			)
			(2
				(gSoundEffects play:)
				(helmet setMotion: MoveTo 106 78 self)
			)
			(3
				(helmet
					cycleSpeed: 18
					yStep: (- (helmet yStep:) 1)
					setMotion: MoveTo 147 77 self
				)
			)
			(4
				(helmet setCycle: 0 setPri: -1 ignoreActors: 1 setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance egoLosesHelmet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 47 setLoop: 0 cel: 0 setCycle: CT 1 1 self)
			)
			(1
				(gEgo setCel: 1 setMotion: JumpTo 237 84 self)
			)
			(2
				(gSoundEffects number: 403 loop: 1 play:)
				(gEgo setCycle: CT 2 1 self)
			)
			(3
				(helmet
					init:
					ignoreActors: 1
					setCycle: Fwd
					setScript: helmetFlysAcrossRoom self
				)
				(gEgo setCycle: End)
			)
			(4
				(robotSound number: 622 loop: -1 play:)
				(robot
					init:
					ignoreActors: 1
					setCycle: Walk
					setLoop: 1
					setMotion: MoveTo 94 85 self
				)
			)
			(5
				(robot loop: 7 cel: 4 setCycle: Beg self)
			)
			(6
				(gEgo ignoreActors: 1)
				(robot setLoop: 0 setCycle: Walk setMotion: MoveTo 128 77 self)
			)
			(7
				(robotSound stop:)
				(helmet dispose:)
				(robot setLoop: 5 posn: 128 77 cel: 0 setCycle: End self)
			)
			(8
				(gEgo setLoop: 2 cel: 0 setCycle: CT 3 1)
				(robotSound number: 622 loop: -1 play:)
				(robot
					setLoop: 0
					setCycle: Walk
					setMotion:
						MoveTo
						(- (gEgo x:) 66)
						(- (gEgo y:) 2)
						self
				)
			)
			(9
				(robot hide:)
				(gEgo setCycle: CT 4 1 self)
			)
			(10
				(= register (gEgo cycleSpeed:))
				(gEgo cycleSpeed: (robot cycleSpeed:) setCycle: CT 9 1 self)
			)
			(11
				(gEgo
					cel: (gEgo lastCel:)
					ignoreActors: 0
					cycleSpeed: register
				)
				(robot
					show:
					setPri: (- (gEgo priority:) 1)
					posn: (- (gEgo x:) 30) (- (gEgo y:) 2)
					cel: 1
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 353 (robot y:) self
				)
			)
			(12
				(robotSound stop:)
				(robot dispose:)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(13
				(DeltaurRegion egoStatus: 2)
				(proc703_1)
				(gEgo loop: 1)
				(= ticks 18)
			)
			(14
				(Print 59 1) ; "My, aren't you the clumsy one. Because of your inability to walk without falling on your face, your helmet has been collected by the trash droid. Now you've blown your cover. The Sariens are sure to shoot first and ask questions later."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pulse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lights cycleSpeed: (* (Random 0 10) 3))
				(electBall startUpd: show:)
				(= seconds (Random 1 5))
			)
			(1
				(-= state 2)
				(electBall hide:)
				(= seconds (Random 1 5))
			)
		)
	)
)

(instance farRightLowerYellowMach of RegionFeature
	(properties
		description {gold machine}
		onMeCheck 1024
		lookStr {It's an expensive-looking machine that goes `ping.'}
		level 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 59 2) ; "You are reluctant to tarnish the shiny gold casing."
			)
			(12 ; Smell
				(Print 59 3) ; "It smells expensive."
			)
			(11 ; Taste
				(Print 59 4) ; "Not bad."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance farRightUpperBlueMach of RegionFeature
	(properties
		description {blue speaker}
		onMeCheck 64
		lookStr {It does sort of look like a speaker, doesn't it. But it isn't.}
		level 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 59 5) ; "It does sort of look like a speaker, doesn't it. But it isn't."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance popcorn of RegionFeature
	(properties
		description {purple egg thing}
		onMeCheck 16384
		lookStr {It seems obvious to you that Wally Wood did some time designing Sarien hardware.}
		level 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 59 6) ; "It looks fragile - better leave it alone."
			)
			(12 ; Smell
				(Print 59 7) ; "A subtle ozone odor clings to the egg-shaped doodad."
			)
			(11 ; Taste
				(Print 59 8) ; "Tongue-zaps are no fun."
			)
			(5 ; Talk
				(Print 59 9) ; "It crackles and hums, but does not speak."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance microwave of RegionFeature
	(properties
		description {that radio thing}
		onMeCheck 8192
		lookStr {It's either a mega-frequency wide band spectrofonic analyzer module or one of those really old table model radios.}
		level 2
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(3 ; Do
					(Print 59 10) ; "Somehow it doesn't seem wise to fiddle with it."
				)
				(11 ; Taste
					(Print 59 11) ; "The static electricity clinging to the spectrofonic module tickles your tongue, not unpleasantly."
				)
				(5 ; Talk
					(Print 59 12) ; "It seems to be saying: `And now, live from the Sobodno Ballroom in beautiful downtown Knogsville, KSAR presents Boggo Snard and his orchestra in the Sarien Swing Hour.' Of course it could be some kind of code."
					5
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance generator of RegionFeature
	(properties
		description {generator}
		onMeCheck 4096
		lookStr {Printed near the bottom in tiny precise letters are the words: Oda Generator - model EC-54 - Deltaur backup unit #1.}
		level 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 59 13) ; "You're afraid to mess with it."
			)
			(5 ; Talk
				(Print 59 14) ; "You want to talk to a generator?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance variousMachines of RegionFeature
	(properties
		description {various machines}
		onMeCheck 2048
		level 1
	)
)

(instance variousLowerMachines of RegionFeature
	(properties
		description {various machines}
		onMeCheck 2
		level 2
	)
)

(instance rowOfLights of RegionFeature
	(properties
		description {row-o-lights}
		onMeCheck 8
		lookStr {This bank of lights looks extremely important, or it would if you were a Sarien.}
		level 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 59 15) ; "You discover the lights are not flavored as you suspected."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance otherGadgets of RegionFeature
	(properties
		description {gadgets}
		onMeCheck 4
		level 1
	)
)

(instance robotSound of Sound
	(properties
		prevSignal -1
	)
)

