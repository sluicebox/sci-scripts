;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use n013)
(use GKNarrator)
(use GKTeller)
(use sHRoom8)
(use Talker)
(use ROsc)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm240 0
	mosely 1
	moselyCoat 2
)

(local
	local0
	local1
	local2 = 1
	local3
	local4
	local5
	local6
	local7
	local8 = 1
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
)

(instance rm240 of Room
	(properties
		noun 26
		picture 240
		style 14
		exitStyle 13
	)

	(method (notify &tmp temp0)
		(= temp0 local3)
		(= local3 1)
		(return temp0)
	)

	(method (init)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 101 90 101 100 24 123 30 144 118 144 130 154 197 154 205 143 292 144 299 136 269 128 252 136 227 133 227 126 211 124 201 134 179 138 145 134 139 122 123 129 107 124 102 113 114 102 148 112 168 104 132 95 130 86 107 85
					yourself:
				)
		)
		(Load rsSCRIPT 920)
		(Load rsSCRIPT 51)
		(Load rsMESSAGE 240)
		(Load rsVIEW 2401)
		(if (>= gDay 6)
			(= local0 gDoVerbCode)
			(= gDoVerbCode myDVC)
		)
		(gFeatures
			add:
				(ScriptID 241 0) ; bookshelf
				(ScriptID 241 1) ; microwave
				(ScriptID 241 2) ; fridge
				(ScriptID 241 3) ; bullBoard
				(ScriptID 241 4) ; desk
				(ScriptID 241 5) ; leftFileCab
				(ScriptID 241 14) ; leftPlant
				(ScriptID 241 15) ; rightPlant
				(ScriptID 241 16) ; winder
				(ScriptID 241 9) ; leftBinder
				(ScriptID 241 10) ; rightBinder
				(ScriptID 241 13) ; deskLamp
				(ScriptID 241 7) ; trumPost
				(ScriptID 241 12) ; speaker
				(ScriptID 241 6) ; rightFileCab
				(ScriptID 241 11) ; falconPoster
				(ScriptID 241 30) ; gabsChair
				(ScriptID 241 8) ; phone
				(ScriptID 241 17) ; suit
			eachElementDo: #init
		)
		(officeDoor init:)
		(drawer init:)
		(if
			(not
				(or
					(== gDay 3)
					(IsFlag 16)
					(IsFlag 20)
					(IsFlag 34)
					(IsFlag 17)
					(IsFlag 18)
					(IsFlag 19)
				)
			)
			((ScriptID 241 24) init:) ; frankyInWindow
		)
		(if (not (IsFlag 16))
			(if (IsFlag 107)
				(ClearFlag 99)
			)
			(mosely init:)
			(photoTeller init: mosely)
		else
			(= local9 1)
			((ScriptID 241 18) init:) ; mosChair
		)
		(gWalkHandler add: self)
		(= local14 gNarrator)
		(= gNarrator officeNarrator)
		(gEgo normalize:)
		(cond
			((== gPrevRoomNum 50) ; interrogation
				(Load rsVIEW 245)
				(= local3 1)
				(gEgo view: 2401 setLoop: 0 1 setCel: 6 init:)
				(if (and (IsFlag 75) (not (IsFlag 13)))
					(= local8 0)
				)
				(cond
					((IsFlag 19)
						(ClearFlag 19)
						(gCurRoom setScript: photoFirst)
					)
					((IsFlag 17)
						(ClearFlag 17)
						(gCurRoom setScript: getSomeCoffee 0 63)
					)
					((IsFlag 18)
						(ClearFlag 18)
						(gCurRoom setScript: getSomeCoffee 0 64)
					)
				)
			)
			((IsFlag 20)
				(ClearFlag 20)
				(officeDoor setCel: 5 setPri: 86)
				(gCurRoom setScript: photoReplay)
			)
			((and (== gDay 3) (not (IsFlag 21)))
				(= local3 0)
				(gEgo view: 900 posn: 104 88 loop: 4)
				(= local15 (gEgo moveSpeed:))
				(gCurRoom setScript: crashInterview)
			)
			((and (gEgo has: 17) (IsFlag 107)) ; badge
				(= gNarrator local14)
				(ClearFlag 382)
				(if (and (== gDay 2) (> global179 74) (not (IsFlag 99)))
					(giveTheBadgeBack next: (ScriptID 241 29)) ; geezItsHot
				)
				(egoEnters next: giveTheBadgeBack)
				(gCurRoom setScript: egoEnters)
			)
			((and (== gDay 2) (> global179 74) (not (IsFlag 99)))
				(egoEnters next: (ScriptID 241 29)) ; geezItsHot
				(gCurRoom setScript: egoEnters)
			)
			((and (== gDay 2) (< global179 62) (not (IsFlag 445)))
				(SetFlag 445)
				(egoEnters next: (ScriptID 241 29)) ; geezItsHot
				(gCurRoom setScript: egoEnters)
			)
			(else
				(gCurRoom setScript: egoEnters)
			)
		)
		(if (!= gPrevRoomNum 50) ; interrogation
			(gGkMusic1 number: (if (>= gDay 6) 226 else 240))
			(gGkMusic1
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 5 5 0
			)
		)
	)

	(method (dispose)
		(= gNarrator GKNarrator)
		(gWalkHandler delete: self)
		(if (!= gNewRoomNum 50) ; interrogation
			(gGkMusic1 fade:)
		)
		(DisposeScript 920)
		(DisposeScript 51)
		(DisposeScript 64939)
		(DisposeScript 64938)
		(DisposeScript 241)
		(if (>= gDay 6)
			(= gDoVerbCode local0)
		)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 13) local3) ; Walk
				(gEgo setScript: standGabUp)
				(return 1)
			)
			((and (>= gDay 6) (OneOf theVerb 11 10)) ; Talk, Ask
				(gMessager say: noun theVerb 89 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance officeNarrator of Narrator
	(properties
		modeless 2
	)

	(method (init)
		(self
			fore: global220
			back: global214
			font: gUserFont
			talkWidth: 314
			x: 0
			y: 157
		)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0)
		(= fore
			(switch global180
				(1 54)
				(99 7)
				(8 30)
				(10 19)
				(7 47)
				(else global220)
			)
		)
		(if (not local9)
			(switch global180
				(1
					(cond
						(local3
							(if
								(and
									(gCast contains: gEgo)
									(== (gEgo view:) 2401)
									(not (gEgo script:))
								)
								(= temp0 2402)
								(gEgo
									talking: 1
									oldView: (gEgo view:)
									oldLoop: (gEgo loop:)
									oldCel: (gEgo cel:)
									oldSig: (gEgo signal:)
									view: temp0
									setLoop: 0
									setCel: 0
									cycleSpeed: 14
									setCycle: Fwd
								)
							)
						)
						((not (gEgo isNotHidden:))
							(if (or (== (gEgo cel:) 4) (== (gEgo cel:) 5))
								(= temp0 (+ (gEgo view:) 1000))
							else
								(if (== (gEgo view:) 900)
									(= temp0
										(+ (gEgo view:) 1010 (gEgo cel:))
									)
								else
									(= temp0
										(+ (gEgo view:) 1039 (gEgo cel:))
									)
								)
								(switch (Random 0 2)
									(0 1)
									(1
										(+= temp0 10)
									)
									(2
										(= temp0 (+ (gEgo view:) 1000))
									)
								)
							)
							(= local15 (gEgo cycleSpeed:))
							(gEgo oldCel: (gEgo cel:))
							(gEgo
								talking: 1
								oldView: (gEgo view:)
								oldLoop: (gEgo loop:)
								oldSig: (gEgo signal:)
								setCel: 0
								view: temp0
								setLoop: (gEgo oldCel:)
								ignoreActors:
								cycleSpeed: 14
							)
							(if (or (< 1919 temp0 1930) (< 1949 temp0 1960))
								(gEgo setCycle: ForRepeat)
							else
								(gEgo setCycle: Fwd)
							)
						)
					)
				)
				(8
					(cond
						(local4
							(mosely
								setSpeed: 10
								setCycle: RandCycle (* (param1 size:) 5) 0 1
								view: 244
								loop: 1
								cel: 0
							)
						)
						(local5
							(moselyHead
								init:
								setCycle: RandCycle (* (param1 size:) 5) 0 1
							)
						)
						((IsFlag 99)
							(mosely
								setSpeed: 10
								setCycle: RandCycle (* (param1 size:) 5) 0 1
								view: 2471
								loop: 0
								cel: 0
							)
						)
						(else
							(mosely
								setSpeed: 10
								setCycle: RandCycle (* (param1 size:) 5) 0 1
								view: 2431
								loop: 0
								cel: 0
							)
						)
					)
				)
				(10
					((ScriptID 241 21) ; crash
						view: 2441
						loop: 1
						cel: 0
						setCycle: RandCycle (* (param1 size:) 3) 0 1
					)
				)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(if (not local9)
			(switch global180
				(8
					(mosely setSpeed: 7)
					(cond
						(local4
							(mosely setCycle: 0)
						)
						(local5
							(moselyHead dispose:)
						)
						((IsFlag 99)
							(mosely view: 247 loop: 2 cel: 0)
						)
						(else
							(mosely setCycle: 0 view: 240 loop: 2 cel: 4)
						)
					)
				)
				(10
					((ScriptID 241 21) setCycle: 0 view: 2441 loop: 0 cel: 0) ; crash
				)
				(1
					(if (gEgo talking:)
						(if (== (gEgo view:) 2402)
							(gEgo setCycle: 0)
						)
						(gEgo
							view: (gEgo oldView:)
							setCel: (gEgo oldCel:)
							setLoop: (gEgo oldLoop:)
							signal: (gEgo oldSig:)
							talking: 0
						)
					)
				)
			)
		)
		(= global180 0)
		(super dispose:)
	)
)

(instance standGabUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (gGame isHandsOn:))
				(gGame handsOff:)
				(gEgo view: 2401 loop: 0 cel: 6 setCycle: Beg self)
			)
			(1
				(= local3 0)
				(gEgo
					normalize: 4
					posn: 124 125
					ignoreActors: 1
					setMotion: MoveTo 130 130 self
				)
			)
			(2
				(if
					(and
						register
						(not (mosely script:))
						(!= client leaveTheRoom)
					)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(officeDoor hide:)
				(gEgo
					setCel: 0
					setLoop: 0
					view: 2410
					init:
					posn: 104 88
					setSpeed: 12
					setCycle: CT 7 1 self
				)
			)
			(1
				(gGkSound2 number: 374 setLoop: 1 play: self)
				(officeDoor show:)
				(gEgo setCycle: End self)
			)
			(2 0)
			(3
				(gEgo posn: 106 93 normalize: 2 900)
				(= cycles 4)
			)
			(4
				(cond
					((and local6 (IsFlag 3) (not (IsFlag 454)))
						(++ state)
						(SetFlag 454)
						(gMessager say: 27 0 71 0 self) ; "Hey! You're lucky I don't throw you in jail for taking that file! Franks about had kittens!"
					)
					((and local6 (IsFlag 382))
						(= gNarrator local14)
						(gMessager say: 27 0 82 (Random 1 4) self)
					)
					(else
						(++ state)
						(= cycles 1)
					)
				)
			)
			(5
				(= local14 gNarrator)
				(= gNarrator officeNarrator)
				(gMessager say: 27 0 83 (Random 1 4) self)
			)
			(6
				(ClearFlag 382)
				(gEgo setMotion: PolyPath 133 124 self)
			)
			(7
				(if (== gDay 6)
					(gGame handsOn:)
					(self dispose:)
				else
					(gEgo
						setCel: 2
						view: 2401
						setLoop: 0 1
						setCycle: End self
					)
					(= local3 1)
				)
			)
			(8
				(if (and (>= gDay 4) (not (IsFlag 22)))
					(SetFlag 22)
					(gMessager say: 27 0 66 0) ; "Knight. Hate to tell you this, but you're out of a book. The Voodoo Murders case has been closed."
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance photoFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register
					(if (IsFlag 79)
						88
					else
						(SetFlag 79)
						68
					)
				)
				(= gNarrator local14)
				(= local2 0)
				(mosely setCel: 0 setLoop: 1 setSpeed: 15)
				(if (IsFlag 99)
					(mosely view: 2471 setCycle: End self)
				else
					(mosely view: 243 setCycle: CT 2 1 self)
				)
			)
			(1
				(if (IsFlag 99)
					(moselyCoat init:)
				)
				((ScriptID 241 18) init:) ; mosChair
				(mosely
					view: (if (IsFlag 99) 2451 else 245)
					setLoop: -1
					setLooper: Grooper
					posn: 214 114
					setCycle: StopWalk -1
					setSpeed: 8
					setMotion: MoveTo 214 128 self
				)
			)
			(2
				(mosely setMotion: PolyPath 110 95 self)
			)
			(3
				(mosely
					view: (if (IsFlag 99) 2474 else 2473)
					setCel: 0
					setLoop: 0
					posn: 99 91
					setCycle: CT 2 1 self
				)
			)
			(4
				(officeDoor setCel: 5 hide:)
				(gGkSound2 number: 247 setLoop: 1 play:)
				(mosely setCel: 3 setCycle: CT 8 1 self)
			)
			(5
				(if (IsFlag 99)
					(++ state)
				else
					(mosely
						posn: 107 92
						view: 2421
						setCel: 0
						setLoop: 0
						setSpeed: 12
						setCycle: ROsc -1 1 8
					)
					(officeDoor show: setPri: 86)
				)
				(gMessager say: 27 0 register 1 self)
			)
			(6
				(mosely setCel: 9 setCycle: End self)
			)
			(7
				(if (not (officeDoor isNotHidden:))
					(officeDoor show: setPri: 86 setCel: 5)
				)
				(mosely
					setCel: 0
					view: (if (IsFlag 99) 2451 else 245)
					posn: 112 94
					setCycle: StopWalk -1
					setMotion: PolyPath 226 128 self
				)
			)
			(8
				(Face mosely 226 150 self)
			)
			(9
				(if (and (IsFlag 245) ((ScriptID 241 24) script:)) ; frankyInWindow
					(-- state)
				)
				(= cycles 10)
			)
			(10
				(if (gCast contains: (ScriptID 241 24)) ; frankyInWindow
					((ScriptID 241 24) dispose:) ; frankyInWindow
				)
				((ScriptID 241 26) ; franky
					init:
					setCel: 0
					view: 2362
					setCycle: StopWalk -1
					setMotion: MoveTo 105 95 self
				)
			)
			(11
				((ScriptID 241 26) setMotion: PolyPath 108 102 self) ; franky
			)
			(12
				(= cycles 6)
			)
			(13
				(= local14 gNarrator)
				(= gNarrator officeNarrator)
				((ScriptID 241 26) setCel: 4 setLoop: 8) ; franky
				(= cycles 2)
			)
			(14
				((ScriptID 241 27) init: setCycle: Fwd) ; frankyTalker
				(gMessager say: 27 0 register 2 self)
			)
			(15
				((ScriptID 241 27) setCycle: 0 setCel: 0) ; frankyTalker
				(Face mosely (ScriptID 241 26) self) ; franky
			)
			(16
				(= cycles 20)
			)
			(17
				(= local5 1)
				(gMessager say: 27 0 register 3 self)
			)
			(18
				(gEgo view: 2401 setCel: 6 setLoop: 0 setCycle: Beg self)
			)
			(19
				(gEgo normalize: 0 setMotion: PolyPath 209 128 self)
			)
			(20
				(Face gEgo 169 152 self)
			)
			(21
				(gEgo hide:)
				(mosely
					view: (if (IsFlag 99) 2423 else 242)
					setCel: 0
					setLoop: 1
					setCycle: 0
					posn: 215 129
				)
				(= cycles 20)
			)
			(22
				((ScriptID 241 27) setCycle: Osc 4) ; frankyTalker
				(gMessager say: 27 0 register 4 self)
			)
			(23
				((ScriptID 241 27) dispose:) ; frankyTalker
				((ScriptID 241 26) setMotion: PolyPath 169 152 self) ; franky
			)
			(24
				(Face (ScriptID 241 26) 100 123 self) ; franky
			)
			(25
				((ScriptID 241 26) ; franky
					view: (mosely view:)
					setCel: 0
					setLoop: 5
					posn: 169 152
					setCycle: End self
				)
			)
			(26
				(if (== register 68)
					(gMessager say: 27 0 register 5 self) ; "Say chintzy!"
				else
					(= cycles 4)
				)
			)
			(27
				(gGkSound2 number: 249 setLoop: 1 play:)
				(mosely setCycle: End self)
			)
			(28
				((ScriptID 241 26) loop: 6 cel: 0 setCycle: End self) ; franky
			)
			(29
				((ScriptID 241 26) loop: 5 cel: 4 setCycle: Beg self) ; franky
			)
			(30
				(gMessager
					say: 27 0 register (if (== register 88) 5 else 6) self
				)
			)
			(31
				(photoTeller doVerb: 11)
				(self dispose:)
			)
		)
	)
)

