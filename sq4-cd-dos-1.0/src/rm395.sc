;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 395)
(include sci.sh)
(use Main)
(use mall)
(use BeltWay)
(use eRS)
(use Sq4Dialog)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use StopWalk)
(use Wander)
(use Motion)
(use User)
(use System)

(public
	rm395 0
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
	local6
	local7
	local8 = 245
	local9 = 27
	local10 = 1
	local11
)

(procedure (localproc_0 param1 &tmp temp0)
	(= temp0 1)
	(switch param1
		(2
			(if (not (gCurRoom script:))
				(if (gEgo inRect: 192 64 239 96)
					(gCurRoom setScript: talkCrowd)
				else
					(gNarrator say: 12) ; "No one can hear you from over here."
				)
			)
		)
		(6
			(gNarrator say: 13) ; "You never noticed how much adventure game players tend to smell like potato chips, beer and money."
		)
		(7
			(gNarrator say: 14) ; "With the way this crowd smells, you'd want to lick them?"
		)
		(else
			(= temp0 0)
		)
	)
	(return temp0)
)

(instance rm395 of SQRoom
	(properties
		picture 395
		style 10
		north 390
		east 400
		south 400
		west 390
	)

	(method (init &tmp temp0 temp1)
		(cond
			((not (IsFlag 24))
				(freak1 init:)
				(freak2 init:)
				(freak3 init:)
				(freak4 init:)
				(freak5 init:)
				(freak6 init:)
				(freak7 init:)
				(freak8 init:)
				(freak1 setScript: freaksComeOut)
				(SetFlag 24)
				(SetFlag 25)
			)
			((IsFlag 25)
				(freak1 init:)
				(freak2 init:)
				(freak3 init:)
				(freak4 init:)
				(freak5 init:)
				(freak6 init:)
				(freak7 init:)
				(freak8 init:)
				(freak1 x: 225 y: 64 stopUpd:)
				(freak5 x: 239 y: 72 stopUpd:)
			)
		)
		(atm init:)
		(letters init:)
		(bush1 init:)
		(bush2 init:)
		(zapper init:)
		(zapper2 init:)
		(b1 init: setStep: 1 1 setMotion: Wander)
		(b2 init: setStep: 1 1 setMotion: Wander)
		(b7 init: setStep: 1 1 setMotion: Wander)
		(if (== (gGame detailLevel:) 0)
			(b1 setMotion: 0 stopUpd:)
			(b2 setMotion: 0 stopUpd:)
			(b7 setMotion: 0 stopUpd:)
		)
		(cond
			((and (!= gPrevRoomNum 397) (not (IsFlag 13)))
				(gLongSong2 number: 59 loop: -1 flags: 1 play: 95)
			)
			((IsFlag 13)
				(gLongSong2 number: 0 vol: 0 stop:)
			)
		)
		(if (and (!= gPrevRoomNum 397) (!= global160 0))
			(SetFlag 13)
		)
		(= local6 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(HandsOff)
		(switch gPrevRoomNum
			(west
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 -12)
					(= temp1 81)
				else
					(= temp0 -18)
					(= temp1 -2)
				)
				(gEgo
					x: temp0
					y: temp1
					setLoop: gStopGroop
					illegalBits: $8000
				)
				(self setScript: (ScriptID 700 1) 0 egoBwGreen) ; enS
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 232)
					(= temp1 245)
				else
					(= temp0 331)
					(= temp1 173)
				)
				(gEgo
					x: temp0
					y: temp1
					setLoop: gStopGroop
					illegalBits: $8000
				)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue) ; enS
			)
			(396
				(gLongSong setVol: 95)
				(= local5 1)
				(gEgo view: 396)
				(useCard start: 9)
				(gCurRoom setScript: useCard)
				(useCard start: 0)
			)
			(397
				(gLongSong number: 405 loop: -1 flags: 1 play: 95)
				(self setScript: fromStoreScript)
			)
			(else
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 232)
					(= temp1 245)
				else
					(= temp0 331)
					(= temp1 173)
				)
				(gEgo
					x: temp0
					y: temp1
					setLoop: gStopGroop
					illegalBits: $8000
				)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue) ; enS
			)
		)
		(if (!= gPrevRoomNum 396)
			(gEgo
				view:
					(if (== gPrevRoomNum 396)
						396
					else
						(gEgo view:)
					)
				illegalBits: 0
			)
		)
		(if (== gPrevRoomNum 396)
			(gEgo view: 396)
		)
		(gEgo setPri: -1 code: beltwayCode init: setCycle: SyncWalk)
		(super init:)
		(if (IsFlag 13)
			(gAddToPics add: door eachElementDo: #init doit:)
			(gCurRoom
				addObstacle:
					((Polygon new:) type: PBarredAccess init: 0 129 120 189 0 189 yourself:)
					((Polygon new:)
						type: PBarredAccess
						init: 0 35 142 110 105 132 0 78
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 294 189 221 189 154 154 188 132
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 14 0 231 0 319 43 319 164 203 106 213 94 183 78 175 88 173 82 111 55 100 54 112 45 91 33 76 34
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:) type: PBarredAccess init: 0 129 120 189 0 189 yourself:)
					((Polygon new:)
						type: PBarredAccess
						init: 0 35 142 110 105 132 0 78
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 294 189 221 189 154 154 188 132
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 14 0 247 0 235 54 170 89 99 52 108 45 89 35 76 34
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 171 199 101 319 7
						yourself:
					)
			)
		)
		(store init:)
		(self setRegions: 700) ; mall
		(= local11 14)
	)

	(method (doit &tmp temp0 temp1)
		(if (not (-- local10))
			(cond
				(
					(<
						(= temp0
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								local8
								local9
							)
						)
						0
					)
					(= temp0 0)
				)
				((> temp0 300)
					(= temp0 300)
				)
			)
			(gLongSong2 setVol: (- 127 (/ temp0 3)))
			(= local10 60)
		)
		(cond
			(script 0)
			((and (gEgo edgeHit:) (OneOf (gEgo edgeHit:) 2 3 4))
				(cond
					((OneOf (gEgo edgeHit:) 2 3)
						(HandsOff)
						((ScriptID 700 0) enterBelt: egoBwGreen) ; mall
						(self setScript: (ScriptID 700 2) 0 east) ; exS
					)
					((== (gEgo edgeHit:) EDGE_LEFT)
						(HandsOff)
						((ScriptID 700 0) enterBelt: egoBwBlue) ; mall
						(self setScript: (ScriptID 700 2) 0 west) ; exS
					)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 804)
		(DisposeScript 970)
		(= gUseSortedFeatures local6)
		(super dispose:)
	)
)

