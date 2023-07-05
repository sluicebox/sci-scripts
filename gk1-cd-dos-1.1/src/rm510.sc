;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use n013)
(use GKNarrator)
(use GKTeller)
(use Germany)
(use sHRoom8)
(use Talker)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use StopWalk)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm510 0
)

(local
	local0
	local1
	local2 = 3
	local3
	local4 = 1
)

(instance rm510 of Room
	(properties
		noun 1
		picture 510
		style 14
		exitStyle 13
	)

	(method (init)
		(if (!= gPrevRoomNum 50) ; interrogation
			(gGkMusic1
				number: 510
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		)
		(super init:)
		(Load rsMESSAGE 510)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 146 319 146 319 123 303 115 258 117 246 109 202 109 211 94 244 94 236 87 201 88 181 91 162 91 141 95 153 100 130 111 87 113 39 126 10 124 0 119
					yourself:
				)
		)
		(gEgo
			view: 901
			setCel: 0
			setLoop: 0
			setCycle: StopWalk -1
			signal: (| (gEgo signal:) $1000)
			scaleSignal: (| (gEgo scaleSignal:) $0004)
			init:
			state: 2
			ignoreActors: 1
			posn: 215 85
			setScaler: Scaler 90 33 120 86
			hide:
		)
		(gerde init:)
		(lightEffect init:)
		(lightEffect2 init:)
		(if (not (gEgo has: 64)) ; knife
			(knife init:)
		)
		(if (and (not (gEgo has: 65)) (not (Germany saltInPot:))) ; salt
			(theSalt init:)
		)
		(potatoBasket init:)
		(lionHead init:)
		(arch init:)
		(sofa init:)
		(rightTapestry init:)
		(middleTapestry init:)
		(leftTapestry init:)
		(dragonHead init:)
		(leftSpear init:)
		(rightSpear init:)
		(lionSpear init:)
		(stairs init:)
		(frontDoor init:)
		(smallWindows init:)
		(upperDoor init:)
		(gWalkHandler add: arch)
		(gWalkHandler add: stairs)
		(gWalkHandler add: upperDoor)
		(Load rsVIEW 901)
		(cond
			((== gPrevRoomNum 50) ; interrogation
				(gEgo posn: 250 116 show:)
				(gerde setScript: gerdeDoStuff)
				(RemapColors 1 254 0 15 208) ; ByRange
				(RemapColors 1 253 48 51 176) ; ByRange
				(= gNarrator castleNarrator)
			)
			((== gPrevRoomNum 540)
				(gerde setScript: gerdeDoStuff)
				(gCurRoom setScript: comeFromChapel)
				(= gNarrator castleNarrator)
			)
			((== gPrevRoomNum 530)
				(gerde setScript: gerdeDoStuff)
				(gEgo setScript: descendStairs)
				(= gNarrator castleNarrator)
			)
			(else
				(gCurRoom setScript: enterEgo)
			)
		)
	)

	(method (dispose)
		(gGkSound2 stop:)
		(RemapColors 0) ; Off
		(gEgo setScale: 0)
		(gWalkHandler delete: arch)
		(gWalkHandler delete: stairs)
		(gWalkHandler delete: upperDoor)
		(= gNarrator GKNarrator)
		(if (!= gNewRoomNum 50) ; interrogation
			(gGkMusic1 fade:)
		)
		(DisposeScript 64939)
		(DisposeScript 64935)
		(DisposeScript 64941)
		(DisposeScript 64956)
		(DisposeScript 920)
		(DisposeScript 51)
		(super dispose:)
	)
)