(instance photoReplay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local5 1)
				((ScriptID 241 18) init:) ; mosChair
				((ScriptID 241 26) ; franky
					view: 242
					setLoop: 5 1
					setCel: 0
					init:
					posn: 169 152
				)
				(gEgo
					view: 900
					setLoop: 2
					init:
					posn: 103 88
					setCycle: StopWalk -1
					setMotion: PolyPath 209 128 self
				)
				(ClearFlag 34)
			)
			(1
				(Face gEgo 169 152 self)
			)
			(2
				(gMessager say: 27 0 69 1 self) ; "Hurry up, wouldya?"
			)
			(3
				(gEgo hide:)
				(mosely
					view: (if (IsFlag 99) 2423 else 242)
					setCel: 0
					setLoop: 1
					setCycle: 0
					posn: 215 129
				)
				(= cycles 20)
			)
			(4
				(gMessager say: 27 0 69 2 self) ; "Okay. Ready."
			)
			(5
				((ScriptID 241 26) ; franky
					view: (mosely view:)
					setCel: 0
					setLoop: 5
					posn: 169 152
					setCycle: End self
				)
			)
			(6
				(= ticks 25)
			)
			(7
				(gGkSound2 number: 249 setLoop: 1 play:)
				(mosely setCycle: End self)
			)
			(8
				((ScriptID 241 26) loop: 6 cel: 0 setCycle: End self) ; franky
			)
			(9
				((ScriptID 241 26) loop: 5 cel: 4 setCycle: Beg self) ; franky
			)
			(10
				(gMessager sayRange: 27 0 69 3 4 self) ; "(TO FRANKS)Thanks, Hon. Lemme know when you get 'em developed...er, the photos that is."
			)
			(11
				(client setScript: doneWithPhoto)
			)
		)
	)
)

