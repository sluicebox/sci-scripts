;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 230)
(include sci.sh)
(use Main)
(use n079)
(use n082)
(use OccCyc)
(use LarryRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use DPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm230 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 5] = [224 198 169 211 248]
	[local10 5] = [82 80 72 99 90]
	local15
	local16
	local17
	local18 = 1
	[local19 3]
	local22
)

(instance rm230 of LarryRoom
	(properties
		noun 1
		picture 230
		style 15
		horizon 0
	)

	(method (init)
		(gCurRoom
			addObstacle:
				(= local2
					((Polygon new:)
						type: PBarredAccess
						init: 41 66 30 63 31 53 58 46 72 56
						yourself:
					)
				)
				(= local3
					((Polygon new:)
						type: PBarredAccess
						init: 93 40 126 36 147 40 138 47 117 48 94 52 81 53
						yourself:
					)
				)
				(= local4
					((Polygon new:)
						type: PBarredAccess
						init: 219 40 243 43 260 45 275 48 297 59 288 63 274 63 271 58 260 58 253 51 249 55 242 53 229 47 222 50 209 48
						yourself:
					)
				)
				((Polygon new:)
					type: PContainedAccess
					init: 25 60 30 70 22 88 21 112 39 127 160 138 264 129 292 118 292 90 294 69 306 60 319 60 319 47 296 39 282 46 249 41 178 32 161 32 150 36 126 33 47 44 24 47 0 47 0 60
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 140 49 151 38 167 34 189 36 201 49
					yourself:
				)
				(= local0
					((Polygon new:)
						type: PBarredAccess
						init: 31 81 62 63 122 51 202 51 244 58 274 70 289 87 289 110 254 123 205 118 171 110 140 110 105 123 47 118 25 101
						yourself:
					)
				)
				(= local1
					((Polygon new:)
						type: PContainedAccess
						init: 103 112 157 99 168 99 222 111 264 110 275 100 267 89 245 76 215 66 154 65 110 68 84 74 63 81 45 95 46 107
						yourself:
					)
				)
		)
		(if (== gPrevRoomNum 250)
			(= style 7)
		)
		(super init: &rest)
		(SetFlag 9)
		(SetFlag 86)
		(gGlobalSound2 stop:)
		(cond
			((IsFlag 8)
				(gGlobalSound1
					number: 337
					play: 127
					setLoop: -1
					mute: 1 4
					mute: 1 5
					mute: 1 6
					mute: 1 7
					mute: 1 8
					mute: 1 9
				)
			)
			((== gPrevRoomNum 240))
			(else
				(gGlobalSound1 number: 230 play: 50 setLoop: -1 fade: 127 10 10 0)
			)
		)
		(if (== (gEgo view:) 239)
			(gEgo setCycle: Fwd xStep: 2 yStep: 2 moveSpeed: 6)
			(SetFlag 27)
		)
		(if (== (gEgo view:) 900)
			(gEgo
				normalize: 232
				ignoreActors: 0
				init:
				approachX: 162
				approachY: 133
				approachVerbs: 47 45 ; swimsuit, sunglasses
				actions: egoActions
			)
		else
			(gEgo
				normalize:
				init:
				ignoreActors: 0
				actions: egoActions
				approachX: 162
				approachY: 133
				approachVerbs: 47 45 ; swimsuit, sunglasses
			)
		)
		(gCurRoom
			setScript:
				(switch gPrevRoomNum
					(505 enterFromHall)
					(860 enterFromBeach)
					(820 enterFromWoods)
					(270 takeADive)
					(240 enterFromBar)
					(250 doTowerScene)
					(else enterFromAerobics)
				)
		)
		(chairFtr init:)
		(bushes init:)
		(poolFtr init: approachVerbs: 35 4 49) ; washcloth, Do, beaver [ inflated ]
		(aerobicsDoor
			init:
			setCel: (if (== gPrevRoomNum 440) 6 else 0)
			approachVerbs: 4 ; Do
		)
		(if (and (not (gEgo has: 2)) (not (IsFlag 174))) ; beaver
			(beaver init: approachVerbs: 4 5 ignoreActors: 1 stopUpd:) ; Do, Take
			(beavFeat init:)
		)
		(window1 init: approachVerbs: 1 4 2 6) ; Look, Do, Talk, Zipper
		(window2 init: approachVerbs: 1 4 2 6) ; Look, Do, Talk, Zipper
		(window3 init: approachVerbs: 1 4 2 6) ; Look, Do, Talk, Zipper
		(window4 init: approachVerbs: 1 4 2 6) ; Look, Do, Talk, Zipper
		(leftDoor init: approachVerbs: 1 4 3 6) ; Look, Do, Walk, Zipper
		(gWalkHandler addToFront: leftDoor)
		(if (not (IsFlag 8))
			(lifeGuard init: setPri: 3 approachVerbs: 2 4 6 50 stopUpd:) ; Talk, Do, Zipper, towerkey
			(poolBar
				init:
				setLoop: 2
				setCycle: OccCyc self 1 5 60
				setStep: 1 1
				moveSpeed: 12
				cycleSpeed: 12
				baseSetter: poolBase
				ignoreActors: 1
				approachVerbs: 1 4 ; Look, Do
			)
			(if (and (IsFlag 72) (not (IsFlag 174)))
				(poolBar posn: 236 86)
				(merr
					x: (+ (poolBar x:) 19)
					y: (+ (poolBar y:) 10)
					ignoreActors: 1
					init:
					baseSetter: merrSetter
				)
				(kenny
					x: (- (poolBar x:) 32)
					y: (- (poolBar y:) 6)
					ignoreActors: 1
					init:
					baseSetter: kennySetter
				)
				(barLady
					x: (+ (poolBar x:) 2)
					y: (+ (poolBar y:) 1)
					cel: 3
					ignoreActors: 0
					init:
				)
				(kennySetter doit:)
				(merrSetter doit:)
				(poolBase doit:)
				(if (not (IsFlag 27))
					(poolBar setScript: barFloat)
				)
			)
			(if (not (IsFlag 8))
				(bather1 init: approachVerbs: 1 4 6 2 addToPic:) ; Look, Do, Zipper, Talk
			)
			(if (not (IsFlag 8))
				(bather2 init: setPri: 2 approachVerbs: 1 4 6 2 stopUpd:) ; Look, Do, Zipper, Talk
			)
			(if (== (Random 1 4) 4)
				(bather4 init: approachVerbs: 1 4 6 2 stopUpd:) ; Look, Do, Zipper, Talk
				(if
					(and
						(not (gEgo has: 20)) ; towerkey
						(not (gCast contains: merr))
						(Random 0 1)
					)
					(bather4 ignoreActors: 0 setPri: -1 setScript: girlDiver)
				)
			)
			(if (== (Random 1 4) 4)
				(bather3 init: approachVerbs: 1 4 6 2 stopUpd:) ; Look, Do, Zipper, Talk
				(if
					(and
						(not (gEgo has: 20)) ; towerkey
						(not (gCast contains: bather4))
						(not (gCast contains: merr))
						(Random 0 1)
					)
					(bather3 ignoreActors: 0 setScript: guyDiver)
				)
			)
		)
		(towerDoor
			approachVerbs: 4 50 52 ; Do, towerkey, randomKey [ filed ]
			init:
			ignoreActors: 1
			setPri: 2
			stopUpd:
		)
		(poolEdge init: approachVerbs: 4 49) ; Do, beaver [ inflated ]
		(barWindow init:)
		(if (== gPrevRoomNum 240)
			(poolBar ignoreActors: 0)
			(merr ignoreActors: 0)
			(kenny ignoreActors: 0)
			(merrSetter doit:)
			(kennySetter doit:)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(= temp0 (gEgo edgeHit:))
		(cond
			(script 0)
			((and (not (IsFlag 4)) (== (Random 0 5000) 500))
				(if (Random 0 1)
					(bungeeJumper init: setPri: 14 setCycle: End bungeeJumper)
					(sFx number: 235 loop: 1 play:)
				else
					(bungeeJumper
						loop: 1
						init:
						setPri: 14
						setCycle: End bungeeJumper
					)
					(sFx number: 235 loop: 1 play:)
				)
			)
			((== temp0 4)
				(cond
					((gEgo has: 20) ; towerkey
						(self setScript: gimmeMyKeyDammit)
					)
					((== (gEgo view:) 236)
						(self setScript: getDecent 0 0)
					)
					(else
						(self setScript: exitWest)
					)
				)
			)
			((== temp0 2)
				(cond
					((gEgo has: 20) ; towerkey
						(self setScript: gimmeMyKeyDammit)
					)
					((== (gEgo view:) 236)
						(self setScript: getDecent 0 2)
					)
					(else
						(self setScript: exitEast)
					)
				)
			)
			(
				(and
					(OneOf (gEgo view:) 2291 229 239)
					(== (gEgo cel:) 2)
					(not (sFx handle:))
				)
				(sFx number: 233 loop: 1 play:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 27)
					(self setScript: getOffBeaver)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(49 ; beaver [ inflated ]
				(if (== (gEgo view:) 239)
					(gMessager say: 1 49 15) ; "You're already humping your beaver."
				else
					(super doVerb: theVerb)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: leftDoor)
		(if (== (gEgo view:) 232)
			(gEgo view: 900)
		)
		(ClearFlag 86)
		(gEgo approachVerbs: 0)
		(DisposeScript 964)
		(super dispose:)
	)
)

(instance handOnPoolBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo poolBar self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance enterFromBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 27)
					(gEgo x: 214 y: 98 cycleSpeed: 12 moveSpeed: 6)
					(local0 type: 3)
					(local1 type: 3)
				)
				(= cycles 2)
			)
			(1
				(if (and (IsFlag 55) (not (IsFlag 8)))
					(gMessager say: 0 0 22) ; "Shhheeeee-it!"
					(ClearFlag 55)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doTowerScene of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 86)
				(Palette palSET_FROM_RESOURCE 230 2)
				(Palette palSET_FLAG 0 255 4)
				(ClearFlag 27)
				(ClearFlag 74)
				(gEgo posn: 186 50 normalize: 232 1)
				(barLady
					view: 2321
					loop: 2
					cel: 0
					x: 171
					y: 52
					ignoreActors: 0
					init:
				)
				(= cycles 2)
			)
			(1
				(gCurRoom showControls: 1)
				(gGame controlsVisible: 0 drawControls:)
				(= cycles 2)
			)
			(2
				(towerDoor dispose:)
				(= seconds 3)
			)
			(3
				(gMessager say: 1 0 14 0 self) ; "Oh, Larry, I hope your key works as well as that transition; I thought we were going to have to wait around until night fell, or something!"
			)
			(4
				(barLady cycleSpeed: 12 setCycle: End self)
			)
			(5
				(sFx number: 32 loop: 1 play:)
				(towerDoor init: setCel: 5)
				(barLady
					setLoop: 0
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 169 47 self
				)
			)
			(6
				(barLady
					setLoop: 3
					setPri: 1
					setCycle: Fwd
					moveSpeed: 10
					cycleSpeed: 10
					setMotion: MoveTo 169 1 self
				)
			)
			(7
				(barLady dispose:)
				(gEgo setMotion: MoveTo 169 50 self)
			)
			(8
				(gEgo
					view: 238
					setLoop: 6
					setCycle: Walk
					setMotion: MoveTo 169 46 self
				)
			)
			(9
				(towerDoor setCycle: Beg self)
			)
			(10
				(sFx number: 33 loop: 1 play:)
				(gEgo
					moveSpeed: 8
					cycleSpeed: 10
					setPri: 1
					setMotion: MoveTo 169 1 self
				)
			)
			(11
				(Palette palUNSET_FLAG 0 255 4)
				(ClearFlag 86)
				(gCurRoom newRoom: 260)
			)
		)
	)
)

