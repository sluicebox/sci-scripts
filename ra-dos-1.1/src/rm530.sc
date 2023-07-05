;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use eRS)
(use Scaler)
(use Osc)
(use PolyPath)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm530 0
)

(instance rm530 of LBRoom
	(properties
		picture 530
		north 600
		south 510
		vanishingX 0
	)

	(method (init)
		(LoadMany rsVIEW 530 541 542 831)
		(LoadMany rsSOUND 540 541 542 543 558)
		(gEgo init: normalize: 831 setScale: Scaler 105 0 190 0)
		(self setRegions: 90) ; MuseumRgn
		(switch gPrevRoomNum
			(north
				(SetFlag 31)
				(gEgo x: 236 y: 136)
				(self setScript: sUpStairs)
			)
			(south
				(self setScript: sEnterSouth)
			)
			(else
				(gEgo posn: 65 180)
				(gGame handsOn:)
			)
		)
		(super init:)
		(if (and (IsFlag 31) (IsFlag 33))
			(gWalkHandler addToFront: wallInside pit rearStairs)
		)
		(if (IsFlag 31)
			(if (IsFlag 32)
				(darkPassage init:)
				(lightBulb init: setCel: 1)
			else
				(lightBulb init:)
			)
		else
			(doorSeam init:)
			(secretDoor addToPic:)
		)
		(windows init:)
		(stairwellWall init:)
		(hallWall init:)
		(floor init:)
		(stairs init:)
		(pit init:)
		(wallInside init:)
		(rearStairs init:)
		(socket init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 16384)
				(self setScript: sExitSouth)
			)
			((StepOn gEgo 8192)
				(self setScript: sExitSouthWalk)
			)
			((and (StepOn gEgo 8) (IsFlag 32))
				(self setScript: sFallStairs)
			)
		)
	)

	(method (dispose)
		(if (IsFlag 33)
			(gWalkHandler delete: wallInside pit rearStairs)
		)
		(super dispose:)
	)
)

(instance lightBulb of View
	(properties
		x 162
		y 109
		noun 14
		view 541
		loop 4
		priority 15
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not cel)
					(gMessager say: noun theVerb 2) ; "It's a lightbulb."
				else
					(gMessager say: noun theVerb 1) ; "It's a burned-out lightbulb. Too bad, since this stairwell could definitely use some light."
				)
			)
			(39 ; carbonPaper
				(if (not cel)
					(gCurRoom setScript: sReadCarbonPaper)
				else
					(gMessager say: noun theVerb 4) ; "It's too dark to be read this way."
				)
			)
			(4 ; Do
				(cond
					((or (gEgo has: 23) (not (IsFlag 64)) (not cel)) ; lightBulb
						(gMessager say: noun theVerb 5) ; "Ouch!"
					)
					((not cel)
						(gMessager say: noun theVerb 2) ; "You've already changed the lightbulb."
					)
					(else
						(gMessager say: noun theVerb 1) ; "There's no point in handling this burned-out lightbulb until you've got a good one to USE on it."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance darkPassage of View
	(properties
		x 111
		y 88
		noun 11
		view 530
		loop 1
		priority 5
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== (lightBulb cel:) 0)
					(gMessager say: 11 1 2) ; "The staircase is dimly illuminated by the lightbulb."
				else
					(gMessager say: 11 1) ; "You can barely see a narrow, treacherous spiral staircase descending into the depths of the black stairwell."
				)
			)
			(8 ; magnifier
				(if (== (lightBulb cel:) 0)
					(gMessager say: 11 8 2) ; "Your magnifying glass isn't much good here. You ask yourself if you're just stalling..."
				else
					(gMessager say: 11 8) ; "Your magnifying glass doesn't help. It's just too dark to see."
				)
			)
			(33 ; lightBulb
				(gCurRoom setScript: sReplaceLightBulb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance secretDoor of View
	(properties
		x 113
		y 89
		noun 10
		view 530
		priority 13
		signal 16401
	)
)

(instance windows of Feature
	(properties
		y 1
		noun 1
		sightAngle 40
		onMeCheck 2
	)
)

(instance stairs of Feature
	(properties
		y 1
		noun 6
		sightAngle 40
		onMeCheck 4
	)

	(method (initialize))
)

(instance rearStairs of Feature
	(properties
		y 1
		noun 6
		sightAngle 40
		onMeCheck 4096
	)

	(method (initialize))

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (and (IsFlag 33) (IsFlag 31))
					(gCurRoom setScript: sExitNorth)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pit of Feature
	(properties
		y 1
		noun 7
		sightAngle 40
		onMeCheck 8
	)

	(method (initialize))

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== (lightBulb cel:) 0)
					(gMessager say: 7 1 2) ; "Even with the lightbulb, you still can't see what's at the very bottom of the stairwell."
				else
					(gMessager say: 7 1) ; "A soft, will-o-the-wisp glow flickers tantalizingly somewhere at the bottom of the black stairwell."
				)
			)
			(3 ; Walk
				(if (and (IsFlag 33) (IsFlag 31))
					(gCurRoom setScript: sExitNorth)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance socket of Feature
	(properties
		y 1
		noun 9
		sightAngle 40
		onMeCheck 16
	)
)

(instance doorSeam of Feature
	(properties
		y 1
		noun 5
		sightAngle 40
		onMeCheck 32
	)
)

(instance wallInside of Feature
	(properties
		y 1
		noun 8
		sightAngle 40
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (and (IsFlag 33) (IsFlag 31))
					(gCurRoom setScript: sExitNorth)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stairwellWall of Feature
	(properties
		y 1
		noun 2
		sightAngle 40
		onMeCheck 256
	)
)

(instance hallWall of Feature
	(properties
		y 1
		noun 3
		sightAngle 40
		onMeCheck 512
	)
)

(instance floor of Feature
	(properties
		y 1
		noun 15
		sightAngle 40
		onMeCheck 1024
	)
)

(instance sReplaceLightBulb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (Sound new:))
				(gEgo setMotion: PolyPath 155 161 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo
					view: 541
					setLoop: 1
					setCel: 0
					posn: 153 158
					setCycle: CT 3 1 self
				)
			)
			(3
				(gEgo setCycle: ScrewInBulb 6 register self)
			)
			(4
				(gGame points: 1 167)
				(sFX number: 558 play:)
				(lightBulb setCel: 0)
				(darkPassage hide:)
				(= cycles 1)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				((ScriptID 21 1) doit: 792) ; dropCluesCode, Lightbulb
				(gEgo normalize: 831 loop: 6 cel: 5 posn: 152 158)
				(ClearFlag 32)
				(SetFlag 33)
				(gEgo put: 23) ; lightBulb
				(gWalkHandler addToFront: wallInside pit rearStairs)
				(lightBulb stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sReadCarbonPaper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 155 161 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo
					view: 541
					setLoop: 2
					setCel: 0
					posn: 153 158
					setCycle: End self
				)
			)
			(3
				(gMessager say: 14 39 3) ; "Backlit, you can read the words typed into the carbon paper: "Ernie, Big Al called to see if you could do some fencing for him next week. He says he'll make it worth your while to do a fast fencing job.""
				(gGame points: 1 170)
				(= cycles 1)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo
					put: 29 ; carbonPaper
					setLoop: 6
					setCel: 5
					posn: 152 158
					normalize: 831
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFallStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 167 150 self)
			)
			(1
				(gEgo
					view: 542
					setLoop: 0
					setCel: 0
					posn: 169 148
					setCycle: End self
				)
			)
			(2
				(cutPassageBottomMask init:)
				(cutFloorMask init:)
				(gEgo
					setPri: 6
					yStep: 16
					setMotion: MoveTo (gEgo x:) 183 self
				)
				(sFX number: 542 flags: 1 setLoop: 1 play:)
			)
			(3
				(gEgo hide:)
				(= ticks 120)
			)
			(4
				(sFX number: 543 play:)
				(= ticks 180)
			)
			(5
				(= global145 14) ; "Nice swan dive off the stairway."
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance cutPassageBottomMask of View
	(properties
		x 111
		y 149
		view 530
		loop 2
		priority 14
		signal 16401
	)
)