(instance doneWithPhoto of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mosely setCycle: Beg self)
			)
			(1
				(mosely
					setCel: 1
					view: (if (IsFlag 99) 2451 else 245)
					setLoop: 8
					posn: 225 129
					ignoreActors: 1
				)
				(gEgo show: normalize: 5)
				((ScriptID 241 26) ; franky
					setCel: 0
					view: 2362
					setLoop: -1
					setCycle: StopWalk -1
					setMotion: PolyPath 108 102 self
				)
			)
			(2
				((ScriptID 241 26) setMotion: PolyPath 93 89 self) ; franky
			)
			(3
				(= local5 0)
				((ScriptID 241 26) setMotion: PolyPath 104 89 self) ; franky
			)
			(4
				((ScriptID 241 26) setMotion: MoveTo 70 77 self) ; franky
				(officeDoor setCycle: Beg)
			)
			(5
				(self setScript: setThemDown self)
				((ScriptID 241 26) setMotion: MoveTo 55 35 self) ; franky
				(officeDoor setPri: -1)
			)
			(6 0)
			(7
				((ScriptID 241 26) dispose:) ; franky
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crashInterview of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gNarrator GKNarrator)
				(gGame handsOff:)
				((ScriptID 241 21) init:) ; crash
				((ScriptID 241 22) init:) ; copper
				((ScriptID 241 18) init:) ; mosChair
				(= local4 1)
				(if (= register (not (gEgo has: 17))) ; badge
					(mosely loop: 0 cel: 0 setCycle: Osc 1)
				)
				(ClearFlag 99)
				(officeDoor hide:)
				(gGkSound2 number: 247 setLoop: 1 play:)
				(gEgo
					view: 2410
					setLoop: 0
					cel: 0
					posn: 104 88
					init:
					setSpeed: 12
					setCycle: CT 7 1 self
				)
			)
			(1
				(officeDoor show:)
				(gGkSound2 number: 248 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo posn: 106 93 normalize: 2 900 setSpeed: 3)
				(if register
					(mosely loop: 2 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(3
				(if register
					(mosely posn: 142 134)
				)
				(mosely
					view: 245
					setSpeed: 5
					setLoop: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: PolyPath 104 102 self
				)
			)
			(4
				(Face gEgo mosely self)
				(Face mosely gEgo)
			)
			(5
				(= cycles 3)
			)
			(6
				(if register
					(= cycles 1)
				else
					(gEgo put: 17) ; badge
					(gMessager sayRange: 27 0 95 1 3 self) ; "(RRCC. ANGRY)YOU! Give me back my badge. NOW, Knight."
				)
			)
			(7
				(gMessager sayRange: 27 0 65 1 5 self) ; "(ARCC. WELCOMING GABRIEL TO A SUSPECT INTERROGATION)Glad you made it. It'll give you a feel for how I am in action--you know, handling suspects, that sort of thing."
			)
			(8
				(mosely setSpeed: 2 setMotion: PolyPath 142 134 self)
				(gGkMusic1 fade:)
			)
			(9
				(gEgo setSpeed: 0 setMotion: PolyPath 110 133 self)
			)
			(10
				(mosely
					posn: 160 134
					view: 244
					loop: 2
					cel: 4
					setSpeed: 7
					setCycle: Beg self
				)
				(gGkMusic1 number: 895 setLoop: -1 play:)
			)
			(11
				(Face gEgo (ScriptID 241 21) self) ; crash
			)
			(12
				((ScriptID 241 21) loop: 3 cel: 0 setCycle: End self) ; crash
			)
			(13
				(= ticks 15)
			)
			(14
				((ScriptID 241 21) setCycle: Beg self) ; crash
			)
			(15
				(= gNarrator officeNarrator)
				(gMessager sayRange: 27 0 65 6 14 self) ; "(SPEAKING TO SUSPECT--BEING 'TOUGH')All right, Crash. I want to hear about these murders. Have you been present at the so-called 'Voodoo rituals'?"
			)
			(16
				((ScriptID 241 21) setCycle: End self) ; crash
			)
			(17
				(= gNarrator GKNarrator)
				(gMessager say: 27 0 65 15 self) ; "Witness protection! Are you crazy? Don't make me laugh.... Jesus, just lemme outta here!"
				((ScriptID 241 21) loop: 4 cel: 0 setCycle: Osc) ; crash
			)
			(18
				((ScriptID 241 21) setCycle: Beg self) ; crash
			)
			(19
				((ScriptID 241 21) loop: 3 cel: 2 setCycle: Beg self) ; crash
			)
			(20
				((ScriptID 241 21) setCycle: 0) ; crash
				(gMessager say: 27 0 65 16 self) ; "Oh, come on! Who's behind these murders, Crash? Why are the victims all members of the underworld?"
				(mosely loop: 1 cel: 0 setCycle: RandCycle)
			)
			(21
				(mosely setCycle: 0)
				(gMessager say: 27 0 65 17 self) ; "(TO HIMSELF, TERRIFIED)By now they know I'm here. It's different when I'm supposed to come here. If I can send a message, tell them I didn't say nothing...."
				((ScriptID 241 21) loop: 0 cel: 0 setSpeed: 10 setCycle: Fwd) ; crash
			)
			(22
				((ScriptID 241 21) setCycle: 0) ; crash
				(mosely loop: 2 cel: 0 setCycle: End self)
			)
			(23
				(mosely view: 245 loop: 8 setCycle: StopWalk -1)
				(Face gEgo (ScriptID 241 22)) ; copper
				(Face mosely (ScriptID 241 22)) ; copper
				(gMessager say: 27 0 65 18 self) ; "Christ! He's frickin' useless! Take him back to detaining, would you, Tony?"
			)
			(24
				((ScriptID 241 22) setLoop: 4 1 cel: 0 setCycle: End self) ; copper
			)
			(25
				((ScriptID 241 22) ; copper
					view: 249
					setLoop: 0 1
					posn: 67 109
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 122 106 self
				)
			)
			(26
				((ScriptID 241 22) setMotion: MoveTo 157 112 self) ; copper
			)
			(27
				((ScriptID 241 22) hide:) ; copper
				((ScriptID 241 21) ; crash
					view: 2442
					loop: 0
					cel: 0
					setPri: 120
					setCycle: CT 9 1 self
				)
			)
			(28
				((ScriptID 241 21) setPri: 115 setCycle: End self) ; crash
			)
			(29
				((ScriptID 241 22) ; copper
					show:
					view: 244
					setLoop: 5 1
					posn: 166 117
					setCycle: Walk
					setPri: 116
				)
				((ScriptID 241 21) ; crash
					setCel: 0
					setLoop: 1 1
					posn: 107 85
					setCycle: CT 2 1 self
				)
			)
			(30
				((ScriptID 241 22) ; copper
					setSpeed: 4
					setPri: 112
					setMotion: MoveTo 103 84 self
				)
				((ScriptID 241 21) setSpeed: 3 setCycle: CT 7 1 self) ; crash
				(officeDoor hide:)
			)
			(31
				(officeDoor setCel: 5 setPri: 110 show:)
				((ScriptID 241 21) setCycle: End self) ; crash
			)
			(32 0)
			(33
				(officeDoor cycleSpeed: 16 setCycle: Beg self)
				((ScriptID 241 22) setPri: -1 setMotion: MoveTo 90 88) ; copper
			)
			(34
				((ScriptID 241 21) dispose:) ; crash
				((ScriptID 241 22) dispose:) ; copper
				(officeDoor setPri: -1)
				(Face gEgo mosely self)
				(Face mosely gEgo)
			)
			(35
				(= cycles 4)
			)
			(36
				(gEgo setSpeed: local15)
				(= local14 gNarrator)
				(= gNarrator officeNarrator)
				(= local4 0)
				(= local5 1)
				(gMessager sayRange: 27 0 65 19 23 self) ; "I tell you, at times like this, I'd kill for truth serum and damn the civil rights!"
			)
			(37
				(gGkMusic1 fade:)
				(= local5 0)
				(gEgo getPoints: -999 2)
				(self setScript: setThemDown self)
			)
			(38
				(gGkMusic1
					number: 240
					setLoop: -1
					play:
					fade: (gGkMusic1 musicVolume:) 5 5 0
				)
				(SetFlag 21)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance setThemDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					normalize:
					ignoreActors: 1
					setMotion: PolyPath 133 124 self
				)
			)
			(1
				(gEgo view: 2401 setCel: 0 setLoop: 0 1 setCycle: End self)
				(mosely
					view: (if (IsFlag 99) 2451 else 245)
					setCycle: StopWalk -1
					setSpeed: 5
					setMotion: PolyPath 225 126 self
				)
			)
			(2 0)
			(3
				((ScriptID 241 18) dispose:) ; mosChair
				(if (IsFlag 99)
					(mosely
						view: 2471
						setCel: 5
						setLoop: 1
						posn: 234 122
						setCycle: Beg self
					)
				else
					(mosely
						view: 243
						setCel: 2
						setLoop: 1
						posn: 234 122
						setCycle: Beg self
					)
				)
			)
			(4
				(if (IsFlag 99)
					(mosely view: 247 setCel: 0 setLoop: 2)
				else
					(mosely view: 240 setLoop: 2 setCel: 4)
				)
				(= local14 gNarrator)
				(= gNarrator officeNarrator)
				(= local2 1)
				(= local3 1)
				(if (and (== gDay 2) (> global179 74) (not (IsFlag 99)))
					(mosely setScript: (ScriptID 241 29) 0 1) ; geezItsHot
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance giveTheBadgeBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 27 0 70 1 self) ; "Hey, Bud."
			)
			(1
				(= gNarrator local14)
				(gMessager say: 27 0 70 2 self) ; "YOU!"
				(mosely view: 243 setCycle: End self)
			)
			(2 0)
			(3
				(mosely setCel: 0 setLoop: 2 1 setCycle: End self)
			)
			(4
				(mosely setCel: 0 setLoop: 4 1 setCycle: Beg)
				(gEgo
					view: 2402
					setLoop: 0 1
					setSpeed: 12
					setCycle: Osc 3 self
				)
				(= local14 gNarrator)
				(= gNarrator officeNarrator)
				(gMessager say: 27 0 70 3 self) ; "Last time I looked."
			)
			(5 0)
			(6
				(mosely setCycle: Beg self)
			)
			(7
				(= gNarrator local14)
				(gMessager say: 27 0 70 4 self) ; "Give me my badge RIGHT NOW!"
				(mosely setCel: 0 setLoop: 3 1 setCycle: Osc 3 self)
			)
			(8 0)
			(9
				(gMessager say: 27 0 70 5 self) ; "Oh, is that why you're so excited? If you knew what I needed it for...."
				(gEgo setSpeed: 12 setCycle: Osc 3 self)
			)
			(10 0)
			(11
				(gEgo setCycle: 0)
				(gMessager say: 27 0 70 6 self) ; "(MRCC)I'm sure it was to impress a woman! You could have asked! Do you know how embarrassing it is to admit your badge was stolen? I had a photo with the Chief, and he wanted me wearing it!"
				(mosely setCel: 0 setLoop: 2 1 setCycle: Osc 7)
			)
			(12
				(mosely setCycle: End self)
			)
			(13
				(mosely setCel: 3 setLoop: 1 1 setCycle: End self)
			)
			(14
				(gMessager say: 27 0 70 7 self) ; "I should lock you up, Knight!"
				(mosely setCel: 0 setLoop: 2 1 setCycle: End self)
			)
			(15 0)
			(16
				(mosely setCel: 0 setLoop: 4 1 setCycle: End self)
			)
			(17
				(gMessager say: 27 0 70 8 self) ; "I suppose you could. Seems to me, though, there was that time you 'borrowed' my bike without mentioning it. Right from in front of my shop."
				(gEgo view: 2402 setLoop: 0 1 setCycle: Fwd)
			)
			(18
				(mosely view: 2430 setCel: 0 setLoop: 0 1 setSpeed: 14)
				(= seconds 2)
			)
			(19
				(gEgo
					view: 2401
					setCel: 0
					setLoop: 1 1
					setSpeed: 14
					setCycle: CT 2 1 self
				)
			)
			(20
				(gEgo setCycle: End self)
				(mosely setCel: 1)
			)
			(21
				(mosely setCycle: End self)
				(gEgo put: 17 setCycle: Beg) ; badge
				(gMessager say: 27 0 70 9 self) ; "(GIVING IN)Yeah, don't remind me. Just don't do it again."
			)
			(22 0)
			(23
				(gEgo view: 2401 setLoop: 0 1 setCel: 6 posn: 133 124)
				(mosely view: 240 setCel: 0 setLoop: 2 1)
				(= local14 gNarrator)
				(= gNarrator officeNarrator)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance nothingMore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local1
					(gMessager say: 21 52 62 0 self) ; "Nope. I think not."
				else
					(gMessager sayRange: 21 47 62 1 4 self) ; "Nope. That's about it."
				)
			)
			(1
				(client setScript: doneWithPhoto)
			)
		)
	)
)