(instance enterHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 33 43 self)
			)
			(1
				(if (IsFlag 168)
					(SetFlag 72)
				)
				(gGlobalSound1 fade:)
				(gCurRoom newRoom: 505)
			)
		)
	)
)

(instance gimmeMyKeyDammit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 21 0 6 0 self) ; "(SHOUTING ANGRILY) Hey! You!! Yeah, you! Get back here with my key!"
			)
			(1
				(gEgo setMotion: PolyPath 35 65 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getDecent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 21 0 5 0 self) ; "Hey, you! Local community standards as well as national health codes prohibit the wearing of floss swimsuits in our public areas."
			)
			(1
				(switch register
					(0
						(gEgo setMotion: PolyPath 35 65 self)
					)
					(1
						(self cue:)
					)
					(2
						(gEgo
							setMotion:
								PolyPath
								(- (gEgo x:) 5)
								(gEgo y:)
								self
						)
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTowerKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 30 66 self)
			)
			(1
				(cond
					((and (IsFlag 166) (not (IsFlag 90)))
						(gMessager say: 16 2 21 0 self) ; "Mr. Billy, I've decided I'm more than "Man Enough!""
					)
					((IsFlag 166)
						(gMessager say: 16 2 17 0 self) ; "Hi, Billy. It's me, Larry. May I please borrow your key again?"
					)
					((not local16)
						(= local16 1)
						(gMessager say: 16 2 1 1 5 self) ; "I notice people are getting something from you. What is it? May I get something, too?"
					)
					(else
						(gMessager say: 16 2 16 0 self) ; "May I please have the key to the diving tower? I'm more than willing to display my qualifications."
					)
				)
			)
			(2
				(if (not local18)
					(gMessager say: 16 2 18) ; "Well, then, I guess there's no problem!"
					(gEgo normalize:)
					(gGame handsOn:)
					(self dispose:)
				else
					(gMessager say: 16 2 1 6 self) ; "Here ya go, bud!"
				)
			)
			(3
				(lifeGuard hide:)
				(gEgo
					view: 237
					setSpeed: 6
					loop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(lifeGuard show:)
				(gEgo get: 20 normalize: 236 ignoreActors: 0) ; towerkey
				(gGame handsOn: changeScore: 6 166)
				(self dispose:)
			)
		)
	)
)

