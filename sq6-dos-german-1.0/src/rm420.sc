;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use Styler)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm420 0
	Stellar_a 1
	proc420_2 2
	Stellar_b 3
	Roger 4
)

(local
	local0 = 9
	local1
	local2
)

(procedure (proc420_2)
	(ClearFlag 111)
	(ClearFlag 112)
	(Stellar_a showTalk: 1)
	((ScriptID 20 1) showTalk: 1) ; Roger
	(gCast eachElementDo: #z 0)
	((gCurRoom plane:) picture: 420)
	(UpdatePlane (gCurRoom plane:))
	(Styler doit: (gCurRoom plane:) 0)
)

(procedure (localproc_0 param1)
	(SetFlag 111)
	(SetFlag 112)
	(Stellar_a showTalk: 0)
	((ScriptID 20 1) showTalk: 0) ; Roger
	(gCast eachElementDo: #z 1000)
	(gCast doit:)
	((gCurRoom plane:) picture: param1)
	(UpdatePlane (gCurRoom plane:))
	(Styler doit: (gCurRoom plane:) 0)
)

(instance rm420 of SQRoom
	(properties
		noun 1
		picture 420
	)

	(method (init)
		(Load rsVIEW 9441)
		(Load rsVIEW 901)
		(gEgo init: normalize: setScale: 0 cel: 2 posn: 296 116)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 12 111 12 138 310 138 310 111 271 111 240 98 249 91 225 84 111 84 80 91 91 99 62 111
					yourself:
				)
		)
		(cond
			((== gPrevRoomNum 270)
				(gCurRoom setScript: sRescueDone)
			)
			((and (IsFlag 425) (not (IsFlag 160)))
				(gEgo view: 364 loop: 0 cel: 0)
				(ClearFlag 189)
				(gCurRoom setScript: sEnterRoom)
			)
			((and (== gPrevRoomNum 460) (or (== global119 0) (== global119 420)))
				(gEgo posn: 296 116 cel: 3)
				(gGame handsOn:)
			)
			((== gPrevRoomNum 460)
				(gCurRoom setScript: sExitThruComPost)
			)
			(else
				(gEgo view: 364 loop: 0 cel: 0)
				(gCurRoom setScript: sEnterRoom)
			)
		)
		(teleportOperator init:)
		(compost init: approachVerbs: 4) ; Do
		(controlPanel init:)
		(teleportArea init:)
		(greenStuff init: approachVerbs: 4) ; Do
		(pipes init:)
		(tubeTop init:)
		(tubeBottom init:)
		(structureLeft init:)
		(structureRight init:)
		(threePipes init:)
		(leftPipes init:)
		(leftTube init:)
		(dipSwitches init:)
		(leftBox init:)
		(backPad init: approachVerbs: 4) ; Do
	)
)

(instance sBeamDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 131 86 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gEgo view: 4250 setLoop: 0 setCel: 0)
				(UpdateScreenItem gEgo)
				(FrameOut)
				(gCurRoom exitStyle: 0 newRoom: 510)
			)
		)
	)
)