(instance getSomeCoffee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gNarrator local14)
				(gGame handsOff:)
				(mosely setCel: 0 setLoop: 1 setSpeed: 15)
				(if (IsFlag 99)
					(mosely view: 2471 setCycle: End self)
				else
					(mosely view: 243 setCycle: CT 2 1 self)
				)
			)
			(1
				(if (IsFlag 99)
					(moselyCoat init:)
				)
				((ScriptID 241 18) init:) ; mosChair
				(mosely
					view: (if (IsFlag 99) 2451 else 245)
					setLooper: Grooper
					posn: 214 114
					setCycle: StopWalk -1
					setSpeed: 8
					setMotion: MoveTo 214 128 self
				)
			)
			(2
				(if (IsFlag 16)
					(+= state 2)
				)
				(mosely setMotion: PolyPath 110 95 self)
			)
			(3
				(Face mosely gEgo self)
			)
			(4
				(if (== register 64)
					(gMessager say: 27 0 64 1 self) ; "Some people are never satisfied."
				else
					(gMessager say: 27 0 63 1 self) ; "Don't touch anything while I'm gone!"
				)
			)
			(5
				(mosely setCycle: StopWalk -1 setMotion: MoveTo 100 92 self)
				(if (IsFlag 16)
					(gEgo setScript: leaveTheRoom)
				)
			)
			(6
				(mosely
					view: (if (IsFlag 99) 2474 else 2473)
					setLoop: 0 1
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(7
				(if (IsFlag 16)
					(gCurRoom newRoom: 230)
				else
					(officeDoor hide:)
					(gGkSound2 number: 247 setLoop: 1 play:)
					(mosely setCel: 3 setCycle: End self)
				)
			)
			(8
				(officeDoor show:)
				(mosely
					setCel: 0
					view: (if (IsFlag 99) 2451 else 245)
					setLoop: -1
					setLooper: Grooper
					posn: 70 84
					setCycle: StopWalk -1
					setMotion: MoveTo 20 72 self
				)
			)
			(9
				(gGame handsOn:)
				(= local6 0)
				(mosely hide:)
				(= seconds 12)
			)
			(10
				(gGame handsOff:)
				(= local6 1)
				(if (not (== (gEgo script:) stealTheBadge))
					(client setScript: bringInCoffee)
				)
				(self dispose:)
			)
		)
	)
)

