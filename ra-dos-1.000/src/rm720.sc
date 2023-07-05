;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Main)
(use eRS)
(use Osc)
(use PolyPath)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Timer)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm720 0
)

(local
	local0
	local1
)

(instance rm720 of LBRoom
	(properties
		noun 23
		picture 720
		north 730
		west 715
		vanishingY -10
	)

	(method (init &tmp temp0)
		(gCurRoom obstacles: (List new:))
		((ScriptID 2720 0) doit: (gCurRoom obstacles:)) ; poly2720Code
		(gEgo init: normalize: 831 setScale: 145)
		(self setScript: sEnterWest)
		(Load rsVIEW 722)
		(LoadMany rsSOUND 48 721 722 723 736 17)
		((= temp0 (Inv at: 15)) cel: 0) ; lantern
		(temp0 cursor: 84)
		(super init:)
		(gGameMusic1 number: 720 flags: 1 loop: -1 play:)
		(steve init:)
		(stone init:)
		(maintDoor init: approachVerbs: 4) ; Do
		(furnaceDoor init: approachVerbs: 4) ; Do
		(stairs init:)
		(junk1 init:)
		(junk2 init:)
		(coal init:)
		(coalOnFace init:)
		(coalOnFaceFeat init:)
		(smellHere init:)
		(shovel1 init:)
		(coalShute init:)
		(longPipe init:)
		(bigPipes init:)
		(drain init:)
		(shovel2 init:)
		(tunnel init:)
		(pipe1 init:)
		(pipe2 init:)
		(furnace init:)
		(flames init:)
		(light1 init:)
		(light2 init:)
		(furnaceGrate init:)
	)

	(method (cue)
		(cond
			((self script:)
				(rileyTimer setReal: self 10)
				(self timer: rileyTimer)
			)
			(local0
				(gGameMusic2 number: 3 loop: 1 flags: 1 play:)
				(self setScript: sO_RileyEnters)
			)
			(else
				(self setScript: sGunShots)
			)
		)
	)

	(method (newRoom)
		(rileyTimer dispose: delete:)
		(super newRoom: &rest)
	)

	(method (dispose)
		(if (gWalkHandler contains: tunnel)
			(gWalkHandler delete: tunnel)
		)
		(DisposeScript 2720)
		(gGameMusic1 fade:)
		(super dispose:)
	)
)

