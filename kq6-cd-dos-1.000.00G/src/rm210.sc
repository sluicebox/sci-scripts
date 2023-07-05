;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use rgCrown)
(use walkEgoInScr)
(use KQ6Print)
(use KQ6Room)
(use CartoonScript)
(use n913)
(use Print)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Path)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm210 0
)

(local
	local0
	[local1 8] = [295 71 283 65 277 64 -32768 -32768]
	[local9 20] = [292 71 280 65 268 61 262 61 258 56 270 55 285 55 290 53 298 47 -32768 -32768]
	local29
	local30
	local31
	local32
	local33 = 4660
	local34
	local35 = -1
)

(procedure (localproc_0 param1)
	(if (singSing script:)
		(= local29 param1)
		(if (OneOf (singSingScr state:) 3 9)
			(singSing setScript: 0)
		)
	else
		(param1 cue:)
	)
)

(instance rm210 of KQ6Room
	(properties
		noun 3
		picture 210
		horizon 0
		south 200
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 39 -10 263 -10 250 78 232 104 139 139 76 113 39 82
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 0 189 0 120 65 120 117 148 68 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 29 138 94 138 94 156 31 162
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 -10 27 -10 27 84 64 119 0 119
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 115 189 151 145 244 108 266 79 319 79 319 189
					yourself:
				)
		)
		(super init: &rest)
		(gEgo init: setScale: Scaler 100 84 134 81)
		(gFeatures add: genericFeatures tree holeInTree eachElementDo: #init)
		((ScriptID 10 4) onMeCheck: 2 setOnMeCheck: 1 2 init:) ; rocks
		(LoadMany rsSOUND 214 215 216)
		(switch gPrevRoomNum
			(220
				(gCurRoom setScript: enterFromCastleScr 0 gEgo)
			)
			(240
				(gCurRoom setScript: enterFromVillageScr)
			)
			(140
				(gGlobalSound3 fade: 0 30 8 1)
				(gEgo
					posn: (singSing approachX:) (singSing approachY:)
					loop: 6
				)
			)
			(else
				(if (!= gPrevRoomNum 200)
					((ScriptID 10 0) setIt: 2) ; rgCrown
				)
				(= local34 1)
				(proc12_1 91 185 30)
			)
		)
		(= temp2 ((gInventory at: 39) owner:)) ; royalRing
		(= temp3 ((gInventory at: 38) owner:)) ; rose
		(if (and (IsFlag 94) (!= temp3 140))
			(= temp3 gCurRoomNum)
		)
		(= temp1 ((gInventory at: 47) owner:)) ; poem
		(if (== ((gInventory at: 35) owner:) -1) ; ribbon
			(theRibbon init:)
		)
		(if (== ((gInventory at: 32) owner:) -1) ; note
			(letter init:)
		)
		(if (== temp2 140)
			((gInventory at: 39) owner: gCurRoomNum) ; royalRing
		)
		(if (== temp3 140)
			((gInventory at: 38) owner: gCurRoomNum) ; rose
		)
		(if (== temp1 140)
			((gInventory at: 47) owner: gCurRoomNum) ; poem
		)
		(= temp0
			(not
				(and
					(OneOf temp1 gCurRoomNum 140)
					(OneOf temp2 gCurRoomNum 140)
					(OneOf temp3 gCurRoomNum 140)
				)
			)
		)
		(if ((ScriptID 10 0) isSet: 2) ; rgCrown
			((ScriptID 10 0) clrIt: 2) ; rgCrown
			(clown init:)
		)
		(cond
			(
				(and
					(== gPrevRoomNum 140)
					(== temp3 140)
					(not (and (== temp1 gCurRoomNum) (== temp2 gCurRoomNum)))
				)
				(proc10_2 returnToBranch 18)
			)
			(
				(and
					(== gPrevRoomNum 140)
					(== temp3 140)
					(== temp1 gCurRoomNum)
					(== temp2 gCurRoomNum)
				)
				(proc10_2 notReturnScr 20)
			)
			((and (== gPrevRoomNum 140) (== temp1 140) (!= temp2 gCurRoomNum))
				(proc10_2 returnToBranch 12)
			)
			(
				(and
					(== gPrevRoomNum 140)
					(or (== temp2 140) (and (== temp1 140) (== temp2 gCurRoomNum)))
				)
				(= local32 1)
				(proc10_2 deliveryScr 13)
			)
			((IsFlag 62)
				(proc10_2 deliveryScr 5)
			)
			((IsFlag 63)
				(proc10_2 deliveryScr 6)
			)
			(else
				(if (and (gEgo has: 0) temp0) ; map
					(if (IsFlag 21)
						(singSing init: 0)
					else
						(singSing init: 1)
					)
					(gGlobalSound2 number: 210 loop: -1 play:)
					(musicScr client: musicScr cue:)
				)
				(ClearFlag 62)
				(ClearFlag 63)
			)
		)
		(= temp5
			(or
				(OneOf
					(gCurRoom script:)
					enterFromCastleScr
					enterFromVillageScr
				)
				local34
			)
		)
		(if
			(and
				(gCast contains: singSing)
				(or
					(and temp5 (not ((gCurRoom script:) script:)))
					(and (not temp5) (not (gCurRoom script:)))
				)
			)
			(singSing setScript: singSingScr)
		)
		(if (!= gPrevRoomNum 220)
			(gGlobalSound number: 917 loop: -1 play:)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $4000)
				(gEgo setSpeed: 6)
				(gCurRoom setScript: (Clone exitToCastleScr) 0 gEgo)
			)
			((& temp0 $2000)
				(gCurRoom setScript: exitToVillageScr)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 220) (gCast contains: clown))
			((ScriptID 10 0) setIt: 2) ; rgCrown
		)
		(if (gCast contains: singSing)
			(gGlobalSound2 fade:)
			(if (gTheDoits contains: musicScr)
				(musicScr dispose:)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (scriptCheck param1 &tmp temp0)
		(switch param1
			(85
				(if (not (gCast contains: singSing))
					(= temp0 1)
				else
					(self setScript: fluteScr)
					(= temp0 0)
				)
			)
			(93
				(if (not (gCast contains: singSing))
					(= temp0 1)
				else
					(singSing doVerb: 37)
					(= temp0 0)
				)
			)
		)
		(return temp0)
	)

	(method (edgeToRoom param1)
		(cond
			((== param1 3)
				(proc12_0 param1 30)
				(return 0)
			)
			(argc
				(super edgeToRoom: param1 &rest)
			)
			(else
				(super edgeToRoom:)
			)
		)
	)

	(method (dispose)
		(gGlobalSound fade:)
		(super dispose:)
		(DisposeScript 983)
		(DisposeScript 964)
	)
)