(instance cutFloorMask of View
	(properties
		x 111
		y 178
		view 530
		loop 3
		priority 15
		signal 16401
	)
)

(instance sUpStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameMusic2 number: 540 loop: -1 flags: 1 play:)
				(= cycles 3)
			)
			(1
				(gEgo setMotion: MoveTo 103 138 self)
			)
			(2
				(gEgo setMotion: MoveTo 109 161 self)
			)
			(3
				(gGameMusic2 fade:)
				(gEgo setMotion: MoveTo 147 162 self)
			)
			(4
				(WrapMusic pause: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 136 158 self)
			)
			(1
				(WrapMusic pause: 1)
				(gGameMusic2 number: 541 loop: -1 flags: 1 play:)
				(gEgo
					view: 541
					setLoop: 0
					setCel: 0
					posn: 127 165
					setPri: 12
					setCycle: End self
				)
			)
			(2
				(gEgo
					normalize: 831
					posn: 99 161
					setPri: -1
					setMotion: MoveTo 107 140 self
				)
			)
			(3
				(gEgo setMotion: PolyPath 221 147 self)
			)
			(4
				(gEgo edgeHit: EDGE_TOP)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance sExitSouthWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> (gEgo x:) 150)
					(gEgo setMotion: MoveTo 229 148 self)
				else
					(gEgo setMotion: MoveTo 88 147 self)
				)
			)
			(1
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> (Random 0 1) 0)
					(gEgo
						posn: 84 152
						setHeading: 270
						setMotion: MoveTo 58 161 self
					)
				else
					(gEgo
						posn: 238 155
						setHeading: 90
						setMotion: MoveTo 262 157 self
					)
				)
			)
			(1
				(if (and (IsFlag 31) (not (IsFlag 32)))
					(if (IsFlag 33)
						(gGame handsOn:)
						(self dispose:)
					else
						(gGame handsOn:)
						(= ticks 120)
					)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(2
				(SetFlag 32)
				(sFX number: 558 play:)
				(lightBulb setCel: 1)
				(darkPassage init:)
				(= ticks 120)
			)
			(3
				(gMessager say: 12 0 1) ; "Oh, dear, the light bulb blew out. You hope someone will invent a reliable lightbulb one of these days."
				(self dispose:)
			)
		)
	)
)

(class ScrewInBulb of Osc
	(properties
		soundOsc 1
	)

	(method (doit &tmp temp0)
		(if (or (> (= temp0 (self nextCel:)) 4) (< temp0 3))
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (init param1 param2 param3 param4)
		(if (>= argc 2)
			(= howManyCycles param2)
			(if (>= argc 3)
				(= soundOsc param3)
				(if (>= argc 4)
					(= caller param4)
				)
			)
		)
		(super init: param1 param2 param4)
	)

	(method (cycleDone)
		(soundOsc number: 553 play:)
		(super cycleDone:)
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