(instance sGunShots of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFX number: 52 loop: 1 flags: 5 play: self)
			)
			(1
				(= ticks 30)
			)
			(2
				(sFX play: self)
			)
			(3
				(gMessager say: 22) ; "Several gunshots ring out close by. You can barely hear anguished cries and shouts over the roar of the furnace. You'd better get moving."
				(rileyTimer setReal: gCurRoom 30)
				(gCurRoom timer: rileyTimer)
				(gGameMusic2 number: 17 loop: -1 flags: 1 play:)
				(Load rsSOUND 3)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance sEnterWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 723
					setLoop: 2
					posn: 0 161
					setMotion: MoveTo 54 187 self
				)
			)
			(1
				(rileyTimer setReal: gCurRoom 0 2)
				(gCurRoom timer: rileyTimer)
				(gEgo normalize: 831 loop: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sO_RileyEnters of Script
	(properties
		name {sO'RileyEnters}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(o_Riley
					init:
					setLoop: 7
					setCycle: Walk
					setMotion: MoveTo 62 189 self
				)
				(if (< (gEgo x:) 120)
					(gEgo
						cycleSpeed: 4
						moveSpeed: 4
						setMotion: PolyPath 142 165 self
					)
				else
					(= cycles 1)
				)
			)
			(1)
			(2
				(o_Riley setPri: -1)
				(gEgo cycleSpeed: 6 moveSpeed: 6 setHeading: 270 self)
				(if (== (steve view:) 812)
					(steve setHeading: 270)
				)
			)
			(3
				(o_Riley setLoop: 5 setCel: 0 setCycle: End self)
			)
			(4
				(o_Riley setLoop: 6 setCel: 0 setCycle: CT 1 1 self)
			)
			(5
				(sFX number: 52 loop: 1 flags: 5 play:)
				(o_Riley setCycle: CT 1 1 self)
			)
			(6
				(sFX play:)
				(o_Riley setCycle: CT 0 1 self)
			)
			(7
				(gEgo
					view: 722
					setLoop: 4
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(8
				(cond
					(
						(or
							(== (steve view:) 812)
							(and
								(== (steve view:) 722)
								(== (steve loop:) 0)
								(== (steve cel:) 7)
							)
						)
						(self setScript: sKillSteve self)
					)
					((== (steve view:) 721)
						(self setScript: sKillCoalSteve self)
					)
					((== (steve view:) 722)
						(self setScript: sKillNailSteve self)
					)
				)
			)
			(9
				(= ticks 120)
			)
			(10
				(= global145 10) ; "You'll get nowhere with that holier-than-thou attitude."
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sKillSteve of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(o_Riley setLoop: 6 setCel: 0 setCycle: CT 1 1 self)
			)
			(1
				(sFX number: 52 loop: 1 flags: 5 play:)
				(o_Riley setCycle: CT 1 1 self)
			)
			(2
				(sFX play:)
				(o_Riley setCycle: CT 0 1 self)
			)
			(3
				(steve
					view: 722
					setLoop: 3
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sKillCoalSteve of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(o_Riley
					setLoop: 7
					setCycle: Walk
					setMotion: MoveTo (- (steve x:) 40) (+ (steve y:) 20) self
				)
			)
			(1
				(o_Riley setLoop: 5 setCel: 0 setCycle: End self)
			)
			(2
				(o_Riley setLoop: 6 setCel: 0 setCycle: CT 1 1 self)
			)
			(3
				(sFX number: 52 loop: 1 flags: 5 play:)
				(o_Riley setCycle: CT 1 1 self)
			)
			(4
				(sFX play:)
				(o_Riley setCycle: CT 0 1 self)
			)
			(5
				(steve setCycle: Osc 1 self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance sKillNailSteve of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(o_Riley
					setLoop: 7
					setCycle: Walk
					setMotion: MoveTo (- (steve x:) 50) (+ (steve y:) 20) self
				)
			)
			(1
				(o_Riley setLoop: 5 setCel: 0 setCycle: End self)
			)
			(2
				(o_Riley setLoop: 6 setCel: 0 setCycle: CT 1 1 self)
			)
			(3
				(sFX number: 52 loop: 1 flags: 5 play:)
				(o_Riley setCycle: CT 1 1 self)
			)
			(4
				(sFX play:)
				(o_Riley setCycle: CT 0 1 self)
			)
			(5
				(steve setCel: (- (steve cel:) 1))
				(= ticks 20)
			)
			(6
				(steve setCel: (+ (steve cel:) 1))
				(= ticks 20)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance sBurnBabyBurn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 721
					setLoop: 4
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 3 1 self
				)
			)
			(1
				(gEgo setCycle: End self)
				(furnaceDoor cycleSpeed: 12 setCycle: End)
			)
			(2
				(sFX number: 736 loop: 1 flags: 1 play:)
				(flames setCycle: End self)
			)
			(3
				(flames setCycle: Beg)
				(gEgo setLoop: 5 setCel: 0 cycleSpeed: 13 setCycle: End self)
			)
			(4
				(= ticks 120)
			)
			(5
				(= global145 2) ; "If you can't stand the heat, stay out of the furnace!"
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sRemoveCoal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 279 172 self)
			)
			(1
				(gEgo view: 721 setLoop: 0 setCel: 0 setCycle: CT 2 1 self)
			)
			(2
				(coalOnFace dispose:)
				(coalOnFaceFeat dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: 831 loop: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAwaken of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(smellHere dispose:)
				(gEgo setMotion: PolyPath 279 172 self)
			)
			(1
				(gEgo view: 721 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(steve setCycle: Osc 1 self)
			)
			(3
				(= ticks 60)
			)
			(4
				(gEgo
					normalize: 831
					loop: 0
					setMotion: PolyPath 237 165 self
				)
			)
			(5
				(gEgo setHeading: 90 self)
			)
			(6
				(steve setLoop: 2 setCel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(7
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(= seconds (if (HaveMouse) 6 else 12))
			)
			(8
				(gCurRoom setScript: sStepOnNail)
				(self dispose:)
			)
		)
	)
)

(instance sStepOnNail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(steve
					view: 722
					setLoop: 1
					setCel: 0
					posn: 265 173
					setCycle: End self
				)
			)
			(1
				(= ticks 45)
			)
			(2
				(gEgo setHeading: 135)
				(steve
					setLoop: 2
					setCel: 0
					setCycle: End self
					setMotion: MoveTo 258 182 self
				)
				(sFX number: 722 flags: 5 play:)
			)
			(3)
			(4
				(sFX fade:)
				(SetFlag 65)
				((gCurRoom obstacles:)
					delete: ((gCurRoom obstacles:) at: 0) --UNKNOWN-PROPERTY--
				)
				((ScriptID 2720 0) doit: (gCurRoom obstacles:)) ; poly2720Code
				(steve stopUpd:)
				(gTheIconBar enable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sGetUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(steve setLoop: 3 setCel: 0 setCycle: End self)
			)
			(1
				(= ticks 30)
			)
			(2
				(steve
					view: 722
					setLoop: 0
					setCel: 0
					posn: 265 173
					setCycle: CT 2 1 self
				)
			)
			(3
				(sFX number: 723 flags: 1 play:)
				(steve setCycle: End self)
			)
			(4
				(sFX stop:)
				(= local1 1)
				(steve setPri: -1 stopUpd:)
				(SetFlag 121)
				((gCurRoom obstacles:)
					delete: ((gCurRoom obstacles:) at: 0) --UNKNOWN-PROPERTY--
				)
				((ScriptID 2720 0) doit: (gCurRoom obstacles:)) ; poly2720Code
				(gMessager say: 21 2 5) ; "Ohhhh, my head...what happened? Laura?!"
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSteveHelp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(steve
					view: 724
					setPri: -1
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					moveSpeed: 6
					setCycle: Walk
					setScale: 173
					setMotion: MoveTo 230 162 self
				)
			)
			(1
				(steve setLoop: 1 setCel: 0 setMotion: MoveTo 233 154 self)
			)
			(2
				(steve setLoop: 2 setCel: 0 setMotion: MoveTo 270 153 self)
			)
			(3
				(sMoveStone cue:)
				(self dispose:)
			)
		)
	)
)

(instance sPushStone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 240 154 self)
			)
			(1
				(gEgo
					view: 721
					setLoop: 7
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 4 1 self
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gMessager say: 5 4 4) ; "The stone resists your best efforts to move it. This may be too big a job for one person to handle."
				(gEgo normalize: 831 loop: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMoveStone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 240 151 self)
				(steve setScript: sSteveHelp)
			)
			(1)
			(2
				(gEgo
					view: 721
					setLoop: 7
					setCel: 0
					cycleSpeed: 12
					setCycle: Osc 1
				)
				(steve
					view: 721
					setLoop: 6
					setCel: 0
					cycleSpeed: 12
					setCycle: Osc 1
				)
				(stone setMotion: MoveTo 176 (stone y:) self)
				(sFX number: 721 flags: 5 play:)
			)
			(3
				(sFX stop:)
				(stone stopUpd:)
				(gEgo setCycle: Beg self)
				(steve setCycle: Beg)
			)
			(4
				(gEgo normalize: 831 loop: 3)
				(steve
					view: 812
					loop: 3
					setScale: 0
					cycleSpeed: 6
					stopUpd:
					setCycle: StopWalk -1
				)
				(gWalkHandler addToFront: tunnel)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterTunnel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 251 146 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo view: 721 setLoop: 8 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo
					setLoop: 9
					setCel: 0
					posn: 253 125
					setPri: 7
					cycleSpeed: 12
					setCycle: Fwd
					setMotion: MoveTo 281 98 self
				)
			)
			(4
				(gEgo hide:)
				(steve setLoop: -1 setMotion: PolyPath 254 148 self)
			)
			(5
				(steve view: 721 setLoop: 10 setCel: 0 setCycle: End self)
			)
			(6
				(steve
					setLoop: 11
					setCel: 0
					posn: 254 129
					setPri: 7
					cycleSpeed: 9
					setCycle: Fwd
					setMotion: MoveTo 285 94 self
				)
			)
			(7
				(steve hide:)
				(gCurRoom newRoom: (gCurRoom north:))
				(self dispose:)
			)
		)
	)
)