(instance sRescueDone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 38)
				(= local1 (gEgo cycleSpeed:))
				(Load 140 922) ; WAVE
				(Load 140 923) ; WAVE
				(Load rsVIEW 428)
				(gEgo setSpeed: 6 view: 426 x: -500)
				(= cycles 1)
			)
			(1
				(sfx1 number: 923 play:)
				(= ticks 140)
			)
			(2
				(gEgo
					setSpeed: 6
					x: 165
					y: 92
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(sfx1 stop:)
				(gEgo setLoop: 1 1 setCel: 0 setCycle: Fwd)
				(Load 140 423) ; WAVE
				(= seconds 3)
			)
			(4
				(gEgo setLoop: 2 1 setCel: 0 setCycle: CT 3 1 self)
			)
			(5
				(gEgo setCycle: End self)
				(gGSound1 fade:)
				(sfx1 number: 423 play:)
			)
			(6
				(= seconds 2)
			)
			(7
				(gEgo
					view: 427
					setLoop: 0 1
					setCel: 0
					setCycle: CT 10 1 self
				)
			)
			(8
				(aStellar
					init:
					view: 427
					posn: 155 92
					ignoreActors:
					setLoop: 1 1
					setCel: 0
					setCycle: End self
				)
				(gEgo posn: 176 101 normalize: 7)
			)
			(9
				(aStellar
					view: 428
					setLoop: 2 1
					y: (- (aStellar y:) 1)
					setCel: 0
				)
				(= cycles 1)
			)
			(10
				(gMessager sayRange: 0 0 1 1 6 self) ; "Stellar, you picked up my homing signal! I ... I can't believe I actually made it work. Now no one can say I spent a little bit too much free time in the bathroom with Popular Tecktronics."
			)
			(11
				(aStellar
					view: 4270
					setLoop: 2 1
					setCel: 0
					setCycle: Fwd
					ignoreActors:
					setMotion: MoveTo 158 105 self
				)
			)
			(12
				(gEgo setHeading: 225)
				(aStellar setLoop: 0 1 setMotion: MoveTo 212 105 self)
			)
			(13
				(gEgo setHeading: 135)
				(aStellar view: 428 setLoop: 0 1 setCel: 0 setCycle: 0)
				(Stellar_a talkLoop: 0)
				(gMessager say: 0 0 1 7 self) ; "I am. I had some leave accumulated and decided to take it. Uh, this is kind of embarrassing for me."
			)
			(14
				(= cycles 3)
			)
			(15
				(localproc_0 425)
				(stelltalk425 init: setLoop: 1 1)
				(rogeyes425 init: setCycle: Blink 200)
				(gGSound1 number: 420 setLoop: -1 play:)
				(= cycles 3)
			)
			(16
				(= ticks 120)
			)
			(17
				(stelltalk425 setLoop: 0 1)
				(gMessager say: 0 0 1 8 self) ; "I actually came to see you. I've been thinking about you a lot lately and I was curious about what you'd been up to, so I decided to visit. When I arrived here I found you had just left for shore leave on Polysorbate. I decided to follow you down and try and catch up with you."
			)
			(18
				(stelleyes425 loop: 5)
				(= cycles 3)
			)
			(19
				(gMessager say: 0 0 1 9 self) ; "When I got to that dump of an inn and found you'd been kidnapped by those thugs, I searched around but could find no trace of where they'd taken you. That certainly is a strange place."
			)
			(20
				(proc420_2)
				(rogeyes425 z: 1000)
				(= cycles 3)
			)
			(21
				(aStellar setLoop: 2 1 setCel: 0)
				(= cycles 3)
			)
			(22
				(aStellar setLoop: 1 1 setCel: 0)
				(Stellar_a talkLoop: 1)
				(= cycles 3)
			)
			(23
				(gMessager sayRange: 0 0 1 10 17 self) ; "I decided to beam back up to the deepship and try to locate you through your transport communicator signal. When I'd returned, I found you'd left it up here on the ship. I didn't know what to do then, until that call came through from the StarCon installation. You're a lucky man, Wilco."
			)
			(24
				(localproc_0 426)
				(stelltalk425 view: 4291 loop: 0 x: 160 y: 78 z: 0 setPri: 78)
				(stelleyes425 z: 1000)
				(stellRaisedBrow
					init:
					view: 4291
					loop: 2
					x: 161
					y: 49
					setPri: 49
				)
				(= cycles 3)
			)
			(25
				(stellRaisedBrow setCycle: End)
				(gMessager say: 0 0 1 18 self) ; "I'd sure like to collect that sometime."
			)
			(26
				(proc420_2)
				(stellRaisedBrow dispose:)
				(rogeyes425 z: 1000)
				(= cycles 3)
			)
			(27
				(gMessager say: 0 0 1 19 self) ; "But let's talk about you and me. Perhaps I could take you to dinner sometime soon."
			)
			(28
				(localproc_0 427)
				(stelltalk425 x: -320)
				(stelleyes425 x: -320)
				(rogmouths425
					view: 4292
					setLoop: 0 1
					setCel: 0
					z: 0
					x: 94
					y: 51
					init:
				)
				(rogeyes425 z: 1000)
				(= cycles 3)
			)
			(29
				(gMessager say: 0 0 1 20 self) ; "I'd like that, Stellar. I'd like that a lot."
			)
			(30
				(eyes427 init: setLoop: 2 1)
				(gMessager say: 0 0 1 21 self) ; "The thing is that I kind of have a ... kind of a, relationship with another and I wouldn't feel very comfortable about that. I mean, it ... it wouldn't be fair to her. Do you understand?"
			)
			(31
				(eyes427 setLoop: 3 1)
				(gMessager say: 0 0 1 22 self) ; "(TO HIMSELF) Not to mention the fact I'd be wearing my sphincter for a necklace if Beatrice ever found out."
			)
			(32
				(eyes427 setLoop: 1 1)
				(gMessager say: 0 0 1 23 self) ; "I hope you do understand, Stellar. I like you. I ... I think I even more than like you. I don't know where I got this inordinate sense of loyalty toward Beatrice."
			)
			(33
				(eyes427 setLoop: 4 1)
				(gMessager say: 0 0 1 24 self) ; "I believe the word that explains that is FEAR."
			)
			(34
				(eyes427 setLoop: 5 1)
				(gMessager say: 0 0 1 25 self) ; "Pound sand, Pal!"
			)
			(35
				(proc420_2)
				(rogeyes425 z: 1000)
				(rogmouths425 z: 1000)
				(= cycles 3)
			)
			(36
				(aStellar setLoop: 2 1 setCel: 0)
				(= cycles 3)
			)
			(37
				(aStellar setLoop: 0 1 setCel: 0)
				(Stellar_a talkLoop: 0)
				(= cycles 3)
			)
			(38
				(gMessager say: 0 0 1 28 self) ; "Please know that, were the situation any different, I'd be making that date with you right now."
			)
			(39
				(localproc_0 425)
				(stelltalk425 view: 429 loop: 0 x: 69 y: 69 setPri: 69)
				(stelleyes425 view: 429 loop: 2 x: 69 y: 40 z: 0 setPri: 40)
				(rogeyes425 z: 0)
				(= cycles 3)
			)
			(40
				(gMessager say: 0 0 1 29 self) ; "Oh, I see. Friends, coworkers, buddies -- that's all this is going to be. Guess I knew it somewhere inside, I just didn't want to believe it."
			)
			(41
				(stelleyes425 loop: 5)
				(gMessager say: 0 0 1 30 self) ; "I guess I admire your trueness of heart, however misplaced, but I feel much more inclined to damn you for it. I know, that's selfish, but it's how I feel."
			)
			(42
				(stelleyes425 loop: 4)
				(gMessager say: 0 0 1 31 self) ; "I must admit that it shows something more about you, more depth of character than I gave you credit for, Wilco. Well, I'm patient. If you ever have a change of heart ... (PAUSE)"
			)
			(43
				(proc420_2)
				(aStellar setLoop: 1 1)
				(Stellar_a talkLoop: 1)
				(rogeyes425 z: 1000)
				(rogmouths425 z: 1000)
				(= cycles 3)
			)
			(44
				(gMessager say: 0 0 2 1 self) ; "(SUDDENLY MUCH MORE BUSINESSLIKE AND PROFESSIONAL) Well, Roger, um ... we should, ah ... we should see what we can find out about those subhuman walking dumpsters that had such a keen interest in you. I don't suppose you heard their names?"
			)
			(45
				(localproc_0 428)
				(mouths427 x: -320)
				(eyes427 x: -320)
				(= cycles 3)
			)
			(46
				(gMessager say: 0 0 2 2 self) ; "No, but I did get this neat Personal Grooming Assistant. It needs a little cleaning, but ..."
			)
			(47
				(proc420_2)
				(rogeyes425 z: 1000)
				(rogmouths425 z: 1000)
				(gEgo
					view: 4293
					setLoop: 0 1
					setCel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(48
				(gEgo normalize: 4)
				(gMessager sayRange: 0 0 2 3 6 self) ; "That's great, Roger! Don't clean it, though. Take it to the Sickbay. There's a DNA analyzer there. We can scan the contents and perhaps use the results to get some names and information about these guys."
			)
			(49
				(aStellar
					view: 4270
					setLoop: 0 1
					setCycle: Fwd
					setMotion: MoveTo 281 116 self
				)
			)
			(50
				(aStellar
					view: 4280
					setLoop: 0 1
					setCel: 0
					x: 281
					y: 116
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(51
				(gGSound2 number: 926 loop: 1 play:)
				(aStellar
					setLoop: 1 1
					setCel: 0
					x: 298
					y: 114
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(52
				(gGSound1 fade:)
				(= ticks 60)
			)
			(53
				(gEgo setSpeed: local1)
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(gGSound2 number: 941 loop: 1 play:)
				(gEgo setSpeed: local0 setCycle: End self)
			)
			(2
				(gEgo normalize: setLoop: 2)
				(if (and (IsFlag 425) (not (IsFlag 160)))
					(SetFlag 160)
					(gCurRoom setScript: sBeamDown)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sExitThruComPost of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo loop: 3)
				(= ticks 40)
			)
			(1
				(gEgo setHeading: 180)
				(= ticks 90)
			)
			(2
				(gGSound2 number: 926 loop: 1 play:)
				(gEgo
					view: 3630
					loop: 0
					cel: 0
					posn: 296 116
					setSpeed: local0
					setCycle: End self
				)
			)
			(3
				(gCurRoom newRoom: global119)
				(self dispose:)
			)
		)
	)
)

(instance sTapGreenStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 3841
					cycleSpeed: 6
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gMessager say: 7 4 0 0 self) ; "You give it a tap but nothing happens."
			)
			(2
				(gEgo setSpeed: global158 normalize: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance teleportOperator of Prop
	(properties
		noun 10
		y 85
		priority 146
		fixPriority 1
		view 4201
		loop 1
		signal 20481
	)

	(method (init)
		(self setPri: 146)
		(super init:)
	)
)

(instance compost of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 296
		approachY 116
		x 287
		y 73
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 280 69 280 78 294 78 294 69
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 460)
			)
			(2 ; Talk
				(if local2
					(= temp0
						(switch (Random 0 3)
							(0
								(PlayVMD 0 {450.vmd}) ; Open
							)
							(1
								(PlayVMD 0 {500.vmd}) ; Open
							)
							(2
								(PlayVMD 0 {491.vmd}) ; Open
							)
							(3
								(PlayVMD 0 {490.vmd}) ; Open
							)
						)
					)
					(PlayVMD 14 7) ; WaitEvent
					(PlayVMD 6) ; Close
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance controlPanel of Feature
	(properties
		noun 8
		sightAngle 40
		x 42
		y 84
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 86 13 81 31 79 39 79 53 81 61 85 67 90 73 96 78 105 79 110 81 110 84 114 83 131 80 133 77 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance teleportArea of Feature
	(properties
		noun 9
		sightAngle 40
		x 164
		y 54
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 90 0 242 0 278 111 55 111
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance greenStuff of Feature
	(properties
		noun 7
		sightAngle 40
		approachX 271
		approachY 111
		x 269
		y 57
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sTapGreenStuff)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 267 41 267 57 272 57 272 41
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance pipes of Feature
	(properties
		noun 6
		sightAngle 40
		x 287
		y 56
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 254 0 268 37 267 40 267 60 269 66 304 66 318 78 320 79 319 76 305 64 271 64 272 58 272 40 257 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tubeTop of Feature
	(properties
		noun 4
		x 296
		y 56
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 278 0 315 0 315 6 304 8 286 8 277 5
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tubeBottom of Feature
	(properties
		noun 5
		sightAngle 40
		x 296
		y 114
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 287 111 304 111 314 113 314 116 305 118 287 118 278 116 278 113
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance structureLeft of Feature
	(properties
		noun 3
		sightAngle 40
		x 48
		y 46
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 25 0 0 20 0 54 26 58 25 67 0 97 0 64 93 36 85 45 62 23 45 23 53 20 53 20 84 14 84 14 53 12 53 11 41 7 38 0 38 0 28 3 28
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance structureRight of Feature
	(properties
		noun 3
		sightAngle 40
		x 277
		y 55
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 235 0 262 0 268 15 269 7 267 0 281 0 281 18 285 22 301 22 301 24 319 24 319 31 301 31 301 33 285 33 281 37 287 55 290 56 319 35 320 74 299 88 303 96 308 99 314 110 277 110 260 99 260 94 262 94 272 98
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance threePipes of Feature
	(properties
		noun 11
		sightAngle 40
		x 77
		y 47
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 77 0 68 24 64 27 64 31 73 31 82 23 83 18 90 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftPipes of Feature
	(properties
		noun 13
		sightAngle 40
		x 21
		y 47
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 0 33 25 33 48 27 52 30 55 38 51 38 25 10 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftTube of Feature
	(properties
		noun 12
		sightAngle 40
		x 33
		y 47
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 52 86 52 63 39 52 39 25 10 0 15 0 43 24 43 49 57 61 57 86
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance dipSwitches of Feature
	(properties
		noun 14
		sightAngle 40
		x 69
		y 47
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 60 36 78 36 79 33 61 33 yourself:)
		)
		(super init: &rest)
	)
)

(instance leftBox of Feature
	(properties
		noun 15
		sightAngle 40
		x 38
		y 48
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 34 32 34 26 42 26 42 32 45 32 45 39 31 39 31 32
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance backPad of Feature
	(properties
		noun 16
		sightAngle 40
		approachX 131
		approachY 86
		x 131
		y 85
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 144 86 135 87 125 87 119 85 126 83 138 83
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance aStellar of Actor
	(properties
		view 905
	)
)

(instance Stellar_a of SmallTalker
	(properties
		name {Stellar}
		talkView 428
		talkLoop 2
	)

	(method (init)
		(= client aStellar)
		(super init:)
	)
)

(instance Stellar_b of Talker
	(properties
		name {Stellar}
	)

	(method (init)
		(super init: stelltalk425 0 stelleyes425)
	)
)

(instance Roger of Talker
	(properties)

	(method (init)
		(super init: mouths427 0 eyes427)
	)
)

(instance stelltalk425 of Prop
	(properties
		x 69
		y 69
		priority 69
		fixPriority 1
		view 429
		signal 16385
	)

	(method (init)
		(super init:)
	)
)

(instance stelleyes425 of Prop
	(properties
		x 69
		y 40
		priority 40
		fixPriority 1
		view 429
		loop 2
		signal 16385
	)

	(method (init)
		(super init:)
	)
)

(instance stellRaisedBrow of Prop
	(properties
		x 161
		y 40
		priority 49
		fixPriority 1
		view 4291
		loop 2
		signal 16385
	)
)

(instance rogmouths425 of Prop
	(properties
		x 254
		y 49
		priority 49
		fixPriority 1
		view 4290
		signal 16385
	)

	(method (init)
		(super init:)
	)
)

(instance rogeyes425 of Prop
	(properties
		x 254
		y 35
		priority 35
		fixPriority 1
		view 4290
		loop 1
		signal 16385
	)

	(method (init)
		(super init:)
	)
)

(instance mouths426 of Prop ; UNUSED
	(properties
		x 160
		y 78
		priority 78
		fixPriority 1
		view 4291
		cel 6
		signal 16385
	)

	(method (init)
		(super init:)
	)
)

(instance eyes426 of Prop ; UNUSED
	(properties
		x 161
		y 49
		priority 49
		fixPriority 1
		view 4291
		loop 1
		cel 3
		signal 16385
	)

	(method (init)
		(super init:)
	)
)

(instance mouths427 of Prop
	(properties
		x 94
		y 51
		priority 51
		fixPriority 1
		view 4292
		cel 2
		signal 16385
	)

	(method (init)
		(super init:)
	)
)

(instance eyes427 of Prop
	(properties
		x 94
		y 34
		priority 34
		fixPriority 1
		view 4292
		loop 1
		cel 3
		signal 16385
	)

	(method (init)
		(super init:)
	)
)

(instance sfx1 of Sound
	(properties)
)