(instance bringInCoffee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not local3)
					(gEgo setScript: (ScriptID 241 23)) ; sitGabDown
				)
				(mosely
					show:
					view: (if (IsFlag 99) 2451 else 245)
					posn: 20 72
					setLoop: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: MoveTo 74 88 self
				)
			)
			(1
				(officeDoor hide:)
				(gGkSound2 number: 247 setLoop: 1 play:)
				(mosely
					cel: 0
					view: (if (IsFlag 99) 2474 else 2473)
					setLoop: 1 1
					posn: 104 93
					setCycle: CT 7 1 self
				)
			)
			(2
				(officeDoor show:)
				(gGkSound2 number: 248 setLoop: 1 play:)
				(mosely setCycle: End self)
			)
			(3
				(mosely
					setCel: 0
					view: (if (IsFlag 99) 2451 else 245)
					posn: 110 96
					setLoop: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: PolyPath 107 124 self
				)
			)
			(4
				(gEgo
					setCel: 1
					view: (if (== (mosely view:) 2451) 2472 else 2402)
					setLoop: 1 1
					setSpeed: 12
					setCycle: CT 2 1 self
				)
				(mosely hide:)
			)
			(5
				(if (gEgo has: 17) ; badge
					(gMessager say: 1 12 4 4 self) ; ""Humph. Just drink this."
				else
					(gMessager say: 27 0 72 1 self) ; "Here. Drink it."
				)
			)
			(6
				(mosely
					show:
					posn: 111 125
					setCel: 0
					view: (if (IsFlag 99) 2451 else 245)
					setLoop: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: PolyPath 225 126 self
				)
				(gEgo view: 2402 setSpeed: 6 setCel: 0 setLoop: 2 1)
			)
			(7
				(if (gEgo has: 17) ; badge
					(gMessager say: 1 12 4 5) ; "Thanks. Tons. I mean it."
				else
					(gMessager say: 27 0 72 2) ; "Thanks."
				)
				(gEgo setCel: 0 setLoop: 3 1 setCycle: End self)
				((ScriptID 241 18) dispose:) ; mosChair
				(if (IsFlag 99)
					(mosely
						setCel: 4
						view: 2471
						setLoop: 0
						posn: 233 123
						setCycle: Beg self
					)
				else
					(mosely
						view: 243
						setLoop: 1
						setCel: 2
						posn: 232 122
						setCycle: Beg self
					)
				)
			)
			(8)
			(9
				(if (IsFlag 99)
					(mosely view: 247 loop: 2 cel: 0 posn: 234 123)
				else
					(mosely
						view: 240
						loop: 2
						cel: 0
						posn: 234 123
						setCycle: End
					)
				)
				(gEgo loop: 4 cel: 0 setCycle: End self)
			)
			(10
				(= local14 gNarrator)
				(= gNarrator officeNarrator)
				((ScriptID 241 19) init:) ; coffeeCup
				(gEgo view: 2401 loop: 0 cel: 6)
				(= local3 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stealTheBadge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local3
					(= local3 0)
					(gEgo
						view: 2401
						loop: 0
						cel: 6
						setSpeed: 5
						setCycle: Beg self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(getSomeCoffee dispose:)
				(gEgo
					normalize:
					setSpeed: 5
					ignoreActors: 1
					setMotion: PolyPath 212 126 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 223 124 self)
			)
			(3
				(gCurRoom setScript: catchInTheAct)
				(gMessager say: 1 12 4 1) ; "I think I'll just borrow this badge."
				(gEgo view: 241 loop: 1 cel: 0 get: 17 setCycle: CT 5 1 self) ; badge
			)
			(4
				(moselyCoat cel: 1)
				(gEgo getPoints: -999 3)
				(SetFlag 4)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo
					normalize:
					ignoreActors:
					setSpeed: 5
					setMotion: MoveTo 212 126 self
				)
			)
			(6
				(gEgo setMotion: PolyPath 134 125 self)
			)
			(7
				(gEgo view: 2401 setLoop: 0 1 cel: 2 setCycle: End self)
			)
			(8
				(= local3 1)
				(if (gCurRoom script:)
					(-- state)
				)
				(= ticks 1)
			)
			(9
				(gCurRoom setScript: giveCoffeeAfterBadge)
				(self dispose:)
			)
		)
	)
)