(instance beltwayCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(cond
			((gCurRoom script:) 0)
			((& (gEgo onControl:) $4000)
				(if (not local4)
					(= local4 1)
					(proc700_5 1)
					(gEgo setMotion: MoveTo 105 45)
				)
			)
			((& (= temp1 (gEgo onControl: 1)) local11)
				(cond
					((& temp1 $0008)
						(if (gCast contains: freak1)
							(if (!= (gEgo illegalBits:) $8000)
								(gEgo illegalBits: $8000)
							)
						else
							(gCurRoom newRoom: 397)
						)
					)
					((& temp1 $0004)
						(egoBwGreen who: gEgo doit:)
						((ScriptID 700 0) whichBelt: 1) ; mall
						(proc700_5 0)
						(gLongSong fade: 127 10 5 0)
					)
					((& temp1 $0002)
						(= local4 0)
						(egoBwBlue who: gEgo doit:)
						((ScriptID 700 0) whichBelt: 2) ; mall
						(proc700_5 0)
						(gLongSong fade: 95 10 5 0)
					)
				)
			)
			((| (egoBwGreen onCon:) (egoBwBlue onCon:))
				(egoBwGreen onCon: 0)
				(egoBwBlue onCon: 0)
				(gEgo xStep: 3 yStep: 2 setPri: -1 illegalBits: $8040)
				(proc700_5 1)
			)
		)
	)
)