(instance exitPath of Path
	(properties)

	(method (at param1)
		(if (== client gEgo)
			(return [local1 param1])
		else
			(return [local9 param1])
		)
	)
)

(instance musicScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not register)
					(gGlobalSound3 stop:)
				)
				(= register 1)
				(gTheDoits add: self)
				(repeat
					(breakif (!= (= register (Random 0 2)) local33))
				)
				(gGlobalSound3
					number:
						(switch register
							(0 214)
							(1 215)
							(2 216)
						)
					loop: 1
					play: self
				)
			)
			(1
				(= state -1)
				(= ticks (Random 60 300))
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(if register
			(gTheDoits delete: self)
		)
		(= register 0)
	)
)

(instance fluteScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_0 self)
			)
			(1
				(if (gCast contains: singSing)
					(gGlobalSound2 fade:)
					(musicScr dispose:)
				)
				(gGlobalSound fade:)
				(self setScript: (ScriptID 85) self) ; playTheFlute
			)
			(2
				(gMessager say: 14 31 9 0 self) ; "Alexander plays his flute. The nightingale just looks at him curiously."
			)
			(3
				(= cycles 2)
			)
			(4
				(gGlobalSound play:)
				(if (gCast contains: singSing)
					(gGlobalSound2 play:)
					(musicScr state: -1 client: musicScr cue:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromVillageScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setSpeed: 6
					posn: 23 70
					setScale: Scaler 86 20 88 70
					setMotion: MoveTo 38 88 self
				)
			)
			(1
				(gEgo reset: 2 setScale: Scaler 100 84 134 81)
				(= cycles 1)
			)
			(2
				(if (not script)
					(= cycles 1)
				)
			)
			(3
				(if (not (gCast contains: clown))
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance exitToVillageScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setSpeed: 6
					setScale: Scaler 90 20 88 70
					setMotion: MoveTo 23 70 self
				)
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

(instance enterFromCastleScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setSpeed: 6
					posn: 277 64
					setScale: Scaler 30 5 75 15
					setMotion: DPath 283 65 295 71 300 79 self
				)
			)
			(1
				(gEgo hide:)
				(= ticks 150)
			)
			(2
				(gEgo
					show:
					setPri: 3
					posn: 271 130
					setLoop: 2
					scaleX: 108
					scaleY: 108
					setScale:
					setMotion: MoveTo 263 81 self
				)
			)
			(3
				(gEgo setPri: -1 setScale: Scaler 100 84 134 81)
				(= cycles 1)
			)
			(4
				(gEgo setMotion: MoveTo 260 85 self)
			)
			(5
				(gEgo reset: 2)
				(if register
					(register cue:)
				)
				(if (not script)
					(= cycles 1)
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitToCastleScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register gEgo)
					(gGame handsOff:)
				)
				(register
					setLoop: 3
					setPri: 3
					setScale:
					setMotion: MoveTo 267 131 self
				)
			)
			(1
				(register hide:)
				(= ticks 150)
				(if (!= register gEgo)
					(gGame handsOn:)
				)
			)
			(2
				(register
					show:
					setLoop: -1
					setPri: -1
					setScale: Scaler 30 5 75 15
					posn: 300 79
				)
				(register setMotion: (Clone exitPath) self)
			)
			(3
				(= cycles 2)
			)
			(4
				(if (== register gEgo)
					(gCurRoom newRoom: 220)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance clownScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clown setMotion: PolyPath 138 144 self)
			)
			(1
				(clown view: 718 setLoop: 5 setMotion: PolyPath 247 104 self)
			)
			(2
				(clown view: 717 setLoop: -1 setMotion: PolyPath 261 85 self)
			)
			(3
				(self setScript: (Clone exitToCastleScr) self clown)
			)
			(4
				(clown hide:)
				(= seconds 10)
			)
			(5
				(clown dispose:)
			)
		)
	)
)