(instance catchInTheAct of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mosely
					show:
					view: (if (IsFlag 99) 2451 else 245)
					posn: 20 72
					setLoop: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: MoveTo 74 88 self
				)
			)
			(1
				(officeDoor hide:)
				(gGkSound2 number: 247 setLoop: 1 play:)
				(mosely
					view: (if (IsFlag 99) 2474 else 2473)
					setCel: 0
					setLoop: 1 1
					posn: 104 93
					setCycle: CT 7 1 self
				)
			)
			(2
				(officeDoor show:)
				(gGkSound2 number: 248 setLoop: 1 play:)
				(mosely setCycle: End self)
			)
			(3
				(mosely
					setCel: 0
					view: (if (IsFlag 99) 2451 else 245)
					posn: 110 96
					setLoop: 4 1
					setLooper: Grooper
					setCycle: StopWalk -1
				)
				(= cycles 4)
			)
			(4
				(gMessager sayRange: 1 12 4 2 3 self) ; "Hey! Whaddaya doin' with my coat?"
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance giveCoffeeAfterBadge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mosely
					setLoop: -1
					setCycle: StopWalk -1
					setMotion: PolyPath 107 124 self
				)
			)
			(1
				(gEgo
					setCel: 1
					view: (if (== (mosely view:) 2451) 2472 else 2402)
					setLoop: 1 1
					setSpeed: 12
					setCycle: CT 2 1 self
				)
				(mosely hide:)
			)
			(2
				(= local9 1)
				(gMessager say: 1 12 4 4 self) ; ""Humph. Just drink this."
			)
			(3
				(mosely
					show:
					posn: 111 125
					setCel: 0
					view: (if (IsFlag 99) 2451 else 245)
					setLoop: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: PolyPath 225 126 self
				)
				(gEgo view: 2402 setSpeed: 6 setCel: 0 setLoop: 2 1)
			)
			(4
				(gMessager say: 1 12 4 5 self) ; "Thanks. Tons. I mean it."
				(gEgo cel: 0 setLoop: 3 1 setCycle: End self)
				((ScriptID 241 18) dispose:) ; mosChair
				(mosely
					view: 2471
					loop: 0
					cel: 4
					posn: 234 123
					setCycle: Beg self
				)
			)
			(5 0)
			(6
				(= local14 gNarrator)
				(= gNarrator officeNarrator)
				(= local9 0)
			)
			(7
				(mosely view: 247 loop: 2 cel: 0 posn: 234 123)
				(gEgo loop: 4 cel: 0 setCycle: End self)
			)
			(8
				((ScriptID 241 19) init:) ; coffeeCup
				(gEgo view: 2401 loop: 0 cel: 6)
				(= local3 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showMoselyPaper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not local3)
					(self setScript: (ScriptID 241 23) self) ; sitGabDown
				else
					(= cycles 1)
				)
			)
			(1
				(= gNarrator local14)
				(gEgo view: 2401 setCel: 0 setLoop: 1 setCycle: CT 2 1 self)
			)
			(2
				(mosely
					view: (if (IsFlag 99) 2471 else 240)
					setCel: 0
					setLoop: (if (IsFlag 99) 2 else 3)
					setCycle: End self
				)
				(gEgo setCel: 3 setLoop: 1 setCycle: End self)
			)
			(3 0)
			(4
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(5
				(gEgo setCel: 6 setLoop: 0 1)
				(= local14 gNarrator)
				(= gNarrator officeNarrator)
				(switch register
					(20
						(cond
							((IsFlag 331)
								(gMessager say: 17 20 31 0 self) ; "I picked up this scale at Lake Pontchartrain."
								(SetFlag 29)
							)
							((<= gDay 3)
								(gMessager say: 17 20 14 0 self) ; "I picked up this scale at Lake Pontchartrain."
							)
							(else
								(gMessager say: 17 20 16 0 self) ; "I picked up this scale at Lake Pontchartrain."
							)
						)
					)
					(26
						(if (IsFlag 331)
							(if (IsFlag 30)
								(gMessager say: 17 26 35 0 self) ; "Mosely's seen as much in that scale as he's going to."
							else
								(gMessager say: 17 26 34 0 self) ; "You'll never guess how I got this snake scale."
							)
							(SetFlag 30)
						else
							(gMessager say: 17 26 16 0 self) ; "You'll never guess how I got this snake scale."
						)
					)
					(51
						(if (IsFlag 331)
							(gEgo getPoints: -999 2)
							(SetFlag 241)
							(if (IsFlag 26)
								(gMessager say: 17 51 50 0 self) ; "I have these two snake scales. One's from the crime scene at Lake Pontchartrain. The other's from a snake in the Voodoo museum on Ursulines and Chartres."
							else
								(gMessager say: 17 51 51 0 self) ; "I have these two snake scales. One's from the crime scene at Lake Pontchartrain. The other's from a snake in the Voodoo museum on Ursulines and Chartres."
							)
						else
							(gMessager say: 17 51 16 0 self) ; "I have these two snake scales, one's from the lake and one...."
						)
					)
					(17
						(gMessager say: 17 17 0 0 self) ; "I have that murder photo you left for me."
					)
					(50
						(gMessager say: 17 50 0 0 self) ; "I have that photo of you graduating from the police academy."
					)
					(19
						(if (IsFlag 331)
							(if (IsFlag 28)
								(gEgo getPoints: -999 2)
								(SetFlag 26)
								(gMessager say: 17 19 28 0 self) ; "Take a look at these notes. They're from Professor Hartridge at Tulane University."
							else
								(gMessager say: 17 19 27 0 self) ; "Take a look at these notes. They're from Professor Hartridge at Tulane University."
							)
							(SetFlag 27)
						else
							(gMessager say: 17 19 16 0 self) ; "Take a look at these notes. They're from Professor Hartridge at Tulane University."
						)
					)
					(41
						(cond
							((IsFlag 331)
								(if (IsFlag 33)
									(gMessager say: 17 41 36 0 self) ; "Showing that to Mosely again wouldn't do much good."
								else
									(if (IsFlag 26)
										(gMessager say: 17 41 37 0 self) ; "(RRCC. INTENSE. PLEADING HIS CASE.)This is a newspaper clipping about a murder committed in 1810. That murder is an exact match of the Voodoo Murders--right down to the marks around the bodies."
									else
										(gMessager say: 17 41 39 0 self) ; "(RRCC. INTENSE. PLEADING HIS CASE.)This is a newspaper clipping about a murder committed in 1810. That murder is an exact match of the Voodoo Murders--right down to the marks around the bodies."
									)
									(gEgo getPoints: -999 2)
									(SetFlag 33)
								)
							)
							((<= gDay 3)
								(gMessager say: 17 41 14 0 self) ; "I have this newspaper clipping from 1810 about a pattern...."
							)
							(else
								(gMessager say: 17 41 16 0 self) ; "I have this newspaper clipping from 1810 about a pattern...."
							)
						)
					)
					(30
						(if (IsFlag 331)
							(if (IsFlag 106)
								(gMessager say: 17 30 48 0 self) ; "I'm telling you, this snake tattoo is a secret membership symbol for the Voodoo cult."
							else
								(gMessager say: 17 30 47 0 self) ; "I took this tracing from a tattoo on Crash's chest. It's related to the underworld Voodoo cult."
							)
							(SetFlag 106)
						else
							(if (IsFlag 31)
								(gMessager say: 17 30 46 0 self) ; "I really think this tattoo is significant."
							else
								(gMessager say: 17 30 44 0 self) ; "I took this tracing from a tattoo on Crash's chest. It's related to the underworld Voodoo cult."
							)
							(SetFlag 31)
						)
					)
					(16
						(cond
							((IsFlag 331)
								(if (IsFlag 27)
									(gEgo getPoints: -999 2)
									(SetFlag 26)
									(gMessager say: 17 16 56 0 self) ; "You know those marks you found around the murder victims? This is a reconstruction of the whole pattern."
								else
									(gMessager say: 17 16 55 0 self) ; "You know those marks you found around the murder victims? This is a reconstruction of the whole pattern."
								)
								(SetFlag 28)
							)
							((<= gDay 3)
								(gMessager say: 17 16 14 0 self) ; "You know those marks you found around the murder victims? This is a reconstruction of the whole pattern."
							)
							(else
								(gMessager say: 17 16 16 0 self) ; "You know those marks you found around the murder victims? This is a reconstruction of the whole pattern."
							)
						)
					)
				)
			)
			(6
				(= gNarrator local14)
				(gEgo setCel: 3 setLoop: 2 setCycle: Beg self)
				(mosely
					view: (if (IsFlag 99) 2471 else 240)
					setCel: 6
					setLoop: (if (IsFlag 99) 2 else 3)
					setCycle: CT 4 -1 self
				)
			)
			(7)
			(8
				(mosely setCel: 5 setCycle: Beg self)
				(gEgo setCel: 4 setLoop: 3 setCycle: Beg self)
			)
			(9)
			(10
				(= ticks 30)
			)
			(11
				(= local14 gNarrator)
				(= gNarrator officeNarrator)
				(= local9 0)
				(if (and (IsFlag 26) (IsFlag 33) (IsFlag 241))
					(mosely setScript: walkToTheDoor)
				else
					(gGame handsOn:)
				)
				(gEgo setLoop: 0 setCel: 6)
				(self dispose:)
			)
		)
	)
)

(instance showMoselyOther of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local3)
					(self setScript: (ScriptID 241 23) self) ; sitGabDown
				else
					(= cycles 1)
				)
			)
			(1
				(= gNarrator local14)
				(gGame handsOff:)
				(gEgo view: 2401 setCel: 0 setLoop: 1 setCycle: CT 2 1 self)
			)
			(2
				(if (IsFlag 99)
					(mosely
						view: 2471
						setCel: 0
						setLoop: 1
						setCycle: CT 2 1 self
					)
				else
					(mosely view: 240 setCel: 0 setLoop: 4 setCycle: End self)
				)
				(gEgo setCel: 3 setLoop: 1 setCycle: End self)
			)
			(3 0)
			(4
				(cond
					((IsFlag 331)
						(= register 22)
						(SetFlag 25)
					)
					((<= gDay 3)
						(= register 14)
					)
					(else
						(= register 16)
					)
				)
				(= local14 gNarrator)
				(= gNarrator officeNarrator)
				(= local9 1)
				(gMessager say: 17 42 register 1 self)
			)
			(5
				(gEgo setCycle: Beg self)
				(mosely setCycle: Beg self)
			)
			(6 0)
			(7
				(= local9 0)
				(if (== register 22)
					(gMessager sayRange: 17 42 22 2 4 self) ; "Really? What makes you think so?"
				else
					(gMessager say: 17 42 register 2 self)
				)
			)
			(8
				(= ticks 30)
			)
			(9
				(if (and (IsFlag 26) (IsFlag 33) (IsFlag 241))
					(mosely setScript: walkToTheDoor)
				else
					(gGame handsOn:)
				)
				(gEgo setLoop: 0 setCel: 6)
				(self dispose:)
			)
		)
	)
)