(instance useCard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sq4 setCursor: gTheCursor 1 304 172)
				(gEgo setMotion: MoveTo 105 45 self)
			)
			(1
				(= cycles 3)
			)
			(2
				(cond
					((== (gEgo view:) 374)
						(= local5 1)
					)
					((or (== (gEgo view:) 4) (== (gEgo view:) 0))
						(= local5 0)
					)
					(else
						(= local5 2)
					)
				)
				(gEgo setHeading: 45)
				(= cycles 2)
			)
			(3
				(gEgo
					view: 396
					loop:
						(switch local5
							(0 0)
							(1 2)
							(2 1)
						)
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4
				(flash
					init:
					posn: 116 22
					loop: 9
					cycleSpeed: 48
					cel: 0
					setCycle: End self
				)
			)
			(5
				(flash loop: 7 cycleSpeed: 6 setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(if (!= local5 1)
					(flash loop: 8)
				)
				(= seconds 3)
			)
			(7
				(flash dispose:)
				(Animate (gCast elements:) 0)
				(if (== local5 1)
					(SetScore 83 10)
					(= cycles 2)
				else
					(SetFlag 33)
					(= state 9)
					(gNarrator modNum: 395 say: 1 self) ; "You obviously don't resemble a blonde woman. What a surprise."
				)
			)
			(8
				(if (== local5 1)
					(gLongSong setVol: 30)
					(gCurRoom newRoom: 396)
				else
					(= cycles 2)
				)
			)
			(9
				(gEgo
					view: 396
					setLoop: 2
					setCel: 255
					x: 105
					y: 45
					setHeading: 45
					illegalBits: $8000
					init:
				)
				(= cycles 1)
			)
			(10
				(gEgo setCycle: Beg self)
			)
			(11
				(gEgo setSpeed: gGameSpeed loop: 6)
				(switch local5
					(0
						(NormalEgo 6 0)
					)
					(1
						(gEgo
							view: 373
							setCycle: StopWalk 374
							setLoop: -1
							setLoop: gStopGroop
						)
						(AnimateEgoHead 374)
					)
					(2
						(gEgo
							view: 402
							setCycle: StopWalk 14
							setLoop: -1
							setLoop: gStopGroop
						)
						(AnimateEgoHead 14)
					)
				)
				(= cycles 1)
			)
			(12
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(class rssScript of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if local3
			(if (= temp0 ((User curEvent:) type:))
				(Display 395 0 dsRESTOREPIXELS local3)
				(Event dispose:)
				(= local3 0)
				(= seconds 0)
				(= cycles 1)
			)
			(= temp0 evNULL)
		)
	)
)

(instance talkCrowd of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(tROG say: 1 self) ; "What's going on in there?"
			)
			(1
				(switch local2
					(0
						(tAlien say: 1 self) ; "The Two Geeks from Andromeda are in there signing copies of their latest release!!"
						(= local2 1)
					)
					(1
						(= local2 2)
						(tAlien say: 2 self) ; "I just told you! The Two Geeks from Andromeda are in there signing copies of their latest release!!"
					)
					(2
						(tAlien say: 3 self) ; "Beat it, jerk!!"
						(= local2 3)
					)
					(3
						(gNarrator say: 4 self) ; "There is no reply."
					)
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance freaksComeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(HandsOff)
				(freak1
					ignoreActors: 1
					setCycle: Walk
					setStep: 4 3
					setMotion: PolyPath 225 64
				)
				(freak5
					ignoreActors: 1
					setCycle: Walk
					setStep: 4 3
					setMotion: PolyPath 239 72 self
				)
			)
			(2
				(= cycles 10)
			)
			(3
				(freak1 stopUpd: ignoreActors: 0)
				(freak5 stopUpd: ignoreActors: 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance fromStoreScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 993 992 26)
				(HandsOff)
				(gEgo
					x: 233
					y: 61
					illegalBits: 0
					setMotion: PolyPath 209 85 self
				)
			)
			(1
				(if (or (not global160) (IsFlag 31))
					(HandsOn)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(2
				(zap init: posn: 208 100 setCycle: Fwd)
				(= cycles 5)
			)
			(3
				(gLongSong2 number: 838 play:)
				(cond
					((OneOf (gEgo view:) 373 374)
						(= register 993)
						(= temp0 0)
					)
					((OneOf (gEgo view:) 402 14)
						(= register 992)
						(= temp0 0)
					)
					((OneOf (gEgo view:) 0 4)
						(= register 26)
						(= temp0 1)
					)
				)
				(gEgo view: register cel: 0 setLoop: temp0)
				(= cycles 2)
			)
			(4
				(switch register
					(993
						(= temp2 register)
						(= temp1 1)
					)
					(992
						(= temp2 register)
						(= temp1 1)
					)
					(26
						(= temp2 395)
						(= temp1 5)
					)
				)
				(gEgo view: temp2 setLoop: temp1 setCycle: Fwd)
				(= seconds 5)
			)
			(5
				(gLongSong2 stop: -1)
				(zap dispose:)
				(gEgo view: register cel: 0 setLoop: temp0) ; UNINIT
				(= cycles 1)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(EgoDead 0 2) ; "It looks like shoplifting is taken seriously around here!"
				(= cycles 1)
			)
			(8
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoBwGreen of BeltWay
	(properties
		xStep 2
		yStep -1
		xOff 1
		yOff -1
		xTweak 1
		yTweak -1
		key 315
		head 119
		xDir 1
		yDir -1
	)
)

(instance egoBwBlue of BeltWay
	(properties
		xStep 2
		yStep -1
		xOff 1
		yOff -1
		xTweak 1
		yTweak -1
		key 135
		head 301
		xDir -1
		yDir 1
	)
)

(instance door of Sq4View
	(properties
		x 217
		y 90
		view 395
		loop 1
		priority 3
		signal 16400
	)
)

(instance b1 of Sq4Actor
	(properties
		x 295
		y 104
		view 395
		priority 1
		signal 6160
		lookStr 5 ; "A few items are on display in the window."
	)

	(method (setSpeed))

	(method (doVerb theVerb)
		(if (== theVerb 7) ; Taste
			(if (== (++ local7) 18)
				(proc816_1 395 1)
			)
			(super doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance b2 of Sq4Actor
	(properties
		x 272
		y 91
		view 395
		cel 1
		priority 1
		signal 6160
		lookStr 5 ; "A few items are on display in the window."
	)

	(method (setSpeed))
)

(instance b3 of Sq4Actor ; UNUSED
	(properties
		x 156
		y 27
		view 395
		cel 2
		priority 1
		signal 6160
		lookStr 5 ; "A few items are on display in the window."
	)

	(method (setSpeed))
)

(instance b4 of Sq4Actor ; UNUSED
	(properties
		x 165
		y 40
		view 395
		cel 3
		priority 1
		signal 6160
		lookStr 5 ; "A few items are on display in the window."
	)

	(method (setSpeed))
)

(instance b5 of Sq4Actor ; UNUSED
	(properties
		x 272
		y 91
		view 395
		cel 3
		priority 1
		signal 6160
	)

	(method (setSpeed))
)

(instance b6 of Sq4Actor ; UNUSED
	(properties
		x 160
		y 34
		view 395
		cel 1
		priority 1
		signal 6160
	)

	(method (setSpeed))
)

(instance b7 of Sq4Actor
	(properties
		x 165
		y 34
		view 395
		priority 1
		signal 6160
		lookStr 5 ; "A few items are on display in the window."
	)

	(method (setSpeed))
)

(instance zap of Sq4Prop
	(properties
		view 395
		loop 4
	)
)

(instance letters of Sq4Feature
	(properties
		x 198
		y 16
		z 8
		nsLeft 193
		nsBottom 17
		nsRight 204
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(proc816_1 395 2)
			)
		)
	)
)

(instance atm of Sq4Feature
	(properties
		x 110
		y 19
		nsLeft 102
		nsBottom 39
		nsRight 129
		sightAngle 90
		lookStr 6 ; "Wow, an AutoBucks Teller Machine!"
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (& (gEgo onControl: 1) $4000))
					(gNarrator say: 7) ; "Your arms won't reach that far."
				else
					(gNarrator say: 8) ; "You play with the buttons, but the machine does not respond."
				)
			)
			(18 ; atmCard
				(if (not (& (gEgo onControl: 1) $4000))
					(gNarrator say: 7) ; "Your arms won't reach that far."
				else
					(gCurRoom setScript: useCard)
				)
			)
			(6 ; Smell
				(gNarrator say: 9) ; "It smells more like fresh Buckazoids than the other leading brand of ATMs."
			)
			(7 ; Taste
				(gNarrator say: 10) ; "It tastes more like fresh Buckazoids than the other leading brand of ATMs."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class Crowd of Sq4View
	(properties
		lookStr 11 ; "For some reason, there is a gathering here."
	)

	(method (doVerb theVerb)
		(if (not (localproc_0 theVerb))
			(super doVerb: theVerb)
		)
	)
)

(instance freak1 of Sq4Actor
	(properties
		x 156
		y 117
		view 382
		illegalBits 0
		lookStr 11 ; "For some reason, there is a gathering here."
	)

	(method (doVerb theVerb)
		(if (self inRect: 185 25 259 67)
			(if (not (localproc_0 theVerb))
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance freak2 of Crowd
	(properties
		x 219
		y 54
		view 388
	)
)

(instance freak3 of Crowd
	(properties
		x 254
		y 69
		view 384
	)
)

(instance freak4 of Crowd
	(properties
		x 263
		y 76
		view 401
		loop 3
	)
)

(instance freak5 of Sq4Actor
	(properties
		x 125
		y 133
		view 384
		illegalBits 0
		lookStr 11 ; "For some reason, there is a gathering here."
	)

	(method (doVerb theVerb)
		(if (self inRect: 185 25 259 67)
			(if (not (localproc_0 theVerb))
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance freak6 of Crowd
	(properties
		x 202
		y 57
		view 7
		cel 1
	)
)

(instance freak7 of Crowd
	(properties
		x 244
		y 77
		view 395
		loop 6
	)
)

(instance freak8 of Crowd
	(properties
		x 200
		y 60
		view 395
		loop 6
		cel 1
	)
)

(instance flash of Sq4Prop
	(properties
		view 395
		loop 7
	)
)

(instance store of Sq4Feature
	(properties
		x 280
		y 30
		lookStr 15 ; "It's the Software Excess store - "If it's soft, we're aware."
	)

	(method (onMe param1)
		(return (>= -51 (/ (* 100 (- 154 (param1 y:))) (- (param1 x:) 320))))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator say: 16) ; "The software store smells of turnovers...high employee turnovers and low product turnovers."
			)
			(7 ; Taste
				(gNarrator say: 17) ; "If you think the store leaves a bad taste in your mouth wait 'till you see the prices."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush1 of Sq4Feature
	(properties
		x 52
		y 60
		nsTop 41
		nsLeft 46
		nsBottom 69
		nsRight 66
		lookStr 18 ; "This plant was provided courtesy of Shapeir Florists."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator say: 18) ; "This plant was provided courtesy of Shapeir Florists."
			)
			(7 ; Taste
				(gNarrator say: 18) ; "This plant was provided courtesy of Shapeir Florists."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush2 of Sq4Feature
	(properties
		x 245
		y 150
		nsTop 140
		nsLeft 238
		nsBottom 167
		nsRight 261
		lookStr 18 ; "This plant was provided courtesy of Shapeir Florists."
	)

	(method (doVerb theVerb)
		(bush1 doVerb: theVerb)
	)
)

(instance zapper of Sq4Feature
	(properties
		x 179
		y 58
		nsTop 57
		nsLeft 177
		nsBottom 60
		nsRight 181
		sightAngle 90
		lookStr 19 ; "Probably some kind of customer detection system."
	)
)

(instance zapper2 of Sq4Feature
	(properties
		x 239
		y 89
		nsTop 88
		nsLeft 238
		nsBottom 91
		nsRight 240
		sightAngle 90
		lookStr 19 ; "Probably some kind of customer detection system."
	)
)

(instance tROG of Sq4Talker
	(properties
		z 400
		noun 7
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

(instance tAlien of Sq4Talker
	(properties
		z 400
		noun 29
		view 1368
		talkerNum 29
		eyeLoop -1
		mouthOffsetX 21
		mouthOffsetY 12
	)
)