(instance returnToBranch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(singSing
					init:
					z: 0
					setPri: 1
					posn: 305 30
					setScale: Scaler 100 5 51 30
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 272 52 self
				)
			)
			(1
				(singSing
					setStep: 4 3
					setScale: 0
					setMotion: MoveTo 226 55 self
				)
			)
			(2
				(singSing setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(singSing loop: 2 cel: 8 posn: 252 125 97 setPri: 14)
				(= cycles 2)
			)
			(4
				(gMessager say: 1 0 register 0 self)
			)
			(5
				(gGlobalSound2 number: 210 loop: -1 play:)
				(musicScr client: musicScr cue:)
				(ClearFlag 62)
				(ClearFlag 63)
				(singSing setScript: singSingScr)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance notReturnScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(gMessager say: 1 0 register 0 self)
			)
			(2
				(ClearFlag 62)
				(ClearFlag 63)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance deliveryScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 40])
		(switch (= state newState)
			(0
				(if (OneOf register 5 6)
					(singSing init: 0)
					(cond
						((clown script:)
							(= seconds 6)
						)
						((== client enterFromCastleScr)
							(client register: self)
						)
						(else
							(= seconds 3)
						)
					)
				else
					(= state 2)
					(singSing
						init:
						z: 0
						posn: 305 30
						setScale: Scaler 100 5 51 30
					)
					(= cycles 2)
				)
			)
			(1
				(singSing z: 0 loop: 4 cel: 0 posn: 225 56 setCycle: End self)
			)
			(2
				(singSing posn: 201 56)
				(self cue:)
			)
			(3
				(singSing
					view: 214
					setLoop: (if (IsFlag 62) 0 else 1)
					setCycle: Fwd
				)
				(if (OneOf register 5 6)
					(= state 4)
				)
				(self cue:)
			)
			(4
				(singSing setMotion: MoveTo 272 52 self)
			)
			(5
				(singSing setScale: 0 setStep: 4 3)
				(if (IsFlag 62)
					(singSing setMotion: MoveTo 156 79 self)
				else
					(singSing setMotion: MoveTo 111 81 self)
				)
			)
			(6
				(if (IsFlag 62)
					(theRibbon init:)
				else
					(letter init:)
				)
				(if
					(and
						(== ((gInventory at: 39) owner:) gCurRoomNum) ; royalRing
						(== ((gInventory at: 38) owner:) gCurRoomNum) ; rose
						(== ((gInventory at: 47) owner:) gCurRoomNum) ; poem
					)
					(singSing
						view: 213
						setLoop: 0
						setMotion: MoveTo -10 79 self
					)
				else
					(++ state)
					(self cue:)
				)
			)
			(7
				(singSing dispose:)
				(= cycles 2)
				(= state 10)
			)
			(8
				(if (IsFlag 62)
					(singSing posn: 156 79)
				else
					(singSing posn: 111 81)
				)
				(singSing view: 213 setLoop: 5 cel: 0 setCycle: End self)
			)
			(9
				(if (IsFlag 62)
					(singSing posn: 185 69)
				else
					(singSing posn: 141 72)
				)
				(singSing
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 220 49 self
				)
			)
			(10
				(singSing
					setLoop: -1
					loop: 6
					cel: 0
					posn: 225 56
					setCycle: End self
				)
			)
			(11
				(if (gCast contains: singSing)
					(gGlobalSound2 number: 210 loop: -1 play:)
					(musicScr state: -1 client: musicScr cue:)
				)
				(gMessager say: 1 0 register 0 self)
			)
			(12
				(if (gCast contains: singSing)
					(singSing
						loop: 2
						cel: 8
						posn: 252 125 97
						setPri: 14
						setScript: singSingScr
					)
				)
				(if local32
					(gGame handsOn:)
				)
				(ClearFlag 62)
				(ClearFlag 63)
				(self dispose:)
			)
		)
	)
)