(instance takeAnotherPic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local1
					(gMessager say: 21 47 61 0 self) ; "Oh, come one! Let's take one more."
				else
					(gMessager sayRange: 21 47 58 1 3 self) ; "(PHOTO SESSION)Let's take another one."
				)
			)
			(1
				(if local1
					(mosely setScript: doneWithPhoto)
					(self dispose:)
				else
					((ScriptID 241 26) loop: 6 cel: 0 setCycle: End self) ; franky
				)
			)
			(2
				((ScriptID 241 26) loop: 5 cel: 4 setCycle: Beg self) ; franky
			)
			(3
				(gMessager say: 21 47 58 4 self) ; "Okay. Anything else?"
				(= local1 1)
			)
			(4
				(photoTeller doVerb: 11)
			)
		)
	)
)

(instance walkToTheDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 27 0 18 1 4 self) ; "(MRCC)Okay. I'll reopen the case. I hate to admit it, but you've done some pretty good detective work here, Knight."
			)
			(1
				(if (and (IsFlag 245) ((ScriptID 241 24) script:)) ; frankyInWindow
					(-- state)
				)
				(= cycles 10)
			)
			(2
				(if (gCast contains: (ScriptID 241 24)) ; frankyInWindow
					((ScriptID 241 24) dispose:) ; frankyInWindow
				)
				(SetFlag 16)
				(client setScript: getSomeCoffee)
			)
		)
	)
)

(instance leaveTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local3
					(self setScript: standGabUp self)
				else
					(= cycles 2)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 116 93 self)
			)
			(2
				(if local6
					(Face gEgo mosely self)
				else
					(= cycles 2)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(if (and local6 local8)
					(= gNarrator local14)
					(gMessager say: 27 0 84 (Random 1 3) self)
				else
					(= cycles 2)
				)
			)
			(5
				(if (and local6 local8)
					(= local14 gNarrator)
					(= gNarrator officeNarrator)
					(gMessager say: 27 0 85 (Random 1 3) self)
				else
					(= cycles 2)
				)
			)
			(6
				(if (and local6 local8)
					(Face gEgo officeDoor self)
				else
					(= cycles 2)
				)
			)
			(7
				(gEgo
					view: 2410
					setCel: 0
					setLoop: 1
					posn: 100 89
					setCycle: CT 2 1 self
				)
			)
			(8
				(officeDoor hide:)
				(gGkSound2 number: 247 setLoop: 1 play:)
				(gEgo setCel: 3 setCycle: End self)
			)
			(9
				(gGkSound2 stop:)
				(gCurRoom newRoom: 230)
			)
		)
	)
)