(instance openTowerDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 171 53 self)
			)
			(1
				(gEgo
					view: 238
					setSpeed: 12
					loop: 2
					setCel: 0
					setCycle: End self
				)
				(towerDoor dispose:)
				(sFx number: 32 loop: 1 play:)
			)
			(2
				(gEgo normalize: 236 3 setMotion: MoveTo 169 47 self)
			)
			(3
				(towerDoor init: setCel: 5 setCycle: Beg self)
			)
			(4
				(sFx number: 33 loop: 1 play:)
				(gEgo
					view: 238
					ignoreActors: 1
					setPri: 1
					setLoop: 1
					setSpeed: 12
					setCycle: Fwd
					setMotion: MoveTo 169 1 self
				)
			)
			(5
				(if (IsFlag 168)
					(SetFlag 72)
				)
				(gGlobalSound1 fade:)
				(gCurRoom newRoom: 270)
			)
		)
	)
)

(instance takeADive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 27)
				(local0 type: 3)
				(local1 type: 3)
				(if (poolBar script:)
					((poolBar script:) dispose:)
				)
				(gEgo view: 238 hide: setLoop: 0 posn: 168 0)
				(= ticks 210)
			)
			(1
				(sFx number: 271 loop: 1 play: 1 self fade: 127 5 35 0)
				(gEgo
					show:
					moveSpeed: 0
					setPri: 14
					setMotion: MoveTo 168 62 self
				)
			)
			(2)
			(3
				(gEgo setCycle: 0 setLoop: 3 setCel: 0)
				(= ticks 18)
			)
			(4
				(gEgo setMotion: MoveTo 168 72 self)
			)
			(5
				(gEgo setSpeed: 12 setCycle: End self)
				(sFx number: 231 loop: 1 play:)
			)
			(6
				(gEgo hide:)
				(= ticks 300)
			)
			(7
				(gEgo show: loop: 5 setCel: 0 setCycle: End self)
			)
			(8
				(sFx number: 385 loop: 1 play:)
				(gMessager say: 1 0 2 1 2 self) ; "(SCREAMING IN PAIN) YEEEEEEEE- OOOOOOO- WWWWWWWWW!!!!!!"
			)
			(9
				(gGame handsOn:)
				(SetFlag 90)
				(gEgo
					normalize: 229
					cycleSpeed: 12
					moveSpeed: 6
					ignoreActors: 0
					setCycle: poolWalker
					xStep: 2
					yStep: 2
				)
				(barLady dispose:)
				(poolBar ignoreActors: 0)
				(merr ignoreActors: 0)
				(kenny ignoreActors: 0)
				(merrSetter doit:)
				(kennySetter doit:)
				(poolBase doit:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveBackKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					normalize: 236
					ignoreActors: 0
					setCycle: Walk
					setMotion: PolyPath 30 66 self
				)
			)
			(1
				(if (IsFlag 90)
					(gMessager say: 1 0 2 3 4 self) ; "Here's your key back, Mr. Dee. Or may I call you Billy?"
				else
					(gMessager say: 16 50 21 0 self) ; "Too scared to dive, huh? Happens to a lot of our guests. None of the real men, of course, but a lot of the women and "others.""
				)
			)
			(2
				(gEgo
					view: 237
					setSpeed: 6
					loop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo put: 20 normalize: 236 1 ignoreActors: 0) ; towerkey
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 30)
			)
			(1
				(gEgo setMotion: MoveTo 330 (gEgo y:) self)
			)
			(2
				(if (IsFlag 168)
					(SetFlag 72)
				)
				(gGlobalSound1 fade:)
				(gCurRoom newRoom: 860)
			)
		)
	)
)