(instance giveItemToBirdScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 138 142 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(localproc_0 self)
			)
			(3
				(gEgo
					view: 211
					posn: 147 143
					loop: 0
					cel: 0
					normal: 0
					setCycle: End self
				)
				(if local31
					(genieSnake init:)
				)
			)
			(4
				(if
					(and
						(gCast contains: genieSnake)
						(<= ((genieSnake script:) state:) 0)
					)
					(-- state)
					(= ticks 15)
				else
					(self cue:)
				)
			)
			(5
				(client cue:)
			)
			(6
				(gGlobalSound2 fade:)
				(musicScr dispose:)
				(singSing z: 0 loop: 4 posn: 225 56 setCycle: End self)
			)
			(7
				(singSing
					setLoop: 0
					posn: 201 56
					setCycle: Fwd self
					setMotion: MoveTo 158 95 self
				)
			)
			(8
				(if (!= (gGlobalSound2 prevSignal:) -1)
					(gGlobalSound2 stop:)
				)
				(gGlobalSound4 number: 212 play:)
				(if (IsFlag 10)
					(gGlobalSound4 hold: 10)
				)
				(singSing setLoop: 5 cel: 0 setCycle: End self)
			)
			(9
				(client cue:)
			)
			(10
				(gEgo setCycle: Beg self)
				(self cue:)
				(= register 0)
			)
			(11
				(singSing
					view: 214
					setLoop:
						(switch register
							(2 2)
							(1 3)
							(0 4)
						)
					posn: 187 85
					setCycle: Fwd
					setMotion: MoveTo 272 52 self
				)
			)
			(12
				(gEgo posn: (- (gEgo x:) 10) (- (gEgo y:) 3) reset: 4)
			)
			(13
				(client cue:)
			)
			(14
				(singSing
					setScale: Scaler 100 5 51 30
					setMotion: MoveTo 305 30 self
				)
			)
			(15
				(singSing dispose:)
				(if (gCast contains: genieSnake)
					((genieSnake script:) caller: self ticks: 0 state: 2 cue:)
				else
					(self cue:)
				)
			)
			(16
				(self dispose:)
			)
		)
	)
)

