;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use Interface)
(use HandsOffScript)
(use eRS)
(use n819)
(use PAvoider)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Grooper)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm400 0
	father 1
	stopGroop 2
	seaGull 3
	rag 4
	dishSoap 5
	beaker 6
	cageProp 7
	jaw 8
	Father 9
	junk 11
	book 12
)

(local
	local0 = -1
	local1
	[local2 8] = [18 169 35 159 54 159 44 169]
	[local10 10] = [217 10 218 11 219 12 220 13 221 14]
)

(procedure (localproc_0 &tmp temp0) ; UNUSED
	(if (> (= temp0 (GetNumber {Teleport to:})) 0)
		(gCurRoom newRoom: temp0)
	)
)

(procedure (localproc_1)
	(if (not (IsFlag 149))
		(if (IsFlag 10)
			(gCurRoom setScript: (ScriptID 66 3) 0 -1) ; lookAtCleanBirdy
		else
			(gCurRoom setScript: (ScriptID 66 0) 0 -1) ; lookAtDirtyBirdy
		)
	)
)

(instance rm400 of EcoRoom
	(properties
		lookStr 26
		picture 400
		style 7
		north 380
		picAngle 10
		vanishingX 200
		vanishingY 100
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init &tmp [temp0 20])
		(LoadMany
			rsVIEW
			400
			401
			402
			406
			404
			405
			408
			415
			416
			417
			418
			410
			411
			412
			426
			427
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 75 118 57 126 87 126 70 136 98 136 93 148 64 149 59 140 53 148 0 177 0 189 277 189 277 152 319 152 314 136 286 114 231 114 229 117 150 117 150 114 120 114 113 118
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 202 119 202 127 158 127 162 119
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 204 138 221 138 222 148 202 148
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 18 169 35 159 54 159 44 169
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 18 169 35 159 54 159 44 169
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 18 169 35 159 54 159 44 169
					yourself:
				)
		)
		(gFeatures
			add:
				littleTable
				recycleBox
				photo
				computer
				bookShelves
				certUpper
				certLower
				desk
				chair
				cabinet
				fishTank
				labTable
				coatRack
				labWindow
				labExit
				rug
				keyPad
				ceiling
				rainCoat
				chalkBoard
			eachElementDo: #init
		)
		(door init: stopUpd:)
		(jaw init: stopUpd:)
		(cageProp init:)
		(if (not (IsFlag 69))
			(cageProp setCycle: Fwd)
		else
			(cageProp stopUpd:)
		)
		(if (not (IsFlag 108))
			(if (IsFlag 64)
				(envelope init: setCel: 1 stopUpd:)
			else
				(envelope init: stopUpd:)
			)
		)
		(if (not (IsFlag 15))
			(bag init: stopUpd:)
			(bagPoly points: @local2 size: 4)
			(self addObstacle: bagPoly)
		)
		(if (and (not (gEgo has: 0)) (not (IsFlag 214))) ; sodaCan
			(sodaCan init: stopUpd:)
		)
		(seaGull init:)
		(if (not (IsFlag 10))
			(dishSoap init: stopUpd:)
		)
		(if (not (IsFlag 10))
			(rag init: stopUpd:)
		)
		(junk init: setScript: junkStuff hide: stopUpd:)
		(if (and (not (IsFlag 69)) (not (gEgo has: 34))) ; waterBottle
			(gerbilWater init: stopUpd:)
		)
		(ClearFlag 33)
		(super init: &rest)
		(gEgo init: setAvoider: PAvoider posn: 135 121)
		(switch gPrevRoomNum
			(380
				(self setScript: fromDolphinRoom)
			)
			(381
				(self setScript: fromDolphinRoom)
			)
			(else
				(self setScript: startUpStuff)
			)
		)
		(gLongSong number: 400 loop: -1 play:)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(cond
			(script 0)
			((and (IsFlag 127) (not (father script:)) (IsFlag 33))
				(father setScript: botherEgo2)
			)
			(
				(and
					(& (= temp0 (gEgo onControl: 0)) $0008)
					(IsFlag 127)
					(not (IsFlag 125))
				)
				(seaGull doVerb: 2)
			)
			((and (not (& temp0 $0008)) (IsFlag 127) (IsFlag 125))
				(ClearFlag 125)
			)
			((& temp0 $0100)
				(self setScript: bounceFromDoor)
			)
			((and (> (gEgo y:) 179) (> (gEgo x:) 57))
				(self setScript: hiYa)
			)
		)
	)

	(method (dispose)
		(gEgo setAvoider: 0)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance bagPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance junk of Actor
	(properties
		view 416
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				((ScriptID 2 1) init: 16 1) ; Adam, "Naw, couldn't be."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance father of Actor
	(properties
		lookStr 43
		view 411
		cycleSpeed 2
		illegalBits 0
		xStep 4
		moveSpeed 2
	)

	(method (dispose)
		(ClearFlag 127)
		(super dispose: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Father init: 34 1) ; "Come clean the bird now. I'm going to have to leave pretty soon and I'd like to supervise."
			)
			(3 ; Do
				(Father init: 35 1) ; "I didn't mean 'give me a hand' literally, Adam. The bird is the one that really needs your help."
			)
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 74) ; "Dad's ears are already clean, thank you very much!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance jaw of Prop
	(properties
		x 289
		y 163
		z 55
		approachX 276
		approachY 162
		lookStr 28
		view 401
		loop 4
		priority 15
		signal 16400
		cycleSpeed 0
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(3 ; Do
				(gCurRoom setScript: (ScriptID 68 2)) ; biteFinger
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 121
		y 49
		approachX 135
		approachY 121
		lookStr 30
		view 400
		priority 7
		signal 16
		cycleSpeed 3
	)

	(method (init)
		(super init: &rest)
		(if (or (== gPrevRoomNum 380) (== gPrevRoomNum 381))
			(self setCel: (self lastCel:))
		)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(if (IsFlag 127)
			(seaGull doVerb: 2)
		else
			(switch theVerb
				(4 ; Inventory
					(switch invItem
						(4 ; rag
							(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
						)
						(3 ; beaker
							(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
						)
						(else
							(super doVerb: theVerb invItem &rest)
						)
					)
				)
				(10 ; Recycle
					(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
				)
				(3 ; Do
					(Narrator posn: 160 20 init: 31) ; "The door locks electronically. Something in the next room must require security."
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance cageProp of Prop
	(properties
		x 203
		y 91
		approachX 214
		approachY 120
		view 400
		loop 12
		priority 7
		signal 16
		cycleSpeed 9
		detailLevel 3
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 3 2) ; Inventory, Do, Look
	)

	(method (doVerb theVerb invItem)
		(if (IsFlag 127)
			(seaGull doVerb: 2)
		else
			(switch theVerb
				(10 ; Recycle
					(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
				)
				(2 ; Look
					(gCurRoom setScript: (ScriptID 64 0) 0 -1) ; lookAtGerbil
				)
				(4 ; Inventory
					(switch invItem
						(4 ; rag
							(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
						)
						(3 ; beaker
							(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
						)
						(else
							(gCurRoom setScript: (ScriptID 64 0) 0 invItem) ; lookAtGerbil
						)
					)
				)
				(3 ; Do
					(gCurRoom setScript: (ScriptID 64 0) 0 -1) ; lookAtGerbil
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance gerbilWater of View
	(properties
		x 222
		y 134
		z 50
		approachX 225
		approachY 121
		view 400
		loop 5
		priority 7
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(-= nsLeft 5)
		(+= nsBottom 5)
		(+= nsRight 5)
		(-= nsTop 5)
		(self stopUpd:)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb invItem)
		(if (IsFlag 127)
			(seaGull doVerb: 2)
		else
			(switch theVerb
				(4 ; Inventory
					(switch invItem
						(4 ; rag
							(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
						)
						(3 ; beaker
							(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
						)
						(else
							(super doVerb: theVerb invItem &rest)
						)
					)
				)
				(2 ; Look
					((ScriptID 2 1) init: 15 1) ; Adam, "Oh, man, I forgot to give him the water."
				)
				(10 ; Recycle
					(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
				)
				(3 ; Do
					(gCurRoom setScript: (ScriptID 70 0) 0 gerbilWater) ; getWater
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance beaker of View
	(properties
		x 162
		y 97
		z 10
		approachX 189
		approachY 121
		lookStr 38
		view 400
		loop 9
		priority 7
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(-= nsLeft 5)
		(+= nsBottom 5)
		(+= nsRight 5)
		(-= nsTop 5)
		(self stopUpd:)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(if (IsFlag 127)
			(seaGull doVerb: 2)
		else
			(switch theVerb
				(4 ; Inventory
					(switch invItem
						(4 ; rag
							(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
						)
						(3 ; beaker
							(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
						)
						(else
							(super doVerb: theVerb invItem &rest)
						)
					)
				)
				(10 ; Recycle
					(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
				)
				(3 ; Do
					(gCurRoom setScript: (ScriptID 70 1) 0 beaker) ; getBeaker
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance dishSoap of View
	(properties
		x 173
		y 123
		approachX 180
		approachY 134
		lookStr 20
		view 400
		loop 6
		priority 9
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(3 ; Do
				(seaGull doVerb: 3)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rag of View
	(properties
		x 169
		y 120
		approachX 180
		approachY 134
		lookStr 21
		view 400
		loop 7
		priority 9
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(3 ; Do
				(seaGull doVerb: 3)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance envelope of View
	(properties
		x 61
		y 145
		z 20
		approachX 52
		approachY 144
		lookStr 54
		view 400
		loop 1
		priority 10
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(2 ; Look
				(if (IsFlag 64)
					(Narrator posn: 160 20 init: 54) ; "The envelope is torn and useless. It's been forwarded too many times."
				else
					(Narrator posn: 160 20 init: 27) ; "The mail has arrived! The letter is addressed to Adam, with many forwarding addresses."
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(3 ; Do
				(if (IsFlag 64)
					(gCurRoom setScript: (ScriptID 70 4) 0 envelope) ; getEnvelopeToToss
				else
					(gCurRoom setScript: (ScriptID 70 3) 0 envelope) ; getEnvelope
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bag of View
	(properties
		x 30
		y 150
		approachX 53
		approachY 165
		lookStr 45
		view 400
		loop 2
		priority 13
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(3 ; Do
				(gCurRoom setScript: getBag 0 bag)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sodaCan of View
	(properties
		x 27
		y 123
		z 10
		approachX 36
		approachY 153
		lookStr 39
		view 400
		loop 4
		priority 9
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(3 ; Do
				(gCurRoom setScript: (ScriptID 70 2) 0 sodaCan) ; getSodaCan
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance seaGull of View
	(properties
		x 171
		y 124
		approachX 211
		approachY 123
		view 400
		loop 3
		priority 8
		signal 16400
	)

	(method (init)
		(if (IsFlag 10)
			(= cel 0)
		else
			(= cel 1)
		)
		(super init: &rest)
		(-= nsLeft 5)
		(+= nsBottom 5)
		(+= nsRight 5)
		(-= nsTop 5)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(localproc_1)
			)
			(2 ; Look
				(localproc_1)
			)
			(4 ; Inventory
				(switch invItem
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(localproc_1)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(5 ; Talk
				(localproc_1)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance book of PicView
	(properties
		x 208
		y 190
		z 50
		approachX 200
		approachY 190
		lookStr 46
		view 400
		loop 8
		priority 10
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				((ScriptID 2 1) init: 37 1) ; Adam, "I'd better not throw away a hint book."
			)
			(3 ; Do
				(Narrator posn: 160 20 init: 70) ; "Adam doesn't have time to look at the hint book. (Rats!)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance stopGroop of Grooper
	(properties)

	(method (doit)
		(if
			(and
				(IsObject (father cycler:))
				((father cycler:) isKindOf: StopWalk)
			)
			(father view: ((father cycler:) vStopped:))
		)
		(super doit: &rest)
	)
)

(instance littleTable of Feature
	(properties
		x 315
		y 147
		nsTop 145
		nsLeft 289
		nsBottom 173
		nsRight 319
		sightAngle 45
		onMeCheck 16384
		approachX 284
		approachY 156
		lookStr 47
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance keyPad of Feature
	(properties
		x 152
		y 83
		onMeCheck 2
		approachX 148
		approachY 115
		lookStr 79
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb invItem)
		(if (IsFlag 127)
			(seaGull doVerb: 2)
		else
			(switch theVerb
				(4 ; Inventory
					(switch invItem
						(4 ; rag
							(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
						)
						(3 ; beaker
							(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
						)
						(else
							(super doVerb: theVerb invItem &rest)
						)
					)
				)
				(10 ; Recycle
					(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
				)
				(3 ; Do
					(if (gCast contains: father)
						(Narrator posn: 160 20 init: 53)
					else
						(gCurRoom setScript: toDolphinRoom)
					)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance recycleBox of Feature
	(properties
		x 2
		y 153
		nsTop 141
		nsBottom 177
		nsRight 30
		sightAngle 45
		onMeCheck 16384
		approachX 62
		approachY 165
		lookStr 9
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Inventory
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(0 ; sodaCan
						(gCurRoom setScript: (ScriptID 70 5)) ; disposeSodaCan
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(3 ; Do
				((ScriptID 2 1) init: 27 1) ; Adam, "Naw, it's just got a few things in it. I'll wait to take it to the recycling center."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance photo of Feature
	(properties
		x 9
		y 112
		nsTop 105
		nsLeft 1
		nsBottom 117
		nsRight 16
		sightAngle 45
		onMeCheck 16384
		approachX 52
		approachY 150
		lookStr 5
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(3 ; Do
				((ScriptID 2 1) init: 18 1) ; Adam, "On second thought, I like that picture right where it is."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance computer of Feature
	(properties
		x 33
		y 100
		nsTop 88
		nsLeft 8
		nsBottom 115
		nsRight 58
		sightAngle 45
		onMeCheck 8192
		approachX 52
		approachY 150
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(2 ; Look
				(SetScore 5 209)
				(if (or (not lookStr) (IsFlag 145))
					(= lookStr 40)
					(super doVerb: theVerb invItem &rest)
				else
					(SetFlag 145)
					(gCurRoom setScript: (ScriptID 63 0)) ; lookAtScreen
				)
			)
			(3 ; Do
				(Narrator posn: 160 20 init: 60) ; "After all the trouble his Dad had putting it together, Adam thinks better of touching it."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bookShelves of Feature
	(properties
		x 11
		y 67
		nsTop 44
		nsBottom 89
		nsRight 42
		sightAngle 45
		onMeCheck 16384
		approachX 52
		approachY 150
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(2 ; Look
				(= local0 (mod (++ local0) 5))
				(SetScore 1 [local10 (* 2 local0)])
				((ScriptID 2 1) init: [local10 (+ local0 local0 1)] 1) ; Adam
			)
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(3 ; Do
				(switch (Random 0 3)
					(0
						((ScriptID 2 1) init: 21 1) ; Adam, "I really don't have time right now."
					)
					(1
						((ScriptID 2 1) init: 22 1) ; Adam, "Maybe I'll put some of that info in my newsletter."
					)
					(2
						((ScriptID 2 1) init: 23 1) ; Adam, "That's a good one!"
					)
					(3
						((ScriptID 2 1) init: 25 1) ; Adam, "I knew I had unpacked that one! I'll look at it later."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance certUpper of Feature
	(properties
		x 48
		y 68
		nsTop 63
		nsLeft 44
		nsBottom 72
		nsRight 53
		sightAngle 45
		onMeCheck 16384
		approachX 75
		approachY 124
		lookStr 6
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(3 ; Do
				((ScriptID 2 1) init: 19 1) ; Adam, "It's hanging straight, so why move it?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance certLower of Feature
	(properties
		x 48
		y 82
		nsTop 76
		nsLeft 44
		nsBottom 87
		nsRight 53
		sightAngle 45
		onMeCheck 16384
		approachX 75
		approachY 124
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(2 ; Look
				((ScriptID 2 1) init: 9 1) ; Adam, "Dr. Noah Greene, Doctor of Philosophy in Ecological Sciences. Whew, there's a mouthful."
			)
			(3 ; Do
				((ScriptID 2 1) init: 20 1) ; Adam, "My dad doesn't like me getting into his personal stuff."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 50
		y 119
		nsTop 107
		nsBottom 146
		nsRight 73
		sightAngle 45
		onMeCheck 4096
		approachX 52
		approachY 150
		lookStr 41
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 76
		y 129
		nsTop 111
		nsLeft 65
		nsBottom 145
		nsRight 88
		sightAngle 45
		onMeCheck 8192
		approachX 52
		approachY 150
		lookStr 7
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(3 ; Do
				(Narrator posn: 160 20 init: 55) ; "The chair is fine where it is."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cabinet of Feature
	(properties
		x 93
		y 82
		nsTop 53
		nsLeft 77
		nsBottom 115
		nsRight 116
		sightAngle 45
		onMeCheck 16384
		approachX 101
		approachY 121
		lookStr 42
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(3 ; Do
				(Narrator posn: 160 20 init: 61) ; "Adam doesn't need any of this old junk."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fishTank of Feature
	(properties
		x 174
		y 84
		nsTop 70
		nsLeft 162
		nsBottom 90
		nsRight 187
		sightAngle 45
		onMeCheck 16384
		approachX 174
		approachY 120
		lookStr 13
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 3 2) ; Inventory, Do, Look
	)

	(method (doVerb theVerb invItem)
		(if (IsFlag 127)
			(seaGull doVerb: 2)
		else
			(switch theVerb
				(10 ; Recycle
					(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
				)
				(4 ; Inventory
					(switch invItem
						(4 ; rag
							(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
						)
						(else
							(gCurRoom setScript: (ScriptID 68 0) 0 invItem) ; lookAtTank
						)
					)
				)
				(3 ; Do
					(gCurRoom setScript: (ScriptID 68 0) 0 -1) ; lookAtTank
				)
				(2 ; Look
					(gCurRoom setScript: (ScriptID 68 0) 0 -1) ; lookAtTank
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance labTable of Feature
	(properties
		x 188
		y 94
		nsTop 85
		nsLeft 156
		nsBottom 108
		nsRight 227
		sightAngle 45
		onMeCheck 4096
		approachX 214
		approachY 120
		lookStr 11
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(3 ; Do
				(Narrator posn: 160 20 init: 57) ; "The water in the aquarium would slosh over the top if Adam moved it."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance coatRack of Feature
	(properties
		x 271
		y 79
		nsTop 52
		nsLeft 262
		nsBottom 112
		nsRight 282
		sightAngle 45
		onMeCheck 16384
		approachX 265
		approachY 119
		lookStr 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(3 ; Do
				(Narrator posn: 160 20 init: 58) ; "The coat rack is fine where it is."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance labWindow of Feature
	(properties
		x 316
		y 77
		nsTop 26
		nsLeft 287
		nsBottom 110
		nsRight 319
		sightAngle 45
		onMeCheck 16384
		approachX 290
		approachY 126
		lookStr 24
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(3 ; Do
				(Narrator posn: 160 20 init: 59) ; "The window is painted shut."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance labExit of Feature
	(properties
		x 161
		y 189
		nsTop 183
		nsBottom 189
		nsRight 53
		sightAngle 45
		onMeCheck 256
		approachX 38
		approachY 176
		lookStr 71
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rug of Feature
	(properties
		x 179
		y 157
		nsTop 137
		nsLeft 98
		nsBottom 169
		nsRight 268
		sightAngle 45
		onMeCheck 2048
		approachX 180
		approachY 151
		lookStr 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(5 ; Talk
				(SetScore 2 211)
				(cond
					((InRect 203 148 242 163 gMouseX gMouseY)
						(Narrator posn: 160 20 init: 76) ; "Zdravietey!"
					)
					((InRect 185 148 202 156 gMouseX gMouseY)
						(Narrator posn: 160 20 init: 77) ; "Bonjour!"
					)
					((InRect 141 150 169 161 gMouseX gMouseY)
						(Narrator posn: 160 20 init: 81) ; "You talkin' to ME?"
					)
					((InRect 135 162 172 176 gMouseX gMouseY)
						(Narrator posn: 160 20 init: 78) ; "Buenos dias!"
					)
					((InRect 243 153 257 161 gMouseX gMouseY)
						(Narrator posn: 160 20 init: 80) ; "Konichiwa!"
					)
					((InRect 126 151 140 159 gMouseX gMouseY)
						(Narrator posn: 160 20 init: 83) ; "Go surfin', dude."
					)
					((InRect 237 161 261 173 gMouseX gMouseY)
						(Narrator posn: 160 20 init: 84) ; "G'day"
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(3 ; Do
				((ScriptID 2 1) init: 26 1) ; Adam, "It's too heavy. I'm gonna leave it there."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ceiling of Feature
	(properties
		x 180
		y 21
		nsBottom 28
		nsRight 319
		sightAngle 45
		onMeCheck 8192
		approachX 180
		approachY 151
		lookStr 26
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chalkBoard of Feature
	(properties
		x 209
		y 60
		nsTop 38
		nsLeft 172
		nsBottom 74
		nsRight 246
		sightAngle 45
		onMeCheck 4096
		approachX 214
		approachY 120
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 3 2 10) ; Inventory, Do, Look, Recycle
	)

	(method (doVerb theVerb invItem)
		(if (IsFlag 127)
			(seaGull doVerb: 2)
		else
			(switch theVerb
				(10 ; Recycle
					(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
				)
				(3 ; Do
					(gCurRoom setScript: (ScriptID 68 1) 0 -1) ; lookAtBlackBoard
				)
				(4 ; Inventory
					(switch invItem
						(4 ; rag
							(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
						)
						(3 ; beaker
							(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
						)
						(else
							(super doVerb: theVerb invItem &rest)
						)
					)
				)
				(2 ; Look
					(gCurRoom setScript: (ScriptID 68 1) 0 -1) ; lookAtBlackBoard
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance rainCoat of Feature
	(properties
		x 279
		y 74
		nsTop 63
		nsLeft 273
		nsBottom 113
		nsRight 287
		sightAngle 45
		onMeCheck 4096
		approachX 277
		approachY 119
		lookStr 87
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator posn: 160 20 init: 95) ; "That doesn't need to be cleaned!"
					)
					(3 ; beaker
						(Narrator posn: 160 20 init: 96) ; "There's no oil there! Adam decides to save the fertilizer solution for something that really needs it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 160 20 init: 66) ; "Adam uses this bag for collecting trash when he dives, not for dealing with trash at home."
			)
			(3 ; Do
				((ScriptID 2 1) init: 34 1) ; Adam, "It doesn't fit me."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance toDolphinRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 400 loop: 11 cel: 0 setCycle: End self)
			)
			(1
				(self setScript: (ScriptID 65 0) self) ; keyStuff
			)
			(2
				(NormalEgo 3)
				(if (IsFlag 14)
					(HandsOn)
					(self dispose:)
				else
					(SetScore 5 206)
					(gSoundEffects number: 901 loop: 1 play:)
					(door startUpd: setCycle: End self)
				)
			)
			(3
				(gEgo setMotion: MoveTo 144 100 self)
			)
			(4
				(HandsOn)
				(if (IsFlag 106)
					(gCurRoom newRoom: 381)
				else
					(gCurRoom newRoom: 380)
				)
				(self dispose:)
			)
		)
	)
)

(instance botherEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(Face father gEgo)
				(= seconds 1)
			)
			(2
				(Father init: 6 1) ; "Come on over here."
				(= seconds 20)
			)
			(3
				(Father init: 7 1) ; "Come take a look."
				(self changeState: 0)
			)
		)
	)
)

(instance botherEgo2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(Face father gEgo)
				(= seconds 1)
			)
			(2
				(if (or register (gEgo has: 4) (gEgo has: 5)) ; rag, dishSoap
					(= register 0)
					(if (== global232 0)
						(Father init: 12 1 self) ; "Put the soap on the rag, okay?"
					else
						(Father init: 34 1 self) ; "Come clean the bird now. I'm going to have to leave pretty soon and I'd like to supervise."
					)
				else
					(= register 1)
					(Father init: 11 1 self) ; "I've got soap and a rag right there. Go ahead and pick them up."
				)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance startUpStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(beaker init: stopUpd:)
				(gEgo
					view: 426
					posn: 215 139
					loop: 0
					setCycle: Fwd
					cycleSpeed: 16
				)
				(father
					init:
					view: 411
					setLoop: stopGroop
					setCycle: StopWalk 410
					cycleSpeed: 10
					moveSpeed: 10
					setStep: 6 4
					setHeading: 90
					posn: 293 124
				)
				(= seconds 5)
			)
			(1
				(Father init: 1 0 self) ; "If you want to go join that volleyball game, Adam, it's okay by me."
			)
			(2
				(Father init: 2 1) ; "Why not take a break?"
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(book init:)
				(gAddToPics doit:)
				(NormalEgo 1 800 801)
				(gEgo posn: 212 139)
				(= seconds 1)
			)
			(4
				(gEgo setAvoider: PAvoider setMotion: MoveTo 304 129 self)
			)
			(5
				(= seconds 2)
			)
			(6
				((ScriptID 2 1) init: 1 1 self) ; Adam, "Ummm, I don't think so. I don't really know any of those kids."
			)
			(7
				(Father init: 3 0 self) ; "It's always that way when you move."
			)
			(8
				(Father init: 4 1 self) ; "Sooner or later you make friends. It'll happen."
			)
			(9
				((ScriptID 2 1) init: 2 1 self) ; Adam, "Sure. Maybe later."
			)
			(10
				(= seconds 3)
			)
			(11
				(father setMotion: PolyPath 182 135 self)
			)
			(12
				(father setMotion: PolyPath 151 123 self)
			)
			(13
				(father setHeading: 90 self)
			)
			(14
				(= seconds 2)
			)
			(15
				(Father init: 5 1 self) ; "Okay, lab rat! If you're going to stay inside, come give me a hand with this!"
			)
			(16
				(HandsOn)
				(SetFlag 127)
				(father setScript: botherEgo)
				(self dispose:)
			)
		)
	)
)

(instance fromDolphinRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(book init:)
				(gAddToPics doit:)
				(NormalEgo 2)
				(SetFlag 14)
				(= cycles 20)
			)
			(1
				(gSoundEffects number: 902 loop: 1 play:)
				(door startUpd: setCycle: Beg self)
			)
			(2
				(door stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bounceFromDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Narrator posn: 160 20 init: 25 self) ; "Adam doesn't know the kids who are playing outside. He'd rather stay here."
			)
			(1
				(gEgo setMotion: PolyPath 42 172 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getBag of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 417 loop: 0 cel: 0 setCycle: End self)
				(SetFlag 15)
				(register startUpd: dispose:)
			)
			(1
				(SetScore 10 207)
				(Narrator posn: 160 20 init: 69 self) ; "Adam picks up the garbage bag. He plans to use it to pick up trash when he goes diving later."
			)
			(2
				((gCurRoom obstacles:) delete: bagPoly)
				(NormalEgo 1)
				(self dispose:)
			)
		)
	)
)

(instance junkStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(if
					(and
						(not (& (gEgo onControl: 0) $0800))
						(not (gCast contains: father))
						(not (gCurRoom script:))
					)
					(junk startUpd:)
					(switch (= local1 (mod (++ local1) 4))
						(0
							(self setScript: ship self)
						)
						(1
							(self setScript: bird1 self)
						)
						(2
							(self setScript: periscope self)
						)
						(3
							(self setScript: fish self)
						)
					)
				else
					(= ticks 3)
				)
			)
			(2
				(= cycles 3)
			)
			(3
				(junk posn: -100 -100 stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance ship of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(junk
					view: 416
					show:
					loop: 0
					cel: 0
					moveSpeed: 12
					posn: 273 61
					setPri: 2
					cycleSpeed: 8
					signal: 16400
					setMotion: MoveTo 342 61 self
				)
			)
			(1
				(junk hide:)
				(self dispose:)
			)
		)
	)
)

(instance bird1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(junk
					view: 416
					loop: 2
					show:
					cel: 0
					moveSpeed: 0
					posn: 312 22
					cycleSpeed: 8
					setPri: 2
					signal: 16400
					setCycle: Fwd
					setMotion: MoveTo 308 55 self
				)
			)
			(1
				(= seconds 3)
			)
			(2
				(junk loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(junk hide:)
				(self dispose:)
			)
		)
	)
)

(instance periscope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(junkSound number: 406 loop: 1 play:)
				(junk
					view: 418
					show:
					loop: 1
					cycleSpeed: 8
					cel: 0
					moveSpeed: 0
					posn: 171 148
					setPri: -1
					ignoreActors: 1
					setCycle: End self
				)
			)
			(1
				(junkSound number: 408 loop: 1 play:)
				(junk loop: 2 cel: 0 setCycle: CT 10 1 self)
			)
			(2
				(junk cel: (+ (junk cel:) 1))
				(if (OneOf (junk cel:) 11 13)
					(junkSound number: 409 loop: 1 play:)
				)
				(if (< (++ register) 5)
					(-= state 1)
				)
				(= cycles 7)
			)
			(3
				(= cycles 5)
			)
			(4
				(= register 0)
				(junkSound number: 407 loop: 1 play:)
				(junk setCycle: End self)
			)
			(5
				(junk hide:)
				(= cycles 2)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance fish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(junk
					view: 418
					loop: 0
					show:
					cycleSpeed: 8
					cel: 0
					moveSpeed: 0
					posn: 177 157
					setPri: -1
					ignoreActors: 1
					setCycle: CT 5 1 self
				)
			)
			(1
				(junkSound number: 461 loop: 1 play:)
				(junk setCycle: End self)
			)
			(2
				(junk hide:)
				(self dispose:)
			)
		)
	)
)

(instance hiYa of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 220 self)
			)
			(1
				(gEgo
					view: 813
					setLoop: 0
					setCel: 0
					posn: (gEgo x:) 177
					moveSpeed: 0
					yStep: 3
					setCycle: 0
					setPri: 14
					setMotion: MoveTo (gEgo x:) 142 self
				)
			)
			(2
				(gEgo view: 401 loop: 6 cel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: 8 cel: 0 setCycle: Fwd)
				(= register (junk script:))
				(junk
					startUpd:
					view: 401
					loop: 7
					cel: 0
					show:
					cycleSpeed: 0
					setPri: 15
					setScript: 0
					posn: (- (gEgo x:) 10) (+ (gEgo y:) 3)
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(4
				(junk hide: setScript: register)
				(gEgo
					view: 813
					setLoop: 0
					setCel: 0
					moveSpeed: 0
					yStep: 4
					setCycle: 0
					setPri: 14
					setMotion: MoveTo (gEgo x:) 177 self
				)
			)
			(5
				(junk stopUpd:)
				(NormalEgo 3)
				(gEgo
					posn: (gEgo x:) 220
					setMotion: MoveTo (gEgo x:) 174 self
				)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance Father of Talker
	(properties
		nsTop 12
		nsLeft 19
		view 412
		viewInPrint 1
		charNum 2
		keepWindow 1
	)

	(method (init)
		(super init: fBust 0 fMouth &rest)
	)
)

(instance fBust of Prop
	(properties
		view 412
		cel 1
		signal 16400
	)
)

(instance fMouth of Prop
	(properties
		nsTop 24
		nsLeft 10
		view 412
		loop 1
		signal 16400
	)
)

(instance fEyes of Prop ; UNUSED
	(properties
		nsTop 18
		nsLeft 17
		view 412
		loop 2
		signal 16400
		cycleSpeed 80
	)
)

(instance junkSound of Sound
	(properties
		flags 1
	)
)