(instance castleNarrator of Narrator
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

	(method (display param1 &tmp temp0 temp1 temp2)
		(= fore
			(switch global180
				(1 54)
				(99 7)
				(45 26)
				(else global220)
			)
		)
		(switch global180
			(1
				(if
					(and
						(or (== (gEgo view:) 901) (== (gEgo view:) 900))
						(== (gEgo loop:) 8)
					)
					(if (or (== (gEgo cel:) 4) (== (gEgo cel:) 5))
						(= temp0 (+ (gEgo view:) 1000))
					else
						(if (== (gEgo view:) 900)
							(= temp0 (+ (gEgo view:) 1010 (gEgo cel:)))
						else
							(= temp0 (+ (gEgo view:) 1039 (gEgo cel:)))
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
					(= local1 (gEgo cycleSpeed:))
					(= temp2 (gEgo cel:))
					(gEgo
						talking: 1
						oldView: (gEgo view:)
						oldLoop: (gEgo loop:)
						oldCel: (gEgo cel:)
						view: temp0
						setCel: 0
						setLoop: temp2
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
			(45
				(if (gerde script:)
					(gerdeDoStuff dispose:)
				)
				(= local3 1)
				(gerdeHead
					init:
					cycleSpeed: 14
					setCycle: RandCycle (* (param1 size:) 3) 0 1
				)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(if local3
			(= local3 0)
			(gerdeHead dispose:)
		)
		(if (gEgo talking:)
			(gEgo
				view: (gEgo oldView:)
				setLoop: (gEgo oldLoop:)
				setCel: (gEgo oldCel:)
				talking: 0
				setCycle: StopWalk -1
				setSpeed: local1
			)
		)
		(super dispose:)
	)
)

(instance enterEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 509)
				(Load rsVIEW 900)
				(RemapColors 1 254 0 15 208) ; ByRange
				(RemapColors 1 253 48 51 176) ; ByRange
				(= cycles 4)
			)
			(1
				(gGkSound1 number: 219 setLoop: 1 play:)
				(gerde setLoop: 1 setCycle: End self)
			)
			(2
				(gerde setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(gerde
					view: 509
					setLooper: Grooper
					setCycle: StopWalk -1
					setScaler: Scaler 90 33 120 86
					posn: 266 113
					setMotion: MoveTo 202 109 self
				)
			)
			(4
				(gerde setMotion: PolyPath 211 89 self)
				(Load rsVIEW 511)
			)
			(5
				(gMessager say: 14 0 1 1) ; "(ANXIOUS, HOPEFUL)Wolfgang?!"
				(gerde
					view: 511
					setLoop: 0
					setCel: 0
					posn: 221 89
					setScale: 0
					setPri: 70
					setCycle: CT 8 1 self
				)
			)
			(6
				(gerde
					view: 511
					setLoop: 0
					setCel: 9
					posn: 221 89
					setScale: 0
					setCycle: End self
				)
				(gEgo view: 900 show: setMotion: MoveTo 211 91 self)
			)
			(7)
			(8
				(gMessager say: 14 0 1 2 self) ; "(GABE ENTERS CASTLE FOR FIRST TIME)Hello. My name is Knight. Gabriel Knight."
			)
			(9
				(gerde
					setPri: -1
					view: 511
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(10
				(gerde
					view: 509
					setCycle: StopWalk -1
					setScaler: Scaler 90 33 120 86
					posn: 211 89
					setMotion: MoveTo 223 90 self
				)
			)
			(11
				(Face gerde gEgo self)
			)
			(12
				(Face gEgo gerde)
				(gMessager sayRange: 14 0 1 3 4 self) ; "(SURPRISED, DISAPPOINTED BUT HIDES IT QUICKLY)Herr Knight! Oh! Kommen Sie bitte herein..."
				(gerde
					view: 511
					loop: 1
					cel: 0
					setScaler: Scaler 90 35 120 86
					posn: 223 90
					setCycle: RandCycle
				)
			)
			(13
				(gMessager say: 14 0 1 5) ; "I was not expecting you! Has Wolfgang sent you here...?"
				(gEgo
					view: 512
					setCel: 0
					setLoop: 0
					cycleSpeed: 10
					setCycle: End self
				)
				(gerde setCycle: 0 hide:)
				(UpdateScreenItem gEgo)
			)
			(14
				(gerde
					view: 512
					setLoop: 1 1
					posn: 230 90
					show:
					setCycle: Walk
					setScaler: Scaler 90 33 120 86
					ignoreActors: 1
					setMotion: MoveTo 257 91 self
				)
				(gEgo normalize: 0 901 ignoreActors: 1)
			)
			(15
				(gMessager say: 14 0 1 6 self) ; "(CONFUSED)Uncle Wolfgang? No, I came to see him. Isn't he here?"
				(gerde
					view: 509
					setCycle: StopWalk -1
					setMotion: MoveTo 229 91 self
				)
			)
			(16)
			(17
				(gMessager say: 14 0 1 7 self) ; "(UPSET)No, he is gone! I'm sorry! You came all this way!"
				(gerde
					view: 511
					loop: 1
					cel: 0
					setScaler: Scaler 90 35 120 86
					setCycle: RandCycle
				)
			)
			(18
				(gerde setCycle: 0)
				(gMessager say: 14 0 1 8 self) ; "(DISAPPOINTED)Oh, great! That's all I need!"
			)
			(19
				(gMessager sayRange: 14 0 1 9 11 self) ; "(POLITE)Herr Knight, Wolfgang told me all about you and gave me instructions for you to feel welcome here."
				(gerde view: 511 loop: 1 cel: 0 setCycle: RandCycle)
			)
			(20
				(gerde setCycle: 0)
				(gMessager say: 14 0 1 12 self) ; "Thank you, Miss...."
			)
			(21
				(gMessager say: 14 0 1 13) ; "You may call me Gerde, Herr Knight."
				(gerde
					setScaler: Scaler 90 33 120 86
					view: 509
					setCel: 0
					setLoop: 0
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: PolyPath 202 109 self
				)
			)
			(22
				(gerde setMotion: MoveTo 269 112 self)
			)
			(23
				(= gNarrator castleNarrator)
				(gerde setScale: 0)
				(gerde setScript: gerdeDoStuff)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goingToTheChapel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 312 118 self)
			)
			(1
				(gerdeDoStuff dispose:)
				(gEgo setMotion: MoveTo 325 118 self)
			)
			(2
				(gerde
					view: 514
					loop: 4
					cel: 0
					cycleSpeed: 11
					setCycle: End self
				)
			)
			(3
				(= seconds 4)
			)
			(4
				(gCurRoom newRoom: 540)
			)
		)
	)
)

(instance comeFromChapel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(RemapColors 1 254 0 15 208) ; ByRange
				(RemapColors 1 253 48 51 176) ; ByRange
				(= cycles 2)
			)
			(1
				(gEgo
					setLoop: 1
					posn: 317 118
					show:
					setMotion: MoveTo 305 118 self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance interrogateGerde of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 245 116 self)
			)
			(1
				(gerdeDoStuff dispose:)
				(Face gEgo gerde self)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (IsFlag 329)
					(gMessager say: 9 10 13 0 self) ; "(TO GERDE)Can I ask you a few questions?"
				else
					(gMessager say: 9 10 16 0 self) ; "(TO GERDE)Can I ask you a few questions?"
				)
			)
			(4
				(if (IsFlag 329)
					(gGame handsOn:)
					(self dispose:)
				else
					(= global178 45)
					(gCurRoom newRoom: 50) ; interrogation
				)
			)
		)
	)
)

(instance talkToGerde of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gerdeDoStuff dispose:)
				(gEgo setMotion: PolyPath 247 111 self)
				(if (== local2 8)
					(= local2 3)
				)
			)
			(1
				(Face gEgo gerde self)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (IsFlag 329)
					(gMessager say: 9 11 13 0 self) ; "Gerde?"
				else
					(gMessager say: 9 11 local2 0 self)
				)
			)
			(4
				(if (IsFlag 329)
					(gerdeTeller init: gerde doVerb: 11)
				else
					(self cue:)
				)
			)
			(5
				(++ local2)
				(gerde setScript: gerdeDoStuff)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showSomethingToGerde of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gerdeDoStuff dispose:)
				(gEgo setMotion: PolyPath 245 116 self)
			)
			(1
				(Face gEgo gerde self)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (OneOf local0 104 84)
					(if (== local0 84)
						(gMessager say: 9 local0 12 0) ; "That book with the snake mound...."
					else
						(gMessager say: 9 local0 0 0)
					)
					(gGame handsOn:)
					(self dispose:)
				else
					(gEgo view: 905 loop: 4 cel: 0 setCycle: End self)
				)
			)
			(4
				(cond
					((OneOf local0 105 37 101 106 14 107 108 36 39)
						(gMessager say: 9 local0 0 0 self)
					)
					((IsFlag 329)
						(if (== local0 86)
							(gMessager say: 9 local0 13 0 self) ; "(TO GERDE. RELUCTANT)I guess we could put the plane tickets on this."
						else
							(gMessager say: 9 0 13 0 self) ; "Will this help?"
						)
					)
					((== local0 86)
						(gMessager say: 9 local0 16 0 self) ; "Gerde has no use for the credit card at the moment."
					)
					(else
						(gMessager say: 9 0 16 0 self) ; "(SHOWING SOMETHING TO GERDE)Do you know anything about this?"
					)
				)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gerde setScript: gerdeDoStuff)
				(gEgo normalize: 6 901 ignoreActors: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showTheSnakeBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gNarrator GKNarrator)
				(gGame handsOff:)
				(gerdeDoStuff dispose:)
				(gEgo setMotion: PolyPath 247 111 self)
			)
			(1
				(Face gEgo gerde self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gerdeDoStuff dispose:)
				(gEgo
					setScale: 0
					view: 515
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
				(gerde hide:)
				(UpdateScreenItem gEgo)
				(gMessager say: 9 84 11 1 self) ; "(SHOWS HER BOOK ON AFRICA)I found this book in the library. I think it might tell us where Wolfgang went."
			)
			(4)
			(5
				(gEgo view: 515 setLoop: 1 setCel: 0 setCycle: End self)
				(gMessager sayRange: 9 84 11 2 5 self) ; "(WORRIED)Africa? You think Wolfgang went to Africa?"
			)
			(6)
			(7
				(gMessager say: 9 84 11 6 self) ; "Good! Good! My poor Wolfgang! You have money for the plane, Ja?"
				(gEgo view: 515 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(8)
			(9
				(gEgo
					normalize: 6 901
					ignoreActors: 1
					setScaler: Scaler 90 33 120 86
				)
				(gerde show:)
				(= gNarrator castleNarrator)
				(gerdeTeller init: doVerb: 11)
			)
			(10
				(gerde setScript: gerdeDoStuff)
				(SetFlag 329)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTheKnife of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 60 119 self)
			)
			(1
				(gerdeDoStuff dispose:)
				(= cycles 2)
			)
			(2
				(gMessager say: 18 12 0 0 self) ; "(CURIOUS)This dagger..."
			)
			(3
				(gEgo
					setScale: 0
					view: 517
					setCel: 0
					setLoop: 0
					setCycle: CT 2 1 self
				)
			)
			(4
				(gGkSound1 number: 513 setLoop: 1 play:)
				(gEgo getPoints: -999 1)
				(knife dispose:)
				(gEgo
					view: 517
					setCel: 3
					setLoop: 0
					setScaler: Scaler 90 33 120 86
					setCycle: End self
				)
			)
			(5
				(gEgo get: 64 normalize: 1 901 ignoreActors: 1) ; knife
				(gerde setScript: gerdeDoStuff)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gerdeDoStuff of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 0)
				(== (gerde loop:) 1)
				(== (gerde cel:) 3)
				(not (gTalkers size:))
				local4
			)
			(gGkSound2 number: 511 setLoop: 1 play:)
		)
		(if (and (== (gerde cel:) 3) local4)
			(= local4 0)
		else
			(= local4 1)
		)
	)

	(method (dispose)
		(gGkSound2 stop:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gerde
					view: 514
					setCel: 0
					setLoop: 1
					cycleSpeed: 9
					setScale: 0
					setCycle: ForwardCounter 4 self
				)
			)
			(1
				(gGkSound2 stop:)
				(= cycles 5)
			)
			(2
				(gerde view: 514 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(3
				(= cycles 5)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance giveTheCard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(= gNarrator GKNarrator)
				(Load rsVIEW 516)
				(gGame handsOff:)
				(if (gerde script:)
					(gerdeDoStuff dispose:)
				)
				(if (IsFlag 412)
					(self changeState: 2)
				else
					(gEgo setMotion: PolyPath 247 111 self)
				)
			)
			(1
				1
				(Face gEgo gerde self)
			)
			(2
				2
				(gEgo getPoints: -999 2)
				(gerde hide:)
				(gEgo
					setScale: 0
					view: 516
					setCel: 0
					setLoop: 0
					setCycle: End self
				)
			)
			(3
				3
				(if (IsFlag 412)
					(self cue:)
				else
					(gMessager say: 9 86 13 0 self) ; "(TO GERDE. RELUCTANT)I guess we could put the plane tickets on this."
				)
			)
			(4
				4
				(Load rsVIEW 509)
				(gMessager say: 14 0 15 1 self) ; "(EXCITED)Terrific! I will go make the call! Then--while we wait--breakfast!"
			)
			(5
				5
				(gMessager say: 14 0 15 2 self) ; "(WRY. PUT OUT.)Does that mean I get some COFFEE now?"
				(gEgo normalize: 0 901 setScaler: Scaler 90 33 120 86)
				(gerde
					setScaler: Scaler 90 33 120 86
					actions: 0
					posn: 266 113
					view: 509
					show:
					setLooper: Grooper
					setSpeed: 10
					setCycle: StopWalk -1
					setMotion: MoveTo 202 109
				)
				(UpdateScreenItem gEgo)
			)
			(6
				6
				(gerdeTeller dispose:)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance climbTheStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 2 127 self)
			)
			(1
				(gEgo
					setScale: 0
					setScaler: Scaler 90 63 120 86
					setMotion: MoveTo -3 113 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 69 55 self)
			)
			(3
				(Face gEgo 0 55 self)
			)
			(4
				(gCurRoom newRoom: 530)
			)
		)
	)
)