(instance givePoemScr of CartoonScript
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gEgo put: 47 140) ; poem
				(gGame handsOff:)
				(if (== (= temp0 ((gInventory at: 39) owner:)) 210) ; royalRing
					(gGame givePoints: 1)
				)
				(= temp1 ((gInventory at: 38) owner:)) ; rose
				(= register
					(cond
						(
							(and
								(!= temp0 gCurRoomNum)
								(!= temp1 gCurRoomNum)
								(!= ((gInventory at: 47) owner:) gCurRoomNum) ; poem
							)
							(= local31 1)
							(if (IsFlag 10) 25 else 26)
						)
						((and (!= temp0 gCurRoomNum) (== temp1 gCurRoomNum)) 32)
						((== temp0 gCurRoomNum)
							(SetFlag 63)
							14
						)
					)
				)
				(self setScript: giveItemToBirdScr self 2)
			)
			(1
				(if (OneOf register 14 32 25)
					(KQ6Print posn: -1 80)
				else
					(KQ6Print posn: -1 100)
				)
				(KQ6Print
					font: gUserFont
					say: 0 4 32 register 1
					init: giveItemToBirdScr
				)
			)
			(2
				(if (OneOf register 25 26)
					(KQ6Print
						font: gUserFont
						posn: -1 100
						say: 0 4 32 register 2
						init: giveItemToBirdScr
					)
				else
					(giveItemToBirdScr cue:)
				)
			)
			(3
				(KQ6Print
					font: gUserFont
					posn: -1 100
					modeless: 1
					ticks: 0
					say:
						0
						4
						32
						register
						(if (OneOf register 25 26) 3 else 2)
					init:
				)
				(giveItemToBirdScr cue:)
			)
			(4
				(if gModelessDialog
					(if (& gMsgType $0002)
						(self cue:)
					else
						(++ state)
						(KQ6Print caller: self)
					)
				else
					(++ state)
					(self cue:)
				)
			)
			(5
				(if (not (== (DoAudio audPOSITION) -1))
					(-- state)
				)
				(= ticks 10)
			)
			(6
				(if (IsFlag 10)
					(gCurRoom newRoom: 140)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance giveRingScr of CartoonScript
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gEgo put: 39 140) ; royalRing
				(gGame handsOff:)
				(if (IsFlag 10)
					(gGame givePoints: 3)
				else
					(gGame givePoints: 1)
				)
				(SetFlag 62)
				(= temp0 ((gInventory at: 47) owner:)) ; poem
				(= temp1 ((gInventory at: 38) owner:)) ; rose
				(= register
					(cond
						(
							(and
								(!= temp0 gCurRoomNum)
								(!= temp1 gCurRoomNum)
								(!= ((gInventory at: 39) owner:) gCurRoomNum) ; royalRing
							)
							(= local31 1)
							(if (IsFlag 10) 25 else 26)
						)
						((and (== temp0 gCurRoomNum) (!= temp1 gCurRoomNum)) 36)
						((and (== temp0 gCurRoomNum) (== temp1 gCurRoomNum)) 38)
						((and (== temp1 gCurRoomNum) (!= temp0 gCurRoomNum)) 34)
						(else
							(Prints
								{Problem! In else state of giveRoseScr conditional.}
							)
						)
					)
				)
				(self setScript: giveItemToBirdScr self 0)
			)
			(1
				(cond
					((== register 25)
						(KQ6Print posn: -1 100)
					)
					((OneOf register 36 34)
						(KQ6Print posn: -1 100)
					)
					((== register 38)
						(KQ6Print posn: -1 100)
					)
					(else
						(KQ6Print posn: -1 100)
					)
				)
				(KQ6Print
					font: gUserFont
					say: 0 4 70 register 1
					init: giveItemToBirdScr
				)
			)
			(2
				(if (OneOf register 25 26)
					(KQ6Print
						font: gUserFont
						posn: -1 100
						say: 0 4 70 register 2
						init: giveItemToBirdScr
					)
				else
					(giveItemToBirdScr cue:)
				)
			)
			(3
				(if (OneOf register 36 38)
					(= register 34)
				)
				(KQ6Print
					font: gUserFont
					posn: -1 100
					modeless: 1
					ticks: 0
					say:
						0
						4
						70
						register
						(if (OneOf register 25 26) 3 else 2)
					init:
				)
				(giveItemToBirdScr cue:)
			)
			(4
				(if gModelessDialog
					(if (& gMsgType $0002)
						(self cue:)
					else
						(++ state)
						(KQ6Print caller: self)
					)
				else
					(++ state)
					(self cue:)
				)
			)
			(5
				(if (not (== (DoAudio audPOSITION) -1))
					(-- state)
				)
				(= ticks 10)
			)
			(6
				(if (IsFlag 10)
					(gCurRoom newRoom: 140)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance giveRoseScr of CartoonScript
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gEgo put: 38 140) ; rose
				(gGame handsOff:)
				(= temp0 ((gInventory at: 39) owner:)) ; royalRing
				(= temp1 ((gInventory at: 47) owner:)) ; poem
				(if (== temp0 gCurRoomNum)
					(gGame givePoints: 1)
				)
				(= register
					(cond
						(
							(and
								(!= temp0 gCurRoomNum)
								(!= temp1 gCurRoomNum)
								(!= ((gInventory at: 38) owner:) gCurRoomNum) ; rose
							)
							(= local31 1)
							(if (IsFlag 10) 25 else 26)
						)
						((and (!= temp0 gCurRoomNum) (== temp1 gCurRoomNum)) 41)
						((and (== temp0 gCurRoomNum) (!= temp1 gCurRoomNum)) 23)
						((and (== temp0 gCurRoomNum) (== temp1 gCurRoomNum)) 24)
						(else
							(Prints
								{Problem! In else state of giveRoseScr conditional.}
							)
						)
					)
				)
				(self setScript: giveItemToBirdScr self 1)
			)
			(1
				(cond
					((== register 25)
						(KQ6Print posn: -1 80)
					)
					((OneOf register 23 41)
						(KQ6Print posn: -1 80)
					)
					(else
						(KQ6Print posn: -1 100)
					)
				)
				(KQ6Print
					font: gUserFont
					say: 0 4 71 register 1
					init: giveItemToBirdScr
				)
			)
			(2
				(if (OneOf register 25 26)
					(KQ6Print
						font: gUserFont
						posn: -1 100
						say: 0 4 71 register 2
						init: giveItemToBirdScr
					)
				else
					(giveItemToBirdScr cue:)
				)
			)
			(3
				(if (OneOf register 41)
					(= register 23)
				)
				(KQ6Print
					font: gUserFont
					posn: -1 100
					modeless: 1
					ticks: 0
					say:
						0
						4
						71
						register
						(if (OneOf register 25 26) 3 else 2)
					init:
				)
				(giveItemToBirdScr cue:)
			)
			(4
				(if gModelessDialog
					(if (& gMsgType $0002)
						(self cue:)
					else
						(++ state)
						(KQ6Print caller: self)
					)
				else
					(++ state)
					(self cue:)
				)
			)
			(5
				(if (not (== (DoAudio audPOSITION) -1))
					(-- state)
				)
				(= ticks 10)
			)
			(6
				(if (IsFlag 10)
					(gCurRoom newRoom: 140)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance windBirdHeader of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 120 141 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(localproc_0 self)
			)
			(3
				(KQ6Print
					font: gUserFont
					posn: 10 10
					say: 0 4 37 register 1
					init: self
				)
			)
			(4
				(= cycles 2)
			)
			(5
				(gGlobalSound2 fade:)
				(musicScr dispose:)
				(gEgo
					setSpeed: 6
					view: 883
					loop: 1
					cel: 0
					posn: 120 142
					normal: 0
					setCycle: Fwd
					scaleX: 128
					scaleY: 128
					setScale:
				)
				(gGlobalSound4 number: 930 loop: -1 play:)
				(= ticks 180)
			)
			(6
				(gGlobalSound4 stop:)
				(self dispose:)
			)
		)
	)
)