(instance rileyTimer of Timer
	(properties)
)

(instance steve of Actor
	(properties
		x 261
		y 148
		noun 21
		view 721
		loop 1
		priority 12
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((and (== loop 1) (== view 721))
						(gMessager say: 21 1 1) ; "There's an unconscious man in the coal bin. Although the coal has dirtied his face and hair, it looks suspiciously like Steve."
					)
					((and (== loop 2) (== view 722))
						(gMessager say: 21 1 2) ; "Steve appears to be in great pain."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(27 ; cheese
				(if local1
					(gEgo put: 16) ; cheese
					((ScriptID 21 1) doit: 785) ; dropCluesCode, Cheese
					(gMessager say: 21 27) ; "Thanks, Laura! I'm starved!"
				)
			)
			(23 ; workBoot
				(if (and (== loop 2) (== view 721))
					(gEgo put: 12) ; workBoot
					((ScriptID 21 1) doit: 781) ; dropCluesCode, Work Boot
					(gCurRoom setScript: sGetUp)
				else
					(super doVerb: theVerb)
				)
			)
			(8 ; magnifier
				(if
					(or
						(== view 812)
						(and
							(== (steve view:) 722)
							(== (steve loop:) 0)
							(== (steve cel:) 7)
						)
					)
					(gMessager say: 21 8) ; "It appears to be a tall Caucasian male with smallish pores and good muscle tone."
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(if (and (== loop 1) (== view 721))
					(gEgo setMotion: PolyPath 279 172 self)
				else
					(super doVerb: theVerb)
				)
			)
			(6 ; Ask
				(if
					(or
						(== view 812)
						(and
							(== (steve view:) 722)
							(== (steve loop:) 0)
							(== (steve cel:) 7)
						)
					)
					(gMessager say: 21 6 7) ; "Let's concentrate on getting out of here, Laura. It's a little late to start asking questions."
				else
					(super doVerb: theVerb)
				)
			)
			(2 ; Talk
				(if
					(or
						(== view 812)
						(and
							(== (steve view:) 722)
							(== (steve loop:) 0)
							(== (steve cel:) 7)
						)
					)
					(gMessager say: 21 2 8) ; "I'd love to talk, Laura, but I think this would be a bad time to carry on a long conversation."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 21 4 1) ; "Steve, being the large unconscious-type stevedore he is, is immovable in his current unconscious state. And he's got coal all over his body."
	)
)

(instance o_Riley of Actor
	(properties
		name {o'Riley}
		y 163
		view 722
		loop 5
		priority 15
		signal 16400
	)
)

(instance stone of Actor
	(properties
		x 224
		y 78
		noun 5
		view 723
		loop 1
		priority 8
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and local1 (== x 224))
						(gCurRoom setScript: sMoveStone)
					)
					((and local1 (!= x 224)) 0)
					(else
						(gCurRoom setScript: sPushStone)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance furnaceDoor of Prop
	(properties
		x 141
		y 117
		noun 4
		approachX 189
		approachY 163
		view 723
		priority 11
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sBurnBabyBurn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flames of Prop
	(properties
		x 144
		y 101
		view 723
		loop 3
		priority 10
		signal 17
	)
)

(instance coalOnFace of View
	(properties
		x 297
		y 135
		view 721
		loop 13
		priority 13
		signal 16401
	)
)

(instance coalOnFaceFeat of Feature
	(properties
		y 155
		nsTop 129
		nsLeft 290
		nsBottom 139
		nsRight 301
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 21 1 1) ; "There's an unconscious man in the coal bin. Although the coal has dirtied his face and hair, it looks suspiciously like Steve."
			)
			(4 ; Do
				(gCurRoom setScript: sRemoveCoal)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance smellHere of Feature
	(properties
		y 154
		nsTop 129
		nsLeft 290
		nsBottom 139
		nsRight 301
		approachX 297
		approachY 134
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 21 1 1) ; "There's an unconscious man in the coal bin. Although the coal has dirtied his face and hair, it looks suspiciously like Steve."
			)
			(4 ; Do
				(gEgo setMotion: PolyPath 279 172 steve)
			)
			(24 ; smellingSalts
				(gCurRoom setScript: sAwaken)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stairs of Feature
	(properties
		y 1
		noun 9
		onMeCheck 2
	)
)

(instance junk1 of Feature
	(properties
		y 1
		noun 10
		onMeCheck 4
	)
)

(instance junk2 of Feature
	(properties
		y 1
		noun 11
		onMeCheck 8
	)
)

(instance coal of Feature
	(properties
		y 1
		noun 12
		onMeCheck 16
	)
)

(instance shovel1 of Feature
	(properties
		x 300
		y 1
		noun 13
		onMeCheck 32
	)
)

(instance coalShute of Feature
	(properties
		y 1
		noun 14
		onMeCheck 64
	)
)

(instance longPipe of Feature
	(properties
		y 1
		noun 15
		onMeCheck 128
	)
)

(instance bigPipes of Feature
	(properties
		y 1
		noun 16
		onMeCheck 256
	)
)

(instance drain of Feature
	(properties
		y 1
		noun 17
		onMeCheck 512
	)
)

(instance shovel2 of Feature
	(properties
		y 1
		noun 18
		onMeCheck 1024
	)
)

(instance tunnel of Feature
	(properties
		y 1
		noun 19
		onMeCheck 2048
		approachX 255
		approachY 135
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gCurRoom setScript: sEnterTunnel)
			)
			(4 ; Do
				(gCurRoom setScript: sEnterTunnel)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pipe1 of Feature
	(properties
		y 1
		noun 1
		onMeCheck 4096
	)
)

(instance pipe2 of Feature
	(properties
		y 1
		noun 2
		onMeCheck 8192
	)
)

(instance furnace of Feature
	(properties
		y 1
		noun 3
		onMeCheck 16384
	)
)

(instance light1 of Feature
	(properties
		x 64
		y 73
		noun 7
		nsTop 67
		nsLeft 59
		nsBottom 80
		nsRight 70
		sightAngle 40
	)
)

(instance light2 of Feature
	(properties
		x 232
		y 68
		noun 8
		nsTop 62
		nsLeft 225
		nsBottom 75
		nsRight 239
		sightAngle 40
	)
)

(instance furnaceGrate of Feature
	(properties
		x 158
		y 136
		noun 6
		nsTop 128
		nsLeft 141
		nsBottom 145
		nsRight 176
		sightAngle 40
	)
)

(instance maintDoor of Feature
	(properties
		y 1
		noun 20
		nsTop 86
		nsLeft 7
		nsBottom 139
		nsRight 35
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(sFXLocked play:)
				(gMessager say: 20 4) ; "This door is locked, and you don't have the proper key."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

(instance sFXLocked of Sound
	(properties
		flags 5
		number 48
	)
)