(instance exitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 30)
			)
			(1
				(gEgo setMotion: MoveTo -10 (gEgo y:) self)
			)
			(2
				(if (IsFlag 168)
					(SetFlag 72)
				)
				(gGlobalSound1 fade:)
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance enterFromHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 39 44 setMotion: PolyPath 39 47 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (and (IsFlag 55) (not (IsFlag 8)))
					(gMessager say: 0 0 22 0 self) ; "Shhheeeee-it!"
					(ClearFlag 55)
				else
					(self cue:)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromBeach of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo posn: 330 52 setMotion: MoveTo 312 52 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (and (IsFlag 55) (not (IsFlag 8)))
					(gMessager say: 0 0 22 0 self) ; "Shhheeeee-it!"
					(ClearFlag 55)
				else
					(self cue:)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromAerobics of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(ClearFlag 9)
				(gEgo
					view: 232
					posn: 300 41
					init:
					setStep: 2 1
					setMotion: PolyPath 295 45 self
				)
			)
			(1
				(aerobicsDoor setCycle: Beg self)
			)
			(2
				(sFx number: 33 loop: 1 play: 127)
				(aerobicsDoor stopUpd:)
				(gEgo normalize: 232 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromWoods of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: -10 55 setMotion: MoveTo 5 55 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (and (IsFlag 55) (not (IsFlag 8)))
					(gMessager say: 0 0 22 0 self) ; "Shhheeeee-it!"
					(ClearFlag 55)
				else
					(self cue:)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wateryDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((< (gEgo y:) 70)
						(= local17 1)
						(gEgo setMotion: PolyPath 168 50 self)
					)
					((> (gEgo y:) 100)
						(= local17 3)
						(gEgo setMotion: PolyPath 160 103 self)
					)
					((< (gEgo x:) 50)
						(= local17 4)
						(gEgo setMotion: PolyPath 28 89 self)
					)
					(else
						(= local17 2)
						(gEgo setMotion: PolyPath 290 89 self)
					)
				)
			)
			(1
				(if (== local17 3)
					(gEgo setMotion: MoveTo 160 99 self)
				else
					(self cue:)
				)
			)
			(2
				(gMessager say: 2 4 0 1 self) ; "You're still wearing your leisure suit, but what the hell, right?"
			)
			(3
				(gEgo
					view: 231
					loop:
						(switch local17
							(1 2)
							(3 3)
							(2 1)
							(4 0)
						)
					setCel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(4
				(sFx number: 231 loop: 1 play:)
				(gMessager say: 2 4 0 2 4 self) ; "The sodden leisure suit starts to pull you under the surface! Horrors!"
			)
			(5
				(EgoDead 5 self)
			)
			(6
				(if (== local17 3)
					(gEgo y: 110)
				)
				(gEgo normalize: 232 0 1 ignoreActors: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance jumpInPool of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 160 110 self)
			)
			(1
				(gEgo setMotion: MoveTo 160 100 self)
			)
			(2
				(gEgo
					normalize: 229
					ignoreActors: 0
					cycleSpeed: 12
					moveSpeed: 6
					setCycle: poolWalker
				)
				(poolBar ignoreActors: 0)
				(merr ignoreActors: 0)
				(kenny ignoreActors: 0)
				(merrSetter doit:)
				(kennySetter doit:)
				(local0 type: 3)
				(local1 type: 3)
				(SetFlag 27)
				(gEgo xStep: 2 yStep: 2)
				(if (poolBar script:)
					((poolBar script:) dispose:)
					(poolBar ignoreActors: 0)
					(merr ignoreActors: 0)
					(kenny ignoreActors: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance barFloat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 30))
			)
			(1
				(barLady dispose:)
				(if (IsFlag 27)
					(self cue:)
				)
				(kenny ignoreActors: 1)
				(merr ignoreActors: 1)
				(if (== local15 4)
					(= local15 0)
				else
					(++ local15)
				)
				(poolBar
					setMotion: MoveTo [local5 local15] [local10 local15] self
				)
			)
			(2
				(merr ignoreActors: 0)
				(kenny ignoreActors: 0)
				(merrSetter doit:)
				(kennySetter doit:)
				(= seconds (Random 5 30))
			)
			(3
				(if (Random 0 1)
					(barLady
						init:
						x: (+ (poolBar x:) 2)
						y: (+ (poolBar y:) 1)
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance changeClothes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 162 133 self)
			)
			(1
				(if (== (gEgo view:) 236)
					(self setScript: wearSuit self)
				else
					(self setScript: wearSwimsuit self)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wearSuit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 235
					setSpeed: 12
					loop: 4
					setCel: 4
					setCycle: Beg self
				)
			)
			(1
				(gEgo loop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo normalize: 232)
				(ClearFlag 74)
				(self dispose:)
			)
		)
	)
)