(instance windUpBirdScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: windBirdHeader self 10)
			)
			(1
				(gGlobalSound4 number: 931 loop: -1 play:)
				(gEgo loop: 7 cycleSpeed: 9 setCycle: Fwd)
				(= ticks 180)
			)
			(2
				(KQ6Print
					font: gUserFont
					posn: 10 10
					say: 0 4 37 10 2 ; "It plays its pleasant, tinny tune."
					init: self
				)
			)
			(3
				(KQ6Print
					font: gUserFont
					posn: 10 10
					say: 0 4 37 10 3 ; "The living nightingale in the tree listens to the tune curiously."
					init: self
				)
			)
			(4
				(= ticks 30)
			)
			(5
				(gGlobalSound4 fade:)
				(gGlobalSound2 play: 0 fade: 127 25 10 0)
				(musicScr state: -1 client: musicScr cue:)
				(gEgo reset: 0 posn: 126 139)
				(= cycles 2)
			)
			(6
				(singSing setScript: singSingScr)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance befriendSSScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame givePoints: 4)
				(self setScript: windBirdHeader self 11)
			)
			(1
				(gEgo loop: 3 cel: 0 posn: 119 142 setCycle: End self)
			)
			(2
				(windUpBird init:)
				(gGlobalSound4 number: 931 loop: -1 play:)
				(gEgo posn: 120 141 reset: 0)
				(= cycles 2)
			)
			(3
				(= ticks 180)
			)
			(4
				(KQ6Print
					font: gUserFont
					posn: 10 10
					say: 0 4 37 11 2 ; "The mechanical nightingale sings a sweet, tinny tune. The real nightingale in the tree cocks her head and listens intently."
					init: self
				)
			)
			(5
				(singSing posn: 252 125 97 loop: 2 cel: 0 setCycle: End self)
			)
			(6
				(= cycles 2)
			)
			(7
				(KQ6Print
					font: gUserFont
					posn: 10 10
					say: 0 4 37 11 3 ; "The nightingale flies to a lower branch and looks at Alexander curiously as if she were deciding that this human might not be so bad."
					init: self
				)
			)
			(8
				(= ticks 48)
			)
			(9
				(gGlobalSound4 fade:)
				(windUpBird dispose:)
				(gEgo
					setSpeed: 6
					posn: 119 143
					view: 883
					loop: 3
					cel: 7
					normal: 0
					setCycle: CT 1 -1 self
				)
			)
			(10
				(gGlobalSound2 play: 0 fade: 127 25 10 0)
				(musicScr state: -1 client: musicScr cue:)
				(gEgo reset: 0 posn: 120 141 setScale: Scaler 100 84 134 81)
				(SetFlag 21)
				(singSing setScript: singSingScr)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance snakeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(if (< (++ local35) 2)
					(gGlobalSound3 number: 211 loop: 1 play:)
				)
				(if (and (not (Random 0 1)) (not local30))
					(= local30 1)
					(= state 5)
					(self cue:)
				else
					(= state 0)
					(= ticks (Random 60 150))
				)
			)
			(3
				(if (not local30)
					(= local30 (= register 1))
					(= state 5)
					(self cue:)
				else
					(= register 0)
					(if (gCast contains: eye)
						(eye dispose:)
					)
					(genieSnake loop: 2 cel: 0 setCycle: End self)
				)
			)
			(4
				(genieSnake dispose:)
			)
			(5
				(if (!= (genieSnake cel:) 6)
					(genieSnake setCycle: End self)
				else
					(self cue:)
				)
			)
			(6
				(eye init: setCycle: End self)
			)
			(7
				(= ticks 45)
			)
			(8
				(eye setCycle: Beg self)
			)
			(9
				(eye dispose:)
				(= state (- (if register 3 else 2) 1))
				(self cue:)
			)
		)
	)
)

(instance showItemScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						MoveTo
						(singSing approachX:)
						(singSing approachY:)
						self
				)
			)
			(1
				(gEgo
					view: 211
					posn: 147 145
					loop: 0
					cel: 0
					normal: 0
					setCycle: End self
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(gMessager say: 4 0 11 1 self) ; "Alexander shows the object to the bird, hoping to interest her."
			)
			(4
				(if (IsFlag 21)
					(gMessager say: 4 register 10 1 self)
				else
					(gMessager say: 4 register 11 2 self)
				)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(= cycles 2)
			)
			(7
				(gEgo
					reset: 4
					posn: (singSing approachX:) (singSing approachY:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance singSingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (IsFlag 21))
				(= cycles 1)
			)
			(1
				(= state
					(switch (Random 0 1)
						(0 4)
						(1 10)
					)
				)
				(-- state)
				(if local29
					(self dispose:)
				else
					(= seconds (Random 3 12))
				)
			)
			(2
				(if register
					(singSing posn: 225 105 49)
				else
					(singSing posn: 268 96 85)
				)
				(= cycles 2)
			)
			(3 0)
			(4
				(singSing loop: 7 cel: 0)
				(self changeState: 2)
				(= state 4)
			)
			(5
				(singSing setCycle: End self)
			)
			(6
				(= cycles 2)
			)
			(7
				(singSing setCycle: Beg self)
			)
			(8
				(= state 0)
				(= ticks 1)
			)
			(9 0)
			(10
				(singSing loop: 8 cel: 0)
				(self changeState: 2)
				(= state 10)
			)
			(11
				(singSing cycleSpeed: 8 setCycle: End self)
			)
			(12
				(singSing cycleSpeed: 6 cel: 0)
				(= cycles 2)
			)
			(13
				(self changeState: 8)
			)
		)
	)

	(method (dispose)
		(if (and local29 (!= local29 -1))
			(if (not gSet)
				(= gSet (Set new:))
			)
			(gSet add: ((Cue new:) cuee: local29 cuer: self yourself:))
		)
		(singSing cycleSpeed: 6)
		(= local29 (= seconds 0))
		(super dispose:)
	)
)