(instance descendStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(RemapColors 1 254 0 15 208) ; ByRange
				(RemapColors 1 253 48 51 176) ; ByRange
				(gEgo
					setScale: 0
					setScaler: Scaler 90 63 120 86
					posn: 69 55
					show:
					setMotion: MoveTo -3 113 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 2 127 self)
			)
			(2
				(if (IsFlag 466)
					(Face gEgo gerde self)
				else
					(self cue:)
				)
			)
			(3
				(if (IsFlag 466)
					(ClearFlag 466)
					(gMessager say: 14 0 2 0 self) ; "(CHEERILY)Gut' Morgen, Herr Knight! I am cooking your Fr\81hst\81ck--a good German breakfast! Please, feel at home."
				else
					(self cue:)
				)
			)
			(4
				(gEgo setScale: 0 setScaler: Scaler 90 33 120 86)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTheSalt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 229 108 self)
			)
			(1
				(gerdeDoStuff dispose:)
				(Face gEgo theSalt self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 19 12 19 0 self) ; "(WANTS SALT FOR CEREMONY)Is that a shaker of salt?"
			)
			(4
				(gEgo view: 517 loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(5
				(theSalt dispose:)
				(gEgo view: 517 loop: 1 cel: 4 setCycle: End self)
				(gEgo getPoints: -999 1)
			)
			(6
				(gerde setScript: gerdeDoStuff)
				(gEgo get: 65 normalize: 0 901 ignoreActors: 1) ; salt
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gerdeTeller of GKTeller
	(properties
		curNoun 15
		sayNoun 16
		verb 85
	)

	(method (cue)
		(cond
			((== iconValue 10) ; Can't you pay for the fare?
				(SetFlag 330)
				(self doVerb: 11)
			)
			((== iconValue 14) ; No--sorry. I can't pay the plane fare.
				(showTheSnakeBook cue:)
				(talkToGerde cue:)
				(gerde actions: 0)
				(self dispose:)
			)
			((== iconValue 9) ; We can use my credit card.
				(if (== (gEgo script:) showTheSnakeBook)
					(showTheSnakeBook dispose:)
				)
				(if (== (gEgo script:) talkToGerde)
					(talkToGerde dispose:)
				)
				(SetFlag 412)
				(gCurRoom setScript: giveTheCard)
			)
			(else
				(self doVerb: 11)
			)
		)
	)

	(method (showCases)
		(super showCases: 10 (not (IsFlag 330)) 8 (IsFlag 330)) ; Can't you pay for the fare?, Are you sure the Ritter estate can't pay?
	)
)

(instance gerde of Actor
	(properties
		noun 9
		x 269
		y 112
		view 514
		signal 4129
		scaleSignal 4
	)

	(method (doVerb theVerb)
		(= local0 theVerb)
		(switch theVerb
			(10 ; Ask
				(gEgo setScript: interrogateGerde)
			)
			(84 ; bookSnkMnd
				(if (IsFlag 329)
					(gEgo setScript: showSomethingToGerde)
				else
					(gEgo setScript: showTheSnakeBook)
				)
			)
			(11 ; Talk
				(gEgo setScript: talkToGerde)
			)
			(38 ; wolfPhone
				(gMessager say: noun theVerb 0 0) ; "Why would Gerde want to see Schloss Ritter's phone number?"
			)
			(86 ; master_card
				(if (IsFlag 329)
					(gEgo setScript: giveTheCard)
				else
					(gEgo setScript: showSomethingToGerde)
				)
			)
			(else
				(if (OneOf theVerb 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
					(super doVerb: theVerb)
				else
					(gEgo setScript: showSomethingToGerde)
				)
			)
		)
	)
)

(instance lightEffect of Prop
	(properties
		x 157
		y 66
		view 5101
	)

	(method (init)
		(super init:)
		(self setPri: 105)
	)
)

(instance lightEffect2 of Prop
	(properties
		x 157
		y 66
		view 5101
		cel 1
	)

	(method (init)
		(super init:)
		(self setPri: 105)
	)
)

(instance gerdeHead of Prop
	(properties
		x 270
		y 88
		view 514
		loop 3
	)

	(method (init)
		(super init:)
		(self setPri: 113)
	)
)

(instance knife of View
	(properties
		noun 18
		sightAngle 20
		x 41
		y 80
		view 518
	)

	(method (init)
		(super init:)
		(self setPri: 120)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(gEgo setScript: getTheKnife)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance potatoBasket of View
	(properties
		noun 20
		x 281
		y 111
		view 514
		cel 1
	)
)

(instance theSalt of View
	(properties
		noun 19
		x 244
		y 106
		view 518
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(if (IsFlag 261)
					(gEgo setScript: getTheSalt)
				else
					(gMessager say: noun theVerb 20 0) ; "At the moment, Gabriel can't think of a need for salt."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lionHead of Feature
	(properties
		noun 2
		nsLeft 29
		nsTop 88
		nsRight 56
		nsBottom 119
		sightAngle 20
		x 41
		y 119
	)
)

(instance sofa of Feature
	(properties
		noun 10
		nsLeft 258
		nsTop 89
		nsRight 302
		nsBottom 106
		sightAngle 20
		x 280
		y 97
	)
)

(instance rightTapestry of Feature
	(properties
		noun 7
		nsLeft 273
		nsTop 22
		nsRight 292
		nsBottom 53
		sightAngle 20
		x 282
		y 37
	)
)

(instance middleTapestry of Feature
	(properties
		noun 7
		nsLeft 49
		nsTop 22
		nsRight 64
		nsBottom 43
		sightAngle 20
		x 57
		y 30
	)
)

(instance leftTapestry of Feature
	(properties
		noun 7
		nsLeft 22
		nsTop 22
		nsRight 43
		nsBottom 62
		sightAngle 20
		x 32
		y 40
	)
)

(instance dragonHead of Feature
	(properties
		noun 13
		nsLeft 280
		nsTop 65
		nsRight 293
		nsBottom 76
		sightAngle 20
		x 287
		y 73
	)
)

(instance arch of Feature
	(properties
		noun 3
		sightAngle 30
		x 312
		y 76
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 297 107 299 48 306 33 319 21 319 125
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gEgo setScript: goingToTheChapel)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftSpear of Feature
	(properties
		noun 8
		nsLeft 266
		nsTop 56
		nsRight 272
		nsBottom 84
		sightAngle 30
		x 268
		y 69
	)
)

(instance rightSpear of Feature
	(properties
		noun 8
		nsLeft 285
		nsTop 56
		nsRight 291
		nsBottom 85
		sightAngle 30
		x 289
		y 69
	)
)

(instance lionSpear of Feature
	(properties
		noun 8
		nsLeft 44
		nsTop 76
		nsRight 51
		nsBottom 93
		sightAngle 30
		x 47
		y 84
	)
)

(instance stairs of Feature
	(properties
		noun 4
		sightAngle 30
		x 46
		y 61
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 123 0 82 56 45 57 21 73 20 73 34 90 32 23 85 22 122
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gEgo setScript: climbTheStairs)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance frontDoor of Feature
	(properties
		noun 5
		nsLeft 196
		nsTop 58
		nsRight 225
		nsBottom 85
		sightAngle 20
		x 209
		y 70
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(if (gEgo has: 67) ; bookSnkMnd
					(gMessager say: noun theVerb 22 0) ; "(RRCC)Gabriel feels ready to leave, but he needs to arrange his travel plans first."
				else
					(super doVerb: theVerb)
				)
			)
			(8 ; Operate
				(if (gEgo has: 67) ; bookSnkMnd
					(gMessager say: noun theVerb 22 0) ; "(RRCC)Gabriel feels ready to leave, but he needs to arrange his travel plans first."
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

(instance smallWindows of Feature
	(properties
		noun 6
		sightAngle 20
		x 135
		y 150
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 110 44 126 27 152 29 154 52
					yourself:
				)
		)
	)
)

(instance upperDoor of Feature
	(properties
		noun 12
		nsLeft 57
		nsTop 22
		nsRight 72
		nsBottom 44
		x 63
		y 62
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gEgo setScript: climbTheStairs)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