(instance openTheDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local3
					(self setScript: standGabUp self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 222 125 self)
			)
			(2
				(gEgo
					view: 246
					setCel: 0
					setLoop: 1
					setSpeed: 14
					setCycle: CT 1 1 self
				)
			)
			(3
				(gGkSound2 number: 310 setLoop: 1 play:)
				(if (IsFlag 252)
					(gEgo cel: 2)
					(drawer setCel: 1 setCycle: Beg)
					(ClearFlag 252)
				else
					(gEgo cel: 2)
					(drawer setCel: 1 setCycle: End)
					(SetFlag 252)
				)
				(= cycles 15)
			)
			(4
				(gEgo setCel: 0)
				(= cycles 8)
			)
			(5
				(gEgo normalize: 1 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance photoTeller of GKTeller
	(properties
		curNoun 19
		sayNoun 21
		verb 47
	)

	(method (doVerb theVerb)
		(if local2
			(client doVerb: theVerb)
			(return 1)
		else
			(SetCursor -2)
			(= local13
				(gGame setCursor: ((ScriptID 0 1) view: 999 yourself:)) ; globeCursor
			)
			(if (IsFlag 2)
				(self verb: 52 newNoun: 20)
			else
				(self verb: 47 newNoun: 19)
			)
			(while 1
				(if (self respond:)
					(break)
				)
			)
			(gGame setCursor: local13)
			(SetCursor 0 0 319 155)
			(return 1)
		)
	)

	(method (showCases)
		(super showCases: 60 (not local11) 58 (not local1) 61 local1) ; How about one of me and Officer Franks?, Let's take another one., Oh, come on. One more.
	)

	(method (cue)
		(if (== iconValue 60) ; How about one of me and Officer Franks?
			(self doVerb: 11)
		else
			(self newNoun: 20)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(59 ; Hold on a sec while I go check my hair.
				(gCurRoom setScript: goFixHair)
			)
			(60 ; How about one of me and Officer Franks?
				(= local11 1)
				(gMessager say: 21 47 60 0 self) ; "How about one of me and Officer Franks?"
			)
			(58 ; Let's take another one.
				(gCurRoom setScript: takeAnotherPic)
			)
			(61 ; Oh, come on. One more.
				(gCurRoom setScript: takeAnotherPic)
			)
			(62 ; Nope. That's about it.
				(gCurRoom setScript: nothingMore)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance mosely of Actor
	(properties
		noun 17
		view 245
		signal 20513
		xStep 4
	)

	(method (dispose)
		(= local6 0)
		(super dispose:)
	)

	(method (init)
		(= local6 1)
		(super init: &rest)
		(cond
			((IsFlag 34)
				(self
					view: (if (IsFlag 99) 2451 else 245)
					loop: 8
					cel: 5
					posn: 225 129
					ignoreActors:
				)
				(if (IsFlag 99)
					(moselyCoat init:)
				)
			)
			((and (== gDay 3) (not (IsFlag 21)))
				(if (gEgo has: 17) ; badge
					(= view 245)
					(= loop 6)
					(= x 100)
					(= y 144)
				else
					(= cel 0)
					(= view 244)
					(= loop 2)
					(= x 160)
					(= y 134)
				)
			)
			((and (gEgo has: 17) (IsFlag 107)) ; badge
				(= cel 0)
				(= view 243)
				(= x 234)
				(= y 123)
				(= loop 1)
			)
			((IsFlag 99)
				(= view 247)
				(= x 234)
				(= y 123)
				(= cel 0)
				(= loop 2)
				(moselyCoat init:)
			)
			(else
				(= view 240)
				(= x 234)
				(= y 123)
				(= cel 0)
				(= loop 2)
				(self setCycle: End)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(cond
			((== theVerb 40) ; VoodooCode1
				(= temp0 (IsFlag 331))
				(gMessager
					say:
						noun
						theVerb
						(cond
							((and temp0 (== theVerb 40) (IsFlag 411)) 93) ; VoodooCode1
							(temp0
								(SetFlag 411)
								92
							)
							((< gDay 4) 14)
							((< gDay 6) 16)
						)
						0
				)
			)
			((== theVerb 59) ; sVoodooCode
				(= temp0 (IsFlag 331))
				(gMessager
					say:
						noun
						theVerb
						(cond
							((and temp0 (== theVerb 59) (IsFlag 410)) 93) ; sVoodooCode
							(temp0
								(SetFlag 410)
								92
							)
							((< gDay 4) 14)
							((< gDay 6) 16)
						)
						0
				)
			)
			((and (== theVerb 16) (IsFlag 28)) ; reconVeve_
				(gMessager say: 17 16 57 0) ; "Showing that to Mosely again wouldn't do much good."
			)
			((and (== theVerb 16) (IsFlag 26)) ; reconVeve_
				(gMessager say: 17 16 24 0) ; "Gabriel has already proven to Mosely that a legitimate Voodoo cult exists in New Orleans."
			)
			((and (== theVerb 30) (not (IsFlag 415))) ; tatooTrace
				(gMessager say: 17 30 94 0) ; "(GK-AM2)Mosely doesn't even know about Crash's demise yet. He's unlikely to believe Gabriel about the origins of that tattoo."
			)
			((and (== theVerb 41) (IsFlag 33)) ; news1810
				(gMessager say: noun theVerb 36 0)
			)
			((and (== theVerb 19) (IsFlag 26)) ; hartNotes
				(gMessager say: 17 19 24 0) ; "Gabriel has already proven to Mosely that a legitimate Voodoo cult exists in New Orleans."
			)
			((and (== theVerb 19) (IsFlag 331) (IsFlag 27)) ; hartNotes
				(gMessager say: 17 19 29 0) ; "Showing that to Mosely again wouldn't do much good."
			)
			((OneOf theVerb 50 19 41 30 16 17) ; gradPhoto, hartNotes, news1810, tatooTrace, reconVeve_, murderPhoto
				(gCurRoom setScript: showMoselyPaper 0 theVerb)
			)
			((and (== theVerb 51) (IsFlag 241)) ; twoScales
				(gMessager say: 17 51 52 0) ; "Showing that to Mosely again wouldn't do much good."
			)
			((and (== theVerb 42) (IsFlag 331) (IsFlag 25)) ; braceRep_
				(gMessager say: 17 42 23 0) ; "Mosely doesn't appear to be impressed by the replica of the snake bracelet."
			)
			((and (== theVerb 20) (IsFlag 331) (IsFlag 29)) ; lakeScale
				(gMessager say: 17 20 32 0) ; "Mosely's seen as much in that scale as he's going to."
			)
			((OneOf theVerb 20 26 51) ; lakeScale, musScale, twoScales
				(gCurRoom setScript: showMoselyPaper 0 theVerb)
			)
			((== theVerb 42) ; braceRep_
				(gCurRoom setScript: showMoselyOther 0 theVerb)
			)
			((OneOf theVerb 73 64 74) ; disguise, collar_, shirt
				(gMessager say: noun theVerb 0 0)
			)
			(else
				(switch theVerb
					(7 ; Look
						(gMessager
							say:
								noun
								theVerb
								(cond
									((IsFlag 99) 1)
									((not (IsFlag 4)) 87)
									(else 2)
								)
								0
						)
					)
					(11 ; Talk
						(= temp1
							(cond
								((== gDay 5) 90)
								((IsFlag 355) 43)
								((IsFlag 354)
									(SetFlag 355)
									42
								)
								((or (IsFlag 353) (> gDay 2))
									(SetFlag 354)
									41
								)
								(else
									(SetFlag 353)
									40
								)
							)
						)
						(if local3
							(gMessager say: noun theVerb temp1 0)
						else
							(gEgo setScript: (ScriptID 241 23) 0 temp1) ; sitGabDown
						)
					)
					(10 ; Ask
						(gCurRoom setScript: (ScriptID 241 28)) ; interroMosely
					)
					(else
						(cond
							((OneOf theVerb 24 48 43 79 23) ; veveCopy, policeVeve_, braceMold_, badge, sLakePatter
								(gMessager say: noun theVerb 0 0)
							)
							((OneOf theVerb 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
								(super doVerb: theVerb)
							)
							((and (<= gDay 3) (not (IsFlag 16)))
								(gMessager say: noun 0 14 0) ; "I have this...."
							)
							((and (>= gDay 4) (not (IsFlag 331)))
								(gMessager say: noun 0 16 0) ; "I have this...."
							)
							(else
								(gMessager say: noun 0 18 0) ; "I have this...."
							)
						)
					)
				)
			)
		)
	)
)

(instance officeDoor of Prop
	(properties
		noun 22
		x 112
		y 80
		view 2400
		loop 1
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Operate
			(= theVerb 6) ; Open
		)
		(switch theVerb
			(6 ; Open
				(if (== (gCurRoom script:) getSomeCoffee)
					(getSomeCoffee seconds: 0 cue:)
				else
					(gEgo setScript: leaveTheRoom)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drawer of Prop
	(properties
		noun 6
		sightAngle 30
		x 188
		y 112
		view 2400
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 120)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 252)
					(if (gEgo has: 18) ; tracker
						(gMessager say: noun theVerb 6 0) ; "The drawer is empty."
					else
						(SetFlag 253)
						(gMessager say: noun theVerb 7 0) ; "There's a tracking device in the drawer."
					)
				else
					(gMessager say: noun theVerb 5 0) ; "Mosely's desk has more growing on it than his head."
				)
			)
			(6 ; Open
				(if (<= gDay 5)
					(gMessager say: noun theVerb 75 0) ; "There's no reason to go through the desk at the moment."
				else
					(gEgo setScript: openTheDrawer)
				)
			)
			(12 ; Pickup
				(if (IsFlag 252)
					(if (gEgo has: 18) ; tracker
						(gMessager say: noun theVerb 6 0) ; "The drawer is empty."
					else
						(gMessager say: noun theVerb 10 0) ; "This tracker might come in handy."
						(gEgo setScript: (ScriptID 241 20)) ; getTracker
					)
				else
					(gMessager say: noun theVerb 5 0) ; "Gabriel doesn't see anything of interest there."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance moselyHead of Prop
	(properties
		view 242
	)

	(method (init)
		(= x
			(if (OneOf (mosely view:) 242 2423)
				(+ (mosely x:) 10)
			else
				(- (mosely x:) 1)
			)
		)
		(= y (- (mosely y:) 46))
		(self setPri: (+ (mosely priority:) 1) setLoop: 2 1)
		(= view
			(switch (mosely view:)
				(242
					(mosely view:)
				)
				(2423
					(mosely view:)
				)
				(2451
					(self setLoop: 1 1)
					2450
				)
				(245
					(self setLoop: 0 1)
					2450
				)
				(else 242)
			)
		)
		(super init: &rest)
	)
)

(instance moselyCoat of View
	(properties
		noun 1
		x 239
		y 126
		z 14
		view 2400
		cel 2
		signal 4129
	)

	(method (init)
		(= cel (if (gEgo has: 17) 1 else 2)) ; badge
		(super init: &rest)
		(self setPri: 124)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (gEgo has: 17) ; badge
					(gMessager say: noun theVerb 77 0) ; "Mosely's coat is on the chair."
				else
					(gMessager say: noun theVerb 76 0) ; "Mosely's coat is on the chair."
				)
			)
			(12 ; Pickup
				(cond
					(local6
						(gMessager say: noun theVerb 86 0) ; "Mosely wouldn't let Gabriel mess with his coat."
					)
					((gEgo has: 17) ; badge
						(gMessager say: noun theVerb 77 0) ; "Gabriel doesn't want anything else from Mosely's coat."
					)
					((IsFlag 99)
						(gEgo setScript: stealTheBadge)
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

(instance myDVC of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(if (== (param2 modNum:) -1)
			(= temp0 gCurRoomNum)
		else
			(= temp0 (param2 modNum:))
		)
		(cond
			(
				(and
					gMsgType
					(param2 noun:)
					(not (OneOf param1 8 6 12 10 11 9 7 13))
					(Message msgGET temp0 (param2 noun:) 0 0 1)
				)
				(gMessager say: (param2 noun:) 0 0 0 0 temp0)
			)
			((OneOf param1 7 11 10 12)
				(gMessager say: (gCurRoom noun:) param1 89 0)
			)
			(else
				(gGame pragmaFail: param1)
			)
		)
	)
)

(instance goFixHair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 21 47 59 0 self) ; "Hold on a sec while I go check my hair."
			)
			(1
				(mosely setCycle: Beg self)
			)
			(2
				(mosely
					view: (if (IsFlag 99) 2451 else 245)
					setCel: 5
					setLoop: 8
					posn: 223 128
					ignoreActors: 1
				)
				(gEgo
					show:
					view: 900
					ignoreActors: 1
					setMotion: PolyPath 104 88 self
				)
			)
			(3
				(SetFlag 34)
				(SetFlag 20)
				(gCurRoom newRoom: 230)
			)
		)
	)
)