(instance getRibbonScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame givePoints: 1)
				(= cycles 2)
			)
			(1
				(gEgo get: 35 setHeading: 90 self) ; ribbon
			)
			(2
				(if (not (IsFlag 112))
					(SetFlag 93)
				)
				(= cycles 2)
			)
			(3
				(gEgo
					normal: 0
					setSpeed: 6
					posn: 142 149
					view: 215
					loop: 1
					cel: 0
				)
				(= cycles 2)
			)
			(4
				(gEgo setCycle: CT 3 1 self)
			)
			(5
				(= cycles 2)
			)
			(6
				(theRibbon dispose:)
				(gEgo setCycle: End self)
			)
			(7
				(= cycles 2)
			)
			(8
				(gEgo reset: 6 posn: 129 144)
				(= cycles 2)
			)
			(9
				(UnLoad 128 215)
				(gMessager say: 6 5 (if (IsFlag 10) 22 else 21) 0 self)
			)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getLetterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame givePoints: 1)
				(= cycles 2)
			)
			(1
				(gEgo get: 32 setHeading: 270 self) ; note
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo
					normal: 0
					setSpeed: 6
					posn: 138 147
					view: 215
					loop: 0
					cel: 0
				)
				(= cycles 2)
			)
			(4
				(gEgo setCycle: CT 3 1 self)
			)
			(5
				(= cycles 2)
			)
			(6
				(letter dispose:)
				(gEgo setCycle: End self)
			)
			(7
				(= cycles 2)
			)
			(8
				(gEgo reset: 7 posn: 149 142)
				(= cycles 2)
			)
			(9
				(if (gCast contains: singSing)
					(gGlobalSound2 fade: 0 15 20 1)
					(musicScr dispose:)
				else
					(++ state)
				)
				(gMessager say: 5 5 0 1 self) ; "It's a note!"
			)
			(10
				(if (!= (gGlobalSound2 prevSignal:) -1)
					(-- state)
				)
				(= cycles 2)
			)
			(11
				(gGlobalSound4 number: 213 loop: -1 play:)
				(if (& gMsgType $0002)
					(gMessager say: 5 5 0 2 self) ; "Dearest Alexander:   I cannot believe you are here, my friend! Please, please be careful! Abdul isn't about to let anyone interfere with his plans. Watch out for Abdul's genie, Alexander, and do not do anything rash. I am not without resources, and I will prevail if I can only find some small means of defense. Do nothing to try to get to me. You must not be endangered again for my sake.  Greatly in your family's debt,  Cassima"
				else
					(KQ6Print
						addText:
							{Dearest Alexander:\n\nI cannot believe you are here, my friend! Please, please be careful! Abdul isn't about to let anyone interfere with his plans. Watch out for Abdul's genie, Alexander, and do not do anything rash.}
						init: self
					)
				)
			)
			(12
				(if (& gMsgType $0002)
					(= cycles 1)
				else
					(KQ6Print
						addText:
							{I am not without resources, and I will prevail if I can only find some small means of defense. Do nothing to try to get to me. You must not be endangered again for my sake.\n\nGreatly in your family's debt,\n\nCassima}
						init: self
					)
				)
			)
			(13
				(gMessager say: 5 5 0 3 self oneOnly: 0) ; "Alexander's hand trembles as he reads the note. For the first time in his long search, he has heard her voice again--if only in writing."
			)
			(14
				(gGlobalSound4 client: self fade: 0 15 20 1)
			)
			(15
				(if (gCast contains: singSing)
					(gGlobalSound2 play:)
					(musicScr state: -1 client: musicScr cue:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance eye of Prop
	(properties
		x 128
		y 24
		view 902
		priority 14
		signal 16
	)
)

(instance singSing of Actor
	(properties
		x 252
		y 125
		z 97
		noun 4
		approachX 138
		approachY 142
		view 213
		loop 2
		priority 14
		signal 8208
	)

	(method (init param1)
		(super init: &rest)
		(self
			setScale: 0
			setStep: 4 3
			ignoreActors:
			cel: (if (not param1) 8 else 0)
		)
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 1 5) ; Look, Do
				(gMessager say: noun theVerb (if (IsFlag 21) 10 else 11))
			)
			((and (OneOf theVerb 29 46 44 66) (IsFlag 21)) ; brush, coal, teaCup, pearl
				(gMessager say: noun 29 10) ; "The little bird couldn't do anything with something of that shape!"
			)
			((== theVerb 37) ; nightingale
				(if (IsFlag 21)
					(gCurRoom setScript: windUpBirdScr)
				else
					(gCurRoom setScript: befriendSSScr)
				)
			)
			((== theVerb 2) ; Talk
				(gMessager
					say:
						noun
						theVerb
						(cond
							((not (IsFlag 21)) 11)
							((gEgo has: 32) 19) ; note
							(else 43)
						)
				)
			)
			((== theVerb 31) ; flute
				(gCurRoom setScript: fluteScr)
			)
			((not (IsFlag 21))
				(gCurRoom setScript: showItemScr 0 0)
			)
			((OneOf theVerb 15 18) ; hair, cassimaHair
				(gMessager say: noun 15 10) ; "The nightingale wouldn't know what to do with that single strand of hair."
			)
			((== theVerb 32) ; poem
				(gCurRoom setScript: givePoemScr)
			)
			((== theVerb 71) ; rose
				(if (IsFlag 94)
					(gMessager say: noun theVerb 27) ; "Alexander has already sent Cassima a rose. Surely, Alexander doesn't want to get repetitive this early in the courtship!"
				else
					(SetFlag 94)
					(gCurRoom setScript: giveRoseScr)
				)
			)
			((== theVerb 70) ; royalRing
				(gCurRoom setScript: giveRingScr)
			)
			((OneOf theVerb 42 27 28 45 8) ; boringBook, riddleBook, spellBook, clothes, dagger
				(gMessager say: noun 42 10) ; "The little bird couldn't do anything with something that heavy!"
			)
			((OneOf theVerb 33 65) ; ribbon, note
				(gMessager say: noun 33) ; "Alexander doesn't want to give that back to the nightingale! She delivered it to him!"
			)
			((OneOf theVerb 63 67) ; mint, peppermint
				(gCurRoom setScript: showItemScr 0 63)
			)
			((OneOf theVerb 35 47 68 72) ; skeletonKey, flower, rabbitFoot, scarf
				(gCurRoom setScript: showItemScr 0 theVerb)
			)
			(else
				(gCurRoom setScript: showItemScr 0 0)
			)
		)
	)
)