(instance wearSwimsuit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 235
					setSpeed: 12
					loop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo loop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo loop: 3 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: 4 setCel: 0 setCycle: End self)
			)
			(4
				(SetFlag 74)
				(gGame changeScore: 12 165)
				(gEgo normalize: 236)
				(self dispose:)
			)
		)
	)
)

(instance getOnBeaver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 160 110 self)
			)
			(1
				(gEgo setMotion: MoveTo 160 100 self)
			)
			(2
				(SetFlag 27)
				(if (poolBar script:)
					((poolBar script:) dispose:)
				)
				(poolBar ignoreActors: 0)
				(if (gCast contains: kenny)
					(kenny ignoreActors: 0)
					(merr ignoreActors: 0)
				)
				(local0 type: 3)
				(local1 type: 3)
				(gEgo
					normalize: 239
					cycleSpeed: 12
					moveSpeed: 6
					ignoreActors: 0
					posn: 160 100
					xStep: 2
					yStep: 2
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getOffBeaver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(local0 type: 2)
				(local1 type: 2)
				(gEgo
					normalize: 236
					ignoreActors: 0
					actions: egoActions
					approachX: 162
					approachY: 133
					approachVerbs: 47 45 ; swimsuit, sunglasses
				)
				(ClearFlag 27)
				(gEgo setCycle: Walk setMotion: MoveTo 160 110 self)
			)
			(1
				(poolBar ignoreActors: 1)
				(if (gCast contains: merr)
					(kenny ignoreActors: 1)
					(merr ignoreActors: 1)
					(poolBar setScript: barFloat)
				)
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance girlDiver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client init:)
				(= seconds 3)
			)
			(1
				(bather4
					init:
					view: 233
					loop: 10
					setCel: 4
					cycleSpeed: 12
					ignoreActors: 0
					approachVerbs: 0
					setCycle: Beg self
				)
			)
			(2
				(client
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 6
					setMotion: MoveTo 31 68 self
				)
			)
			(3
				(= ticks 120)
			)
			(4
				(lifeGuard hide:)
				(client
					view: 237
					cycleSpeed: 12
					loop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(5
				(= local18 0)
				(lifeGuard show:)
				(client
					view: 233
					cycleSpeed: 6
					setCycle: Walk
					setMotion: PolyPath 171 52 self
				)
			)
			(6
				(client setMotion: MoveTo 171 52 self)
			)
			(7
				(towerDoor hide:)
				(client
					view: 237
					loop: 6
					cycleSpeed: 12
					setCel: 0
					setCycle: End self
				)
				(sFx number: 32 loop: 1 play:)
			)
			(8
				(client
					view: 233
					setPri: 1
					setCycle: Walk
					cycleSpeed: 6
					setMotion: MoveTo 169 48 self
				)
			)
			(9
				(towerDoor show: stopUpd:)
				(sFx number: 33 loop: 1 play:)
				(client
					view: 237
					setLoop: 4
					setCycle: Fwd
					ignoreActors: 1
					setMotion: MoveTo 169 0 self
				)
			)
			(10
				(client setLoop: -1 hide:)
				(= seconds 7)
			)
			(11
				(client
					view: 237
					show:
					setLoop: 9
					setCel: 0
					setCycle: 0
					setPri: 3
					moveSpeed: 0
					setMotion: MoveTo 169 74 self
				)
			)
			(12
				(client
					loop: 7
					setCel: 0
					setPri: -1
					ignoreActors: 0
					setCycle: End self
				)
				(sFx number: 231 loop: 1 play:)
			)
			(13
				(client hide:)
				(= ticks 180)
			)
			(14
				(client
					show:
					posn: 92 56
					view: 233
					setLoop: 9
					setCel: 0
					moveSpeed: 6
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(15
				(client
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 6
					setMotion: PolyPath 31 68 self
				)
			)
			(16
				(lifeGuard hide:)
				(client
					view: 237
					loop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(17
				(= local18 1)
				(lifeGuard show:)
				(client
					view: 233
					setCycle: Walk
					cycleSpeed: 6
					setMotion: MoveTo 92 52 self
				)
			)
			(18
				(client loop: 10 cycleSpeed: 12 setCel: 0 setCycle: End self)
			)
			(19
				(client
					view: 230
					cycleSpeed: 6
					loop: 8
					cel: 5
					setPri: 1
					approachVerbs: 1 4 6 2 ; Look, Do, Zipper, Talk
					stopUpd:
				)
				(self dispose:)
			)
		)
	)
)

(instance guyDiver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client init:)
				(= seconds 3)
			)
			(1
				(bather3
					init:
					view: 234
					loop: 10
					cycleSpeed: 12
					setCel: 4
					ignoreActors: 0
					approachVerbs: 0
					setCycle: Beg self
				)
			)
			(2
				(client
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 6
					setMotion: DPath 224 52 194 50 124 51 78 57 31 68 self
				)
			)
			(3
				(lifeGuard hide:)
				(bather3
					view: 237
					loop: 1
					cycleSpeed: 12
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(= local18 0)
				(lifeGuard show:)
				(bather3
					view: 234
					setCycle: Walk
					cycleSpeed: 6
					setMotion: DPath 82 56 123 51 171 52 self
				)
			)
			(5
				(towerDoor hide:)
				(bather3
					view: 237
					loop: 5
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
				(sFx number: 32 loop: 1 play:)
			)
			(6
				(bather3
					view: 234
					setCycle: Walk
					setPri: 1
					cycleSpeed: 6
					setMotion: MoveTo 169 48 self
				)
			)
			(7
				(sFx number: 33 loop: 1 play:)
				(towerDoor show: stopUpd:)
				(bather3
					view: 237
					setLoop: 3
					setCycle: Fwd
					ignoreActors: 1
					setMotion: MoveTo 169 0 self
				)
			)
			(8
				(bather3 setLoop: -1 hide:)
				(= seconds 7)
			)
			(9
				(bather3
					view: 237
					show:
					setLoop: 9
					setCel: 1
					setCycle: 0
					setPri: 3
					moveSpeed: 0
					setMotion: MoveTo 169 74 self
				)
			)
			(10
				(bather3
					loop: 8
					setCel: 0
					setPri: -1
					cycleSpeed: 12
					ignoreActors: 0
					setCycle: End self
				)
				(sFx number: 231 loop: 1 play:)
			)
			(11
				(bather3 hide:)
				(= ticks 180)
			)
			(12
				(bather3
					show:
					posn: 92 56
					view: 234
					setLoop: 9
					setCel: 0
					moveSpeed: 6
					setCycle: End self
				)
			)
			(13
				(bather3
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 6
					setMotion: PolyPath 31 68 self
				)
			)
			(14
				(lifeGuard hide:)
				(bather3
					view: 237
					loop: 1
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(15
				(= local18 1)
				(lifeGuard show:)
				(bather3
					view: 234
					setCycle: Walk
					cycleSpeed: 6
					setMotion: DPath 78 57 124 51 194 50 224 52 279 63 self
				)
			)
			(16
				(bather3 loop: 10 setCel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(17
				(bather3
					view: 230
					loop: 8
					cycleSpeed: 6
					cel: 6
					approachVerbs: 1 4 6 2 ; Look, Do, Zipper, Talk
					stopUpd:
				)
				(self dispose:)
			)
		)
	)
)

(instance toAerobics of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aerobicsDoor setCycle: End self)
				(sFx number: 32 loop: 1 setVol: 127 play:)
				(gGlobalSound1 fade:)
			)
			(1
				(gEgo setMotion: MoveTo 304 40 self)
			)
			(2
				(gCurRoom newRoom: 440)
			)
		)
	)
)

(instance poolBar of Actor
	(properties
		x 212
		y 98
		noun 4
		view 230
		loop 2
	)

	(method (cue)
		(self doVerb: local22)
	)

	(method (onMe param1)
		(return
			(if (super onMe: param1)
				(= approachX (- (self x:) 20))
				(= approachY (+ (self y:) 15))
				1
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= local22 (event message:))
				(event claimed: 1)
				(gEgo
					setMotion:
						(poolyPath new:)
						approachX
						(+ (gEgo z:) approachY)
						self
				)
			)
		)
		(event claimed:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((== (gEgo view:) 239)
						(if (IsFlag 72)
							(gCurRoom newRoom: 240)
						else
							(gMessager say: 4 1 4) ; "The pool bar is moored to the side pool, unoccupied."
							(return 1)
						)
					)
					((OneOf (gEgo view:) 2291 229)
						(gMessager say: 4 1 13) ; "From here in the water, you notice everyone sitting around the bar is riding an inflatable device."
						(return 1)
					)
					((not (IsFlag 168))
						(gCurRoom setScript: handOnPoolBar)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(4 ; Do
				(cond
					((== (gEgo view:) 239)
						(if (IsFlag 72)
							(gCurRoom newRoom: 240)
						else
							(gMessager say: 4 1 4) ; "The pool bar is moored to the side pool, unoccupied."
							(return 1)
						)
					)
					((OneOf (gEgo view:) 2291 229)
						(gMessager say: 4 4 13) ; "Unfortunately, guests are only allowed to drink at the pool's floating bar if they have an adequate approved flotation device."
						(return 1)
					)
					((not (IsFlag 168))
						(gCurRoom setScript: handOnPoolBar)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bungeeJumper of Prop
	(properties
		x 170
		view 228
	)

	(method (cue)
		(self dispose:)
	)
)

(instance barLady of Actor
	(properties
		noun 28
		view 228
		loop 2
	)

	(method (onMe)
		(return 0)
	)

	(method (doVerb theVerb)
		(poolBar doVerb: theVerb)
	)
)

(instance towerDoor of Prop
	(properties
		x 161
		y 27
		noun 5
		approachX 166
		approachY 46
		view 230
		loop 1
	)

	(method (doVerb theVerb)
		(if (IsFlag 27)
			(gMessager say: 1 0 13) ; "You might be able to do that if you weren't so worried about drowning at the moment!"
			(return 1)
		else
			(switch theVerb
				(4 ; Do
					(sFx number: 34 loop: 1 play: 127)
					(super doVerb: theVerb)
				)
				(50 ; towerkey
					(gCurRoom setScript: openTowerDoor)
				)
				(52 ; randomKey [ filed ]
					(sFx number: 34 loop: 1 play: 127)
					(super doVerb: theVerb)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance bather1 of View
	(properties
		x 59
		y 52
		noun 12
		approachX 67
		approachY 50
		view 230
		loop 8
		priority 2
		signal 16
	)

	(method (doVerb theVerb)
		(if (IsFlag 27)
			(gMessager say: 1 0 13) ; "You might be able to do that if you weren't so worried about drowning at the moment!"
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bather2 of View
	(properties
		x 223
		y 44
		noun 13
		approachX 209
		approachY 44
		view 230
		loop 8
		cel 1
		priority 1
		signal 16
	)

	(method (doVerb theVerb)
		(if (IsFlag 27)
			(gMessager say: 1 0 13) ; "You might be able to do that if you weren't so worried about drowning at the moment!"
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bather3 of Actor
	(properties
		x 279
		y 63
		noun 14
		approachX 265
		approachY 45
		view 230
		loop 8
		cel 6
	)

	(method (doVerb theVerb)
		(if (IsFlag 27)
			(gMessager say: 1 0 13) ; "You might be able to do that if you weren't so worried about drowning at the moment!"
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bather4 of Actor
	(properties
		x 92
		y 52
		noun 15
		approachX 108
		approachY 51
		view 230
		loop 8
		cel 5
		priority 1
		signal 16
	)

	(method (doVerb theVerb)
		(if (IsFlag 27)
			(gMessager say: 1 0 13) ; "You might be able to do that if you weren't so worried about drowning at the moment!"
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lifeGuard of View
	(properties
		x 21
		y 45
		noun 16
		approachX 31
		approachY 69
		view 230
		loop 7
	)

	(method (doVerb theVerb)
		(if (IsFlag 27)
			(gMessager say: 1 0 13) ; "You might be able to do that if you weren't so worried about drowning at the moment!"
			(return 1)
		else
			(switch theVerb
				(2 ; Talk
					(cond
						((== (gEgo view:) 232)
							(gMessager say: 16 2) ; "Hello. My name is Larry; Larry Laffer. I'd like to go swimming here."
							(return 1)
						)
						((gEgo has: 20) ; towerkey
							(gCurRoom setScript: giveBackKey)
						)
						(else
							(gCurRoom setScript: getTowerKey)
						)
					)
				)
				(50 ; towerkey
					(gCurRoom setScript: giveBackKey)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance beaver of View
	(properties
		x 205
		y 41
		noun 22
		approachX 205
		approachY 45
		view 230
		loop 6
	)

	(method (doVerb theVerb)
		(cond
			((IsFlag 27)
				(gMessager say: 1 0 13) ; "You might be able to do that if you weren't so worried about drowning at the moment!"
				(return 1)
			)
			((== theVerb 5) ; Take
				(gEgo get: 2) ; beaver
				(gGame changeScore: 3 167)
				(beavFeat dispose:)
				(gMessager say: 22 5) ; "You grab yourself a swimming pool float in the shape of a beaver."
				(self dispose:)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance kenny of Actor
	(properties
		noun 26
		view 230
		loop 9
		cel 1
	)
)

(instance merr of Actor
	(properties
		noun 27
		view 230
		loop 9
	)

	(method (doit)
		(if (poolBar mover:)
			(merr posn: (+ (poolBar x:) 19) (+ (poolBar y:) 10))
			(kenny posn: (- (poolBar x:) 32) (- (poolBar y:) 6))
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 7)
					(gMessager say: 27 1 20) ; "That's the 600-denier redhead wearing the 6-denier bikini."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aerobicsDoor of Prop
	(properties
		x 297
		y 19
		noun 11
		approachX 300
		approachY 41
		view 230
		loop 10
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb)
		(if (IsFlag 27)
			(gMessager say: 1 0 13) ; "You might be able to do that if you weren't so worried about drowning at the moment!"
			(return 1)
		)
		(return
			(if (== theVerb 4) ; Do
				(cond
					((gEgo has: 20) ; towerkey
						(gCurRoom setScript: gimmeMyKeyDammit)
					)
					((== (gEgo view:) 236)
						(gCurRoom setScript: getDecent 0 1)
					)
					(else
						(if (IsFlag 168)
							(SetFlag 72)
						)
						(gCurRoom setScript: toAerobics)
					)
				)
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poolEdge of Feature
	(properties
		noun 1
		approachX 160
		approachY 99
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance leftDoor of Feature
	(properties
		x 43
		y 40
		noun 11
		nsTop 18
		nsLeft 28
		nsBottom 49
		nsRight 48
		approachX 37
		approachY 45
	)

	(method (doVerb theVerb)
		(if (IsFlag 27)
			(gMessager say: 1 0 13) ; "You might be able to do that if you weren't so worried about drowning at the moment!"
			(return 1)
		)
		(return
			(and
				(OneOf theVerb 4 3) ; Do, Walk
				(cond
					((gEgo has: 20) ; towerkey
						(gCurRoom setScript: gimmeMyKeyDammit)
					)
					((== (gEgo view:) 236)
						(gCurRoom setScript: getDecent 0 0)
					)
					(else
						(gCurRoom setScript: enterHall)
					)
				)
			)
		)
	)
)

(instance chairFtr of Feature
	(properties
		noun 3
	)

	(method (onMe param1)
		(return
			(or
				(AvoidPath (param1 x:) (param1 y:) local2)
				(AvoidPath (param1 x:) (param1 y:) local3)
				(AvoidPath (param1 x:) (param1 y:) local4)
			)
		)
	)

	(method (doVerb theVerb)
		(if (IsFlag 27)
			(gMessager say: 1 0 13) ; "You might be able to do that if you weren't so worried about drowning at the moment!"
			(return 1)
		else
			(switch theVerb
				(4 ; Do
					(if (== (gEgo view:) 232)
						(super doVerb: theVerb)
					else
						(gMessager say: 3 4 1) ; "Better not, Larry! Your lily-white skin would burn to a crisp in minutes. Remember what happened when you went on that cruise in "Leisure Suit Larry 2: Looking for Love (in Several Wrong Places)?""
						(return 1)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance poolFtr of Feature
	(properties
		noun 2
		approachX 160
		approachY 99
	)

	(method (onMe param1)
		(return
			(if (AvoidPath (param1 x:) (param1 y:) local1)
				(if (IsFlag 27)
					(= approachX 160)
					(= approachY 99)
				else
					(= approachX 160)
					(= approachY 105)
				)
				1
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gEgo has: 20) ; towerkey
						(gMessager say: 2 4 6) ; "Excuse me! Hey, you! Please bring back the tower key before you go swimming. Other guests may want to dive too."
						(return 1)
					)
					((not (IsFlag 27))
						(gCurRoom
							setScript:
								(if (== (gEgo view:) 232)
									wateryDeath
								else
									jumpInPool
								)
						)
					)
					(else
						(gCurRoom setScript: getOffBeaver)
					)
				)
			)
			(6 ; Zipper
				(if (IsFlag 27)
					(gMessager say: 2 6 13) ; "Ahhhhhh."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(49 ; beaver [ inflated ]
				(cond
					((== (gEgo view:) 239)
						(gCurRoom setScript: getOffBeaver)
					)
					((IsFlag 27)
						(gEgo view: 239)
						(return 1)
					)
					((gEgo has: 20) ; towerkey
						(gMessager say: 2 4 6) ; "Excuse me! Hey, you! Please bring back the tower key before you go swimming. Other guests may want to dive too."
						(return 1)
					)
					(else
						(gCurRoom
							setScript:
								(if (== (gEgo view:) 232)
									wateryDeath
								else
									getOnBeaver
								)
						)
					)
				)
			)
			(35 ; washcloth
				(gGame changeScore: 6 250)
				(= global185 3)
				((gInventory at: 39) cue:) ; washcloth
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance window1 of Feature
	(properties
		x 85
		y 31
		noun 6
		nsTop 17
		nsLeft 75
		nsBottom 31
		nsRight 85
		approachX 80
		approachY 42
	)

	(method (doVerb theVerb)
		(if (IsFlag 27)
			(gMessager say: 1 0 13) ; "You might be able to do that if you weren't so worried about drowning at the moment!"
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance window2 of Feature
	(properties
		x 115
		y 29
		noun 7
		nsTop 15
		nsLeft 105
		nsBottom 29
		nsRight 118
		approachX 111
		approachY 38
	)

	(method (doVerb theVerb)
		(if (IsFlag 27)
			(gMessager say: 1 0 13) ; "You might be able to do that if you weren't so worried about drowning at the moment!"
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance window3 of Feature
	(properties
		x 210
		y 29
		noun 8
		nsTop 12
		nsLeft 200
		nsBottom 29
		nsRight 214
		approachX 209
		approachY 39
	)

	(method (doVerb theVerb)
		(if (IsFlag 27)
			(gMessager say: 1 0 13) ; "You might be able to do that if you weren't so worried about drowning at the moment!"
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance window4 of Feature
	(properties
		x 262
		y 34
		noun 9
		nsTop 17
		nsLeft 250
		nsBottom 34
		nsRight 262
		approachX 256
		approachY 42
	)

	(method (doVerb theVerb)
		(if (IsFlag 27)
			(gMessager say: 1 0 13) ; "You might be able to do that if you weren't so worried about drowning at the moment!"
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bushes of Feature
	(properties
		noun 17
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 138 0 59 9 60 18 69 22 103 41 118 131 121 137 125 154 122 177 122 185 126 197 121 220 120 226 123 288 118 291 86 296 77 298 60 312 53 319 53 319 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 27)
					(gMessager say: 1 0 15) ; "You might be able to do that if you got out of the pool first."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barWindow of Feature
	(properties
		y 200
		noun 23
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 57 87 60 99 51 107 45 97
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance beavFeat of Feature
	(properties)

	(method (doVerb theVerb)
		(beaver doVerb: theVerb)
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 216 35 218 43 191 43 194 35
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gEgo view:) 236)
					(gMessager say: 21 4 1) ; "You surreptitiously slide the dental floss out of your butt."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(47 ; swimsuit
				(cond
					((IsFlag 27)
						(gMessager say: 21 47 1) ; "You surreptitiously slide the dental floss out of your butt."
						(return 1)
					)
					((gEgo has: 20) ; towerkey
						(gMessager say: 21 47 6) ; "Hey, you! Stay out of those bushes with my key. What are you trying to pull?"
						(return 1)
					)
					(else
						(gCurRoom setScript: changeClothes)
						(return 1)
					)
				)
			)
			(45 ; sunglasses
				(if (gEgo has: 35) ; swimsuit
					(gEgo doVerb: 47)
					(return 1)
				else
					(gMessager say: 21 45 7) ; "There's no need to put on your shades yet, Larry. You can't sunbathe here since you aren't wearing a swimsuit."
					(return 1)
				)
			)
			(49 ; beaver [ inflated ]
				(if (IsFlag 27)
					(gEgo view: 239)
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(1 ; Look
				(if (IsFlag 27)
					(if (== (gEgo view:) 239)
						(gMessager say: 21 1 15) ; "Hump that beaver, Larry!"
					else
						(gMessager say: 21 1 13) ; "Quite the little dog-paddler, aren't we?"
					)
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sFx of Sound
	(properties)
)

(instance poolBase of Code
	(properties)

	(method (doit)
		(poolBar
			brTop: (poolBar nsTop:)
			brBottom: (poolBar nsBottom:)
			brLeft: (poolBar nsLeft:)
			brRight: (poolBar nsRight:)
		)
	)
)

(instance merrSetter of Code
	(properties)

	(method (doit)
		(merr
			brTop: (merr nsTop:)
			brBottom: (+ (merr nsBottom:) 5)
			brLeft: (merr nsLeft:)
			brRight: (merr nsRight:)
		)
	)
)

(instance kennySetter of Code
	(properties)

	(method (doit)
		(kenny
			brTop: (kenny nsTop:)
			brBottom: (kenny nsBottom:)
			brLeft: (kenny nsLeft:)
			brRight: (kenny nsRight:)
		)
	)
)

(instance poolWalker of StopWalk
	(properties
		vWalking 229
		vStopped 2291
	)
)

(instance poolyPath of PolyPath
	(properties)

	(method (doit)
		(if (gEgo isBlocked:)
			(= completed 1)
			(self motionCue:)
		else
			(super doit: &rest)
		)
	)
)