(instance letter of Actor
	(properties
		x 119
		y 89
		noun 5
		sightAngle 45
		approachX 146
		approachY 142
		yStep 4
		view 214
		loop 7
		cel 1
		priority 1
		signal 18448
	)

	(method (cue)
		(self posn: 112 136 setLoop: 8 cel: 0 stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: getLetterScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
		(if (!= ((gInventory at: 32) owner:) -1) ; note
			((gInventory at: 32) owner: -1) ; note
			(self setMotion: MoveTo 120 137 self)
		else
			(self cue:)
		)
	)
)

(instance theRibbon of Actor
	(properties
		x 155
		y 87
		noun 6
		sightAngle 45
		approachX 133
		approachY 143
		yStep 4
		view 214
		loop 5
		priority 1
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 signal: 18448) ; Do
		(if (!= ((gInventory at: 35) owner:) -1) ; ribbon
			((gInventory at: 35) owner: -1) ; ribbon
			(self setMotion: MoveTo 155 138 self)
		else
			(self cue:)
		)
	)

	(method (cue)
		(self posn: 153 138 setLoop: 6 cel: 0 stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: getRibbonScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance genieSnake of Prop
	(properties
		x 109
		y 5
		view 212
	)

	(method (cue)
		(self dispose:)
	)

	(method (init)
		(super init: &rest)
		(self setScript: snakeScr setPri: 14)
	)
)

(instance clown of Actor
	(properties
		x 62
		y 102
		view 717
	)

	(method (init)
		(super init: &rest)
		(self
			setScale: Scaler 100 84 134 81
			setScript: clownScr
			ignoreActors:
			setStep: 4 3
			moveSpeed: 7
			cycleSpeed: 7
			setCycle: StopWalk 2741
		)
	)
)

(instance windUpBird of Prop
	(properties
		x 141
		y 142
		view 883
		loop 5
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance tree of Feature
	(properties
		x 160
		y 30
		noun 11
		sightAngle 40
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMessager
					say:
						noun
						theVerb
						(cond
							((and (gCast contains: singSing) (IsFlag 21)) 10)
							((gCast contains: singSing) 11)
							(else 8)
						)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance holeInTree of Feature
	(properties
		x 147
		y 111
		noun 12
		sightAngle 40
		onMeCheck 128
		approachX 136
		approachY 139
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 2) ; Do, Talk
	)
)

(instance genericFeatures of Feature
	(properties)

	(method (onMe param1 &tmp temp0)
		(return
			(= noun
				(switch (= temp0 (OnControl CONTROL (param1 x:) (param1 y:)))
					(4 8)
					(8 9)
					(16 10)
					(64 13)
					(else
						(if (OneOf temp0 64 16384) 13 else 0)
					)
				)
			)
		)
	)
)

