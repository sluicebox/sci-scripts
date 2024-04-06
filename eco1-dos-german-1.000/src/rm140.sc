;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use Interface)
(use n804)
(use eRS)
(use n819)
(use Talker)
(use Language)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use DPath)
(use Rev)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm140 0
)

(local
	local0
	[local1 12]
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	[local20 100]
	[local120 6] = [122 85 156 85 188 84]
	[local126 3]
	local129
	[local130 4] = [35 -22 52 -9]
	[local134 4] = [37 -9 60 48]
	[local138 4] = [21 -5 41 4]
	[local142 4] = [65 -23 88 -9]
	[local146 4] = [87 -23 108 3]
	[local150 4] = [64 -1 76 9]
	[local154 4] = [26 20 39 28]
	[local158 4] = [-15 -19 14 0]
	[local162 4] = [-1 25 13 34]
	[local166 4] = [-16 32 11 44]
	[local170 4] = [11 41 28 48]
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2)
	(if (& (t1 signal:) $0008)
		(= temp0 (= temp2 0))
		(= temp1 1)
		(while (< temp2 12)
			(if (> temp0 3)
				(= temp0 0)
				(++ temp1)
			)
			([local1 temp2]
				show:
				x: (+ param1 (* 31 temp0))
				y: (+ (- param2 24) (* 24 temp1))
				stopUpd:
			)
			(++ temp0)
			(++ temp2)
		)
		(Animate (gCast elements:) 0)
	)
)

(procedure (localproc_1 &tmp temp0)
	(if (not (& (t1 signal:) $0008))
		(HandsOff)
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			([local1 temp0] hide:)
		)
		(if (IsFlag 9)
			(mixedPic dispose:)
		)
		(mosaicPuzzle dispose:)
		(localproc_6 0)
		(Animate (gCast elements:) 0)
		(if (gEgo z:)
			(gEgo y: (+ (gEgo y:) 80) z: 0)
		)
		(HandsOn)
	)
)

(procedure (localproc_2 &tmp temp0)
	(if (not (& (t1 signal:) $0008))
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			([local1 temp0] hide:)
		)
		(Animate (gCast elements:) 0)
	)
)

(procedure (localproc_3 &tmp temp0)
	(for ((= temp0 0)) (< temp0 12) ((++ temp0))
		(= [global184 temp0] ([local1 temp0] correctPosn:))
	)
)

(procedure (localproc_4 &tmp temp0)
	(for ((= temp0 0)) (< temp0 12) ((++ temp0))
		(= [local1 temp0]
			(gCast firstTrue: #perform restoreCode [global184 temp0])
		)
		([local1 temp0] node: (+ temp0 1))
	)
)

(procedure (localproc_5 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(++ global114)
	(for ((= temp0 0)) (< temp0 12) ((++ temp0))
		(if (!= ((= temp2 [local1 temp0]) node:) ([local1 temp0] correctPosn:))
			(= temp3 (gCast firstTrue: #perform restoreCode (+ temp0 1)))
			(blankSpot swapNode: temp2 temp3 calibrate:)
			(= temp4 (temp2 x:))
			(= temp5 (temp2 y:))
			(temp2 x: (temp3 x:))
			(temp2 y: (temp3 y:))
			(temp3 x: temp4)
			(temp3 y: temp5)
			(temp2 forceUpd:)
			(for ((= temp1 0)) (< temp1 12) ((++ temp1))
				(if (!= temp1 (- ([local1 temp1] correctPosn:) 1))
					(return 1)
				)
			)
		)
	)
	(return 0)
)

(procedure (localproc_6 param1)
	(if (or param1 local15)
		(if (or (!= (gCurRoom curPic:) 141) local15)
			(= local15 0)
			(gCurRoom drawPic: 141 6)
		)
	else
		(gCurRoom drawPic: 140 7)
	)
)

(procedure (localproc_7)
	(if (not local18)
		(localproc_6 1)
		(ShellInset init: addToPic:)
		(shell posn: 153 91 0 cel: 2 priority: 15 forceUpd:)
		(HandsOn)
		(gTheIconBar disable: 0)
	)
)

(procedure (localproc_8)
	(HandsOff)
	(Animate (gCast elements:) 0)
	(localproc_6 0)
	(ShellInset dispose:)
	(shell posn: 155 105 -30 cel: 0 priority: 12 forceUpd:)
	(HandsOn)
)

(procedure (localproc_9)
	(if (or (not (IsFlag 7)) (IsFlag 73))
		(localproc_6 1)
		(topEyeInset init: addToPic:)
		(bottomEyeInset init: addToPic:)
		(door view: 146 loop: 1 cel: 0 x: 156 y: 112 init:)
		(background init:)
		(eyeFeature init:)
		(tridentDesign init:)
		(if local14
			(Animate (gCast elements:) 0)
			(= local19 (Random 1 3))
			(gCurRoom setScript: depressEye)
			(= local14 0)
		)
		(if local13
			(bottomEyeInset doVerb: 4 12)
		)
	else
		(Narrator init: 16) ; "The Oracle has given her prophecy. There is no further reason to interrupt her dreaming."
	)
)

(procedure (localproc_10)
	(if (gFeatures contains: eyeFeature)
		(tridentDesign dispose:)
		(eyeFeature dispose:)
	)
	(bottomEyeInset dispose:)
	(topEyeInset dispose:)
	(background dispose:)
	(door dispose:)
	(if (gCast contains: breakage)
		(breakage dispose:)
	)
)

(procedure (localproc_11 param1 &tmp temp0)
	(= temp0 local18)
	(if (= local18 param1)
		(if (not temp0)
			(= local17 (gEgo onMeCheck:))
		)
		(gEgo onMeCheck: 0 stopUpd:)
	else
		(gEgo onMeCheck: local17 startUpd:)
		(= local17 0)
	)
)

(procedure (localproc_12 param1 param2)
	(if (< argc 2)
		(= param2 1)
	)
	(if param2
		(gKeyDownHandler addToFront: param1)
		(gMouseDownHandler addToFront: param1)
	else
		(gKeyDownHandler delete: param1)
		(gMouseDownHandler delete: param1)
	)
)

(procedure (localproc_13 param1 param2 param3 param4 param5 param6 param7 &tmp [temp0 20])
	(Graph grDRAW_LINE param2 param1 param2 param3 global207 -1 -1)
	(Graph grDRAW_LINE param2 param3 param4 param3 global207 -1 -1)
	(Graph grDRAW_LINE param4 param1 param4 param3 global207 -1 -1)
	(Graph grDRAW_LINE param2 param1 param4 param1 global207 -1 -1)
	(Graph grUPDATE_BOX (- param2 1) (- param1 1) (+ param4 1) (+ param3 1) 1)
	(proc932_8 99 140 param7 @temp0)
	(Display @temp0 dsCOORD param5 param6 dsFONT 300 dsCOLOR global207)
)

(procedure (localproc_14 param1 &tmp temp0 temp1)
	(= temp0 (t1 x:))
	(= temp1 (t1 y:))
	(cond
		(
			(or
				(InRect
					(+ temp0 [local130 0])
					(+ temp1 [local130 1])
					(+ temp0 [local130 2])
					(+ temp1 [local130 3])
					param1
				)
				(InRect
					(+ temp0 [local134 0])
					(+ temp1 [local134 1])
					(+ temp0 [local134 2])
					(+ temp1 [local134 3])
					param1
				)
				(InRect
					(+ temp0 [local138 0])
					(+ temp1 [local138 1])
					(+ temp0 [local138 2])
					(+ temp1 [local138 3])
					param1
				)
			)
			(return 1)
		)
		(
			(or
				(InRect
					(+ temp0 [local142 0])
					(+ temp1 [local142 1])
					(+ temp0 [local142 2])
					(+ temp1 [local142 3])
					param1
				)
				(InRect
					(+ temp0 [local146 0])
					(+ temp1 [local146 1])
					(+ temp0 [local146 2])
					(+ temp1 [local146 3])
					param1
				)
			)
			(return 2)
		)
		(
			(or
				(InRect
					(+ temp0 [local150 0])
					(+ temp1 [local150 1])
					(+ temp0 [local150 2])
					(+ temp1 [local150 3])
					param1
				)
				(InRect
					(+ temp0 [local154 0])
					(+ temp1 [local154 1])
					(+ temp0 [local154 2])
					(+ temp1 [local154 3])
					param1
				)
			)
			(return 3)
		)
		(
			(InRect
				(+ temp0 [local158 0])
				(+ temp1 [local158 1])
				(+ temp0 [local158 2])
				(+ temp1 [local158 3])
				param1
			)
			(return 4)
		)
		(
			(or
				(InRect
					(+ temp0 [local162 0])
					(+ temp1 [local162 1])
					(+ temp0 [local162 2])
					(+ temp1 [local162 3])
					param1
				)
				(InRect
					(+ temp0 [local166 0])
					(+ temp1 [local166 1])
					(+ temp0 [local166 2])
					(+ temp1 [local166 3])
					param1
				)
				(InRect
					(+ temp0 [local170 0])
					(+ temp1 [local170 1])
					(+ temp0 [local170 2])
					(+ temp1 [local170 3])
					param1
				)
			)
			(return 5)
		)
		(else
			(return 0)
		)
	)
)

(class TilePiece of View
	(properties
		view 143
		priority 15
		signal 16400
		correctPosn 0
		blankTile 0
		node 0
	)

	(method (init param1)
		(super init: &rest)
		(= [local1 local0] self)
		(self blankTile: param1 node: (+= local0 1) hide:)
	)

	(method (doVerb theVerb invItem &tmp temp0)
		(switch theVerb
			(3 ; Do
				(cond
					((IsFlag 9)
						(Narrator posn: 45 142 talkWidth: 224 init: 12) ; "The mosaic tile picture is already unscrambled."
					)
					((and blankTile (self check:))
						(self move:)
					)
					(blankTile
						(Narrator posn: 45 142 talkWidth: 224 init: 11) ; "Choose a tile next to the empty space."
					)
					(else
						(Narrator posn: 45 142 talkWidth: 224 init: 10) ; "Choose the tile you want to move into the empty space."
					)
				)
			)
			(2 ; Look
				(if (IsFlag 9)
					(Narrator posn: 45 142 talkWidth: 224 init: 9) ; "The mosaic tile picture on the wall is now unscrambled. Strange symbols appear in the tile's design."
				else
					(Narrator posn: 45 142 talkWidth: 224 init: 8) ; "On the wall is a mosaic tile picture. It looks like the seawater has caused the cement around the tiles to weaken and now the picture is scrambled."
				)
			)
			(4 ; Inventory
				(cond
					((== invItem 11) ; conchShell
						(Narrator posn: 45 142 talkWidth: 224 init: 57) ; "The bronze conch must have some purpose related to the Temple, but it doesn't work with the mosaic tile puzzle."
					)
					((IsFlag 9)
						(Narrator posn: 45 142 talkWidth: 224 init: 12) ; "The mosaic tile picture is already unscrambled."
					)
					(else
						(Narrator posn: 45 142 talkWidth: 224 init: 49) ; "That won't help Adam unscramble the mosaic tile picture."
					)
				)
			)
			(10 ; Recycle
				(if (IsFlag 9)
					(Narrator posn: 45 142 talkWidth: 224 init: 48) ; "Adam doesn't want to throw away the beautiful mosaic."
				else
					(Narrator posn: 45 142 talkWidth: 224 init: 47) ; "The mosaic picture is scrambled, but it needs to be fixed, not thrown away."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (check)
		(OneOf
			node
			(blankTile nTile:)
			(blankTile sTile:)
			(blankTile eTile:)
			(blankTile wTile:)
		)
	)

	(method (move &tmp [temp0 2] temp2 temp3)
		(= temp2 x)
		(= temp3 y)
		(= x (blankTile x:))
		(= y (blankTile y:))
		(blankTile x: temp2)
		(blankTile y: temp3)
		(self forceUpd:)
		(gSoundEffects number: 143 loop: 1 play:)
		(blankTile swapNode: self blankTile calibrate:)
		(if (self checkPosn:)
			(Animate (gCast elements:) 0)
			(Narrator posn: 45 142 talkWidth: 224 init: 27 self) ; "That's it! The mysterious mosaic is now fully revealed!"
		)
	)

	(method (checkPosn &tmp temp0)
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			(if (!= ([local1 temp0] node:) ([local1 temp0] correctPosn:))
				(return 0)
			)
		)
		(return 1)
	)

	(method (cue)
		(SetFlag 9)
		(SetScore 15 258)
		(if (IsFlag 30)
			(= local15 1)
		)
		(localproc_1)
		(if (IsFlag 30)
			(= local13 1)
			(localproc_9)
		)
	)
)

(class BlankSpot of TilePiece
	(properties
		nTile 0
		sTile 0
		wTile 0
		eTile 0
	)

	(method (calibrate)
		(= nTile
			(if (< node 5)
				0
			else
				(- node 4)
			)
		)
		(= sTile
			(if (> node 8)
				0
			else
				(+ node 4)
			)
		)
		(= eTile
			(if (OneOf node 4 8 12)
				0
			else
				(+ node 1)
			)
		)
		(= wTile
			(if (OneOf node 1 5 9)
				0
			else
				(- node 1)
			)
		)
	)

	(method (swapNode param1 param2 &tmp temp0 temp1)
		(= temp0 (param1 node:))
		(= temp1 (param2 node:))
		(= [local1 (- temp0 1)] param2)
		(= [local1 (- temp1 1)] param1)
		(param1 node: temp1)
		(param2 node: temp0)
	)
)

(instance rm140 of EcoRoom
	(properties
		lookStr 17
		picture 140
		style 10
		horizon 15
		south 120
	)

	(method (init)
		(LoadMany rsVIEW 140 142 143 144 146 147)
		(Load rsPIC 141)
		(plant1 setCycle: Fwd init:)
		(plant2 setCycle: Fwd init:)
		(if (and (not (gEgo has: 11)) (!= ((Inv at: 11) owner:) 120)) ; conchShell, conchShell
			(shell init: stopUpd:)
		)
		(if (not (IsFlag 9))
			(mixedPic init: stopUpd:)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 92 189 92 177 159 177 159 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 174 132 174 170 137 170 137 132
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 -10 11 -10 11 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 303 -10 319 -10 319 189 303 189
					yourself:
				)
		)
		(gFeatures
			add:
				MosaicWall
				OracleWall
				carvings
				columnPed
				pots
				stairsF
				skyF
				floorF
			eachElementDo: #init
		)
		(super init:)
		(gLongSong number: 140 loop: -1 play:)
		(NormalEgo)
		(gEgo init: posn: 182 215 ignoreHorizon: 1)
		(t10 init: blankSpot)
		(t7 init: blankSpot)
		(t5 init: blankSpot)
		(t9 init: blankSpot)
		(t4 init: blankSpot)
		(t2 init: blankSpot)
		(t8 init: blankSpot)
		(t6 init: blankSpot)
		(t1 init: blankSpot)
		(blankSpot init: 0)
		(t3 init: blankSpot)
		(t11 init: blankSpot)
		(if global184
			(localproc_4)
		)
		(blankSpot calibrate:)
		(self setRegions: 51) ; bubblesRegion
		(if (gEgo has: 19) ; goldMask
			(self setScript: enterWithMask)
		else
			(self setScript: enterScript)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (gCast contains: oracle)
					(Narrator init: 26) ; "A secret panel in the Temple wall has opened to reveal the Oracle. Cassandra the Oracle is a John Dory fish. Like all John Dory fish, she has a mysterious third eye on her side. Perhaps it is this third eye that allows the Oracle to see into the future."
				else
					(Narrator init: 17) ; "Adam is swimming inside the Temple of Poseidon. The glowing marble and mysterious symbols have a strange and wonderful power."
				)
			)
			(4 ; Inventory
				(switch invItem
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

	(method (doit)
		(cond
			(script 0)
			((and (gEgo has: 19) (== ((User alterEgo:) edgeHit:) EDGE_BOTTOM)) ; goldMask
				(gCurRoom setScript: getProphesy)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(self setScript: NoExit)
			)
		)
		(if (and (GameIsRestarting) (== local18 1) (not (IsFlag 9)))
			(localproc_13 82 154 140 167 98 156 61)
		)
		(super doit:)
		(if (and (!= (gLongSong number:) 140) (== (gLongSong prevSignal:) -1))
			(gLongSong number: 140 loop: -1 play:)
		)
	)

	(method (newRoom newRoomNumber)
		(localproc_3)
		(gLongSong fade:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 182 181 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterWithMask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(NormalDelph)
				(gDelph
					talkScript: needToSeeOracle
					posn: 79 189 0
					init:
					setStep: 8 4
					setMotion: DPath 79 130 144 94 self
				)
				(gEgo setMotion: MoveTo 182 181 self)
			)
			(2 0)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance needToSeeOracle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 2 0) init: 3 1 self) ; Delphineus, "We need to see the Oracle, Adam. You found her once - can you get her to appear again?"
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance NoExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Narrator init: 25 self) ; "Adam can exit the Temple the way he came in."
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gCurRoom horizon:) 5) self
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance useTrident of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 10 255)
				(= local13 0)
				(if (gFeatures contains: eyeFeature)
					(eyeFeature dispose:)
					(tridentDesign dispose:)
				)
				(if (IsFlag 30)
					(= next TalkWithOracle)
					(= state 8)
				)
				(= cycles 1)
			)
			(1
				(if (not gHowFast)
					(trident cycleSpeed: 5)
				else
					(trident cycleSpeed: 8)
				)
				(trident init: setCycle: CT 4 1 self)
			)
			(2
				(= cycles 5)
			)
			(3
				(gSoundEffects number: 144 loop: 1 play:)
				(trident setCycle: End self)
			)
			(4
				(trident setCycle: Beg self)
			)
			(5
				(trident dispose:)
				(= cycles 3)
			)
			(6
				(if (gCast contains: breakage)
					(gSoundEffects number: 165 loop: 1 play:)
					(ShakeScreen 7 ssLEFTRIGHT)
					(breakage
						setLoop: 1
						cel: 0
						cycleSpeed: 7
						setCycle: End self
					)
				else
					(self changeState: 8)
				)
			)
			(7
				(breakage dispose:)
				(= cycles 3)
			)
			(8
				(UnLoad 128 155)
				(Narrator posn: -1 5 talkWidth: 224 init: 4 self) ; "The trident pushes in the three eyes and the wall trembles. A panel slowly opens..."
			)
			(9
				(background init: stopUpd:)
				(gSoundEffects number: 145 loop: 1 flags: 1 play:)
				(door
					cel: 1
					setMotion: MoveTo (door x:) (- (door nsTop:) 1) self
				)
			)
			(10
				(gSoundEffects stop:)
				(door hide:)
				(self setScript: oracleAppears self)
			)
			(11
				(cond
					((IsFlag 73)
						(gCurRoom setScript: HelpMePlease)
					)
					((IsFlag 31)
						(gCurRoom setScript: askRiddles)
					)
					((and (IsFlag 4) (not (gEgo has: 19))) ; goldMask
						(gCurRoom setScript: finishCitizens)
					)
					(else
						(if (IsFlag 29)
							(= state 13)
						)
						(= cycles 1)
					)
				)
			)
			(12
				(Narrator posn: -1 5 talkWidth: 224 init: 30 self) ; "A fish appears mysteriously from somewhere behind the panel. It must be the Oracle!"
			)
			(13
				(Oracle init: 1 1 self) ; "The Oracle knows all life in the sea, But, creature of man, I know not thee."
			)
			(14
				(HandsOn)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance TalkWithOracle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 2 257)
				(cond
					((not (SetFlag 29))
						(= cycles 1)
					)
					((IsFlag 4)
						(if gFastCast
							(Oracle dispose:)
						)
						(gCurRoom setScript: finishCitizens)
					)
					(else
						(= state 2)
						(= cycles 1)
					)
				)
			)
			(1
				((ScriptID 2 1) init: 1 1 self) ; Adam, "My name is Adam. I came here with Delphineus to help save the kingdom. What can I do to help?"
			)
			(2
				(Oracle init: 2 0 self) ; "A prophecy from ancient year,  Spoke of days of death and fear.  A human boy, kind and brave,  Would the Kingdom of Eluria save.  Three riddles will your soul reveal,  Use your heart, the truth to feel."
			)
			(3
				(if (IsFlag 9)
					(if gFastCast
						(Oracle dispose:)
					)
					(gCurRoom setScript: askRiddles)
				else
					(Oracle say: 3 1 self)
					(SetFlag 30)
				)
			)
			(4
				(self setScript: closeOracle self)
			)
			(5
				(= local15 1)
				(MosaicWall doVerb: 3)
				(= cycles 1)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance askRiddles of Script
	(properties)

	(method (init)
		(LoadMany rsVIEW 152 153 154)
		(super init: &rest)
		(HandsOff)
		(localproc_0 26 136)
		(gTheIconBar curIcon: (gTheIconBar at: 1))
		(HandsOn)
		(gTheIconBar disable: 5 0 3 4 5)
		(if (IsFlag 15)
			(gTheIconBar disable: 6)
		)
		(User canInput: 1)
		(localproc_12 self)
		(oracle setCycle: 0 startUpd:)
	)

	(method (dispose)
		(localproc_12 self 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(== state 3)
				(!= (event type:) evVERB)
				(not
					(OneOf
						(event message:)
						KEY_TAB
						KEY_CONTROL
						KEY_F1
						KEY_F2
						KEY_F5
						KEY_F7
						KEY_F9
					)
				)
				(not (event modifiers:))
			)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(cond
				((== (gTheIconBar curIcon:) (gTheIconBar at: 1))
					(switch (= local129 (localproc_14 event))
						(1
							(Narrator posn: -1 5 talkWidth: 224 init: 18) ; "There's a symbol of a man in the mosaic picture."
						)
						(2
							(Narrator posn: -1 5 talkWidth: 224 init: 19) ; "There's a symbol of a fish in the mosaic picture."
						)
						(3
							(Narrator posn: -1 0 talkWidth: 224 init: 21) ; "There's a symbol of a heart in the mosaic picture."
						)
						(4
							(Narrator posn: -1 5 talkWidth: 224 init: 22) ; "There's a symbol of a frond in the mosaic picture."
						)
						(5
							(Narrator posn: -1 5 talkWidth: 224 init: 20) ; "There's a symbol of a dog in the mosaic picture."
						)
						(0
							(if
								(not
									(InRect
										(t1 nsLeft:)
										(t1 nsTop:)
										(blankSpot nsRight:)
										(blankSpot nsBottom:)
										event
									)
								)
								(Narrator init: 52) ; "Adam is swimming in the Temple of Poseidon."
							else
								(Narrator init: 9) ; "The mosaic tile picture on the wall is now unscrambled. Strange symbols appear in the tile's design."
							)
						)
					)
					(= state 2)
					(= cycles 1)
				)
				((== (gTheIconBar curIcon:) (gTheIconBar at: 2))
					(localproc_2)
					(= state 3)
					(switch (= local129 (localproc_14 event))
						(1
							((ScriptID 2 1) init: 2 1 self) ; Adam, "Is the answer Man?"
						)
						(2
							((ScriptID 2 1) init: 3 1 self) ; Adam, "Is the answer Fish?"
						)
						(3
							((ScriptID 2 1) init: 4 1 self) ; Adam, "Is the answer Love?"
						)
						(4
							((ScriptID 2 1) init: 8 1 self) ; Adam, "Is the answer Frond?"
						)
						(5
							((ScriptID 2 1) init: 6 1 self) ; Adam, "Is the answer Dog?"
						)
						(0
							(Narrator posn: -1 5 talkWidth: 224 init: 42 self) ; "Place the cursor over the mosaic tile picture and click on the correct symbol to answer the riddle."
							(= state -1)
						)
					)
				)
			)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState &tmp [temp0 500])
		(switch (= state newState)
			(0
				(if (IsFlag 30)
					(Oracle init: 23 1 self) ; "Three riddles will your soul reveal, Use your heart, the truth to feel."
					(ClearFlag 30)
				else
					(= cycles 1)
				)
			)
			(1
				(if (IsFlag 31)
					(Oracle init: 16 1 self) ; "Try again, the riddles wait. With your answers choose your fate."
					(ClearFlag 31)
				else
					(= cycles 1)
				)
			)
			(2
				(if (gCast contains: bubble)
					(bubble dispose:)
					(Animate (gCast elements:) 0)
				)
				(switch global118
					(1
						(Oracle init: 7 1 self) ; "Here's the first riddle to master, From the picture, choose an answer."
					)
					(2
						(Oracle init: 10 1 self) ; "Here's the second you must master, From the picture, choose an answer."
					)
					(3
						(Oracle init: 11 1 self) ; "Here's the third and last to master, From the picture, choose an answer."
					)
					(4
						(= state 6)
						(= cycles 1)
					)
				)
			)
			(3
				(if (<= global118 3)
					(localproc_0 26 136)
					(Animate (gCast elements:) 0)
				)
				(switch global118
					(1
						(Print
							(proc932_8 1 gCurRoomNum 4 @temp0)
							#icon
							142
							0
							0
							#at
							-1
							5
							#dispose
						)
					)
					(2
						(Print
							(proc932_8 1 gCurRoomNum 8 @temp0)
							#icon
							142
							0
							0
							#at
							-1
							5
							#dispose
						)
					)
					(3
						(Print
							(proc932_8 1 gCurRoomNum 12 @temp0)
							#icon
							142
							0
							0
							#at
							-1
							5
							#dispose
						)
					)
				)
			)
			(4
				(if (!= global118 local129)
					(= state 9)
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(5
				(switch global118
					(1
						(SetScore 5 259)
					)
					(2
						(SetScore 5 260)
					)
					(3
						(SetScore 5 261)
					)
				)
				(Oracle init: 5 1 self) ; "The riddle have you answered true.  A vision will I grant to you."
				(localproc_2)
			)
			(6
				(bubble
					view: (+ 151 global118)
					loop: 0
					cel: 0
					x: (- 160 (/ (CelWide (+ 151 global118) 0 0) 2))
					y: 85
					setPri: 15
					init:
					stopUpd:
				)
				(Animate (gCast elements:) 0)
				(switch global118
					(1
						(Oracle init: 6 0 self) ; "Once there was a great whale King, Whose tail kept off all poisonous things. Like under glass we lived so free, From all with which man kills the seas."
					)
					(2
						(Oracle init: 9 0 self) ; "And so an innocent shall fall, And become the stalker of us all. Mutated by a glowing breeze, Man makes a murderer of the seas."
					)
					(3
						(Oracle nsTop: 10 init: 13 0 self) ; "A mighty King was led astray, Tricked and lured into harm's way. With all his strength he cannot free, Himself from man's machinery. Our destiny now lies with he, Foretold within the prophecy."
						(SetFlag 4)
						(SetFlag 45)
					)
				)
				(++ global118)
				(= state 1)
			)
			(7
				((ScriptID 2 1) init: 5 1 self) ; Adam, "The prophecy says a child of man might help save Eluria? Could that be me?"
			)
			(8
				(Oracle init: 14 1 self) ; "Your answers show that you can see, The carelessness that haunts the seas. But the citizens must give their trust, To you alone - win them you must. This 'Sign of Trust' bring back to me, And you shall have the prophecy."
			)
			(9
				(= state 10)
				(= cycles 1)
			)
			(10
				(SetFlag 31)
				(Oracle init: 15 1 self) ; "That's not the answer that I see. The ocean's voice speaks not in thee. Return when you understand the sea."
			)
			(11
				(self setScript: closeOracle self 1)
			)
			(12
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance closeOracle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gCast contains: oracle)
					(self setScript: oracleDisappears self)
				else
					(self changeState: 3)
				)
			)
			(1
				(gSoundEffects number: 145 loop: 1 play:)
				(door show: setMotion: MoveTo 156 112 self)
			)
			(2
				(door cel: 0 addToPic:)
				(gSoundEffects number: 165 loop: 1 flags: 0 play: self)
			)
			(3
				(if register
					(= register 0)
					(localproc_6 0)
				)
				(localproc_10)
				(gFeatures delete: door topEyeInset bottomEyeInset)
				(= cycles 1)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance finishCitizens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Oracle init: 17 1 self) ; "The citizens must give their trust,  To you alone - win them you must. This 'Sign of Trust' bring back to me, And you shall have the prophecy."
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 0)
				(= seconds 10)
			)
			(2
				(self setScript: closeOracle self 1)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance showAnyObject of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Oracle init: 18 1 self) ; "That is not the sign I seek, The citizens have yet to speak."
			)
			(1
				(= seconds 4)
			)
			(2
				(self setScript: closeOracle self 1)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveMask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gDelph talkScript: 0)
				(SetScore 10 262)
				(Narrator posn: -1 5 talkWidth: 224 init: 29 self) ; "Adam hands the gold mask to the Oracle, holding his breath with anticipation."
				(gEgo put: 19 140) ; goldMask
			)
			(1
				(Oracle init: 19 0 self) ; "A 'Sign of Trust' is given to me. A mask of gold for all to see. Poseidon's favor has been won, By the child 'Adam' - the chosen one."
			)
			(2
				(Oracle say: 20 1 self)
			)
			(3
				((ScriptID 2 1) init: 7 1 self) ; Adam, "But HOW can I save the Kingdom?"
			)
			(4
				(Oracle init: 21 0 self) ; "Only fragments can I see, But let me tell them now to thee:  Armor for a modern knight,  From the depths, a glowing light.  A net of bones, a wall of stones,  A floating orb, a silver wire,  Will help you in a place most dire."
			)
			(5
				(Oracle say: 22 1 self)
			)
			(6
				(Narrator posn: -1 5 talkWidth: 224 init: 5 self) ; "Adam takes a parchment scroll containing the prophecy from the Oracle."
				(OracleWall approachVerbs: 26505) ; ???
				(carvings approachVerbs: 26505) ; ???
				(SetFlag 7)
				(gEgo get: 33) ; scroll
			)
			(7
				(self setScript: closeOracle self 1)
			)
			(8
				((ScriptID 2 0) init: 1 1 self) ; Delphineus, "Wow! A prophecy! And to think I didn't know if I should bring you, Adam! Let's get started on our quest outside the city!"
			)
			(9
				(gDelph setMotion: DPath 79 130 79 260 self)
			)
			(10
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance oracleAppears of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rippleBg init: view: 151 loop: 2 cel: 0 setCycle: CT 7 1 self)
				(gSoundEffects number: 146 loop: 1 play:)
				(oracle init: view: 149 loop: 0 cel: 0 setCycle: End oracle)
			)
			(1
				(background setLoop: 1 cel: 0 setCycle: Fwd)
				(rippleBg cel: 8 setCycle: ForwardCounter 2 self)
			)
			(2
				(rippleBg hide: setCycle: 0 stopUpd:)
				(= cycles 1)
			)
			(3
				(oracle view: 142 loop: 4 cel: 0 setCycle: Fwd)
				(background setCycle: End self)
			)
			(4
				(background setLoop: 0 cel: 0 setCycle: 0 stopUpd:)
				(gLongSong number: 141 loop: -1 flags: 1 play:)
				(= seconds 2)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance oracleDisappears of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local16 1)
				(rippleBg show: setLoop: 2 cel: 0 setCycle: End self)
				(oracle view: 149 loop: 1 cel: 7 setCycle: Rev)
				(background view: 151 loop: 1 cel: 7 setCycle: Rev)
			)
			(1
				(gLongSong fade:)
				(gSoundEffects number: 146 loop: 1 play:)
				(oracle setLoop: 0 cel: 14 setCycle: Beg oracle)
				(rippleBg cel: 0 setCycle: End self)
			)
			(2
				(background view: 151 loop: 3 cel: 5 setCycle: CT 2 -1 self)
			)
			(3
				(rippleBg dispose:)
				(background setCycle: Beg self)
			)
			(4
				(= seconds 2)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance getProphesy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 2 0) init: 2 1 self) ; Delphineus, "We need to get the prophecy from the Oracle, Adam, or we'll never know WHAT to do!"
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x:) 184 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance HelpMePlease of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Oracle init: 24 1 self) ; "Look beyond the lost ship's door To find the one you're looking for."
			)
			(1
				(gCurRoom setScript: closeOracle 0 1)
			)
		)
	)
)

(instance plant1 of Prop
	(properties
		x 220
		y 189
		onMeCheck 0
		view 140
		priority 14
		signal 16400
		cycleSpeed 13
		detailLevel 2
	)
)

(instance plant2 of Prop
	(properties
		x 95
		y 151
		onMeCheck 0
		view 140
		loop 1
		cel 1
		signal 16400
		cycleSpeed 15
		detailLevel 2
	)
)

(instance ShellInset of View
	(properties
		x 154
		y 110
		lookStr 7
		view 147
		priority 14
		signal 16
	)

	(method (init)
		(if (not z)
			(proc804_8 self)
		)
		(super init: &rest)
		(localproc_12 self)
		(localproc_11 2)
	)

	(method (dispose)
		(localproc_12 self 0)
		(localproc_11 0)
		(super dispose:)
		(gFeatures delete: self)
	)

	(method (handleEvent event)
		(if
			(and
				(!= (event type:) evVERB)
				(not (event modifiers:))
				(not
					(OneOf
						(event message:)
						KEY_TAB
						KEY_CONTROL
						KEY_F1
						KEY_F2
						KEY_F5
						KEY_F7
						KEY_F9
					)
				)
				(not (InRect nsLeft nsTop nsRight nsBottom event))
			)
			(event claimed: 1)
			(localproc_8)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 45 142 talkWidth: 224 init: 7) ; "On the front of the marble pedestal is a bas-relief of a man kneeling and blowing into a conch shell."
				(if (== ((Inv at: 11) owner:) 140) ; conchShell
					(Narrator store: 31)
				)
			)
			(4 ; Inventory
				(switch invItem
					(11 ; conchShell
						(shell posn: 153 91 0 cel: 2 init: setPri: 15 stopUpd:)
						(gEgo put: 11 140) ; conchShell
						(Animate (gCast elements:) 0)
						(Narrator posn: 45 142 talkWidth: 224 init: 56) ; "Adam puts the conch shell back on the pedestal."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(3 ; Do
				(Narrator init: 33) ; "The pedestal is too heavy to take. Besides, it's also connected to the Temple floor."
			)
			(10 ; Recycle
				(Narrator posn: 45 142 talkWidth: 224 init: 46) ; "The pedestal is too large and heavy to throw away. Besides, it belongs in the Temple."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance shell of View
	(properties
		x 155
		y 105
		z -30
		lookStr 6
		view 140
		loop 2
		priority 12
		signal 16401
	)

	(method (dispose)
		(super dispose:)
		(if (== gCurRoomNum gNewRoomNum)
			(localproc_8)
		)
	)

	(method (doVerb theVerb)
		(if (or (not local18) (== local18 2))
			(switch theVerb
				(2 ; Look
					(if (not cel)
						(localproc_7)
						(Animate (gCast elements:) 0)
						(Narrator
							posn: 45 142
							talkWidth: 224
							store: 31
							init: 32 ; "A pedestal stands in the middle of the Temple."
						)
					else
						(Narrator posn: 45 142 talkWidth: 224 init: lookStr)
					)
				)
				(3 ; Do
					(if (not cel)
						(localproc_7)
					else
						(gCurRoom setScript: getConchShell)
					)
				)
				(10 ; Recycle
					(Narrator posn: 45 142 talkWidth: 224 init: 45) ; "The bronze conch shell is much too beautiful to just throw away!"
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance getConchShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator posn: 45 142 talkWidth: 224 init: 1 self) ; "Adam takes the bronze conch shell."
				(SetScore 2 256)
				(gEgo get: 11) ; conchShell
			)
			(1
				(shell dispose:)
				(self dispose:)
			)
		)
	)
)

(instance columnPed of Feature
	(properties
		onMeCheck 256
		lookStr 7
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(localproc_7)
				(Animate (gCast elements:) 0)
				(Narrator posn: 45 142 talkWidth: 224 init: 32) ; "A pedestal stands in the middle of the Temple."
				(if (== ((Inv at: 11) owner:) 140) ; conchShell
					(Narrator store: 31)
				)
			)
			(4 ; Inventory
				(if (== invItem 11) ; conchShell
					(shell posn: 155 105 -30 cel: 0 init: setPri: 12 stopUpd:)
					(gEgo put: 11 140) ; conchShell
					(Animate (gCast elements:) 0)
					(Narrator init: 56) ; "Adam puts the conch shell back on the pedestal."
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(3 ; Do
				(Narrator posn: 45 142 talkWidth: 224 init: 33) ; "The pedestal is too heavy to take. Besides, it's also connected to the Temple floor."
			)
			(10 ; Recycle
				(Narrator posn: 45 142 talkWidth: 224 init: 46) ; "The pedestal is too large and heavy to throw away. Besides, it belongs in the Temple."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance mixedPic of View
	(properties
		x 62
		y 102
		onMeCheck 0
		view 156
		signal 16400
	)
)

(instance MosaicWall of Feature
	(properties
		x 69
		y 97
		onMeCheck 2
		approachX 105
		approachY 105
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 3) ; Look, Do
	)

	(method (doVerb theVerb)
		(if (or (not local18) (== local18 1))
			(cond
				((OneOf theVerb 2 3) ; Look, Do
					(localproc_6 1)
					(mosaicPuzzle init: addToPic:)
					(localproc_0 106 80)
					(gEgo y: (- (gEgo y:) 80) z: -80)
					(Animate (gCast elements:) 0)
					(if (not (IsFlag 9))
						(localproc_13 82 154 140 167 98 156 61)
					)
					(HandsOn)
					(gTheIconBar disable: 0 3 4 6 5)
					(t1 doVerb: 2)
				)
				((== theVerb 10) ; Recycle
					(if (IsFlag 9)
						(Narrator posn: 45 142 talkWidth: 224 init: 48) ; "Adam doesn't want to throw away the beautiful mosaic."
					else
						(Narrator posn: 45 142 talkWidth: 224 init: 47) ; "The mosaic picture is scrambled, but it needs to be fixed, not thrown away."
					)
				)
				((== theVerb 4) ; Inventory
					(if (IsFlag 9)
						(Narrator posn: 45 142 talkWidth: 224 init: 12) ; "The mosaic tile picture is already unscrambled."
					else
						(Narrator posn: 45 142 talkWidth: 224 init: 49) ; "That won't help Adam unscramble the mosaic tile picture."
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance mosaicPuzzle of View
	(properties
		x 144
		y 28
		view 148
		priority 14
		signal 16
	)

	(method (init)
		(super init:)
		(localproc_12 self)
		(gTheIconBar curIcon: (gTheIconBar at: 2))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		(localproc_11 1)
	)

	(method (dispose)
		(localproc_12 self 0)
		(localproc_11 0)
		(super dispose:)
		(gFeatures delete: self)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(!= (event type:) evVERB)
					(not
						(OneOf
							(event message:)
							KEY_TAB
							KEY_CONTROL
							KEY_F1
							KEY_F2
							KEY_F5
							KEY_F7
							KEY_F9
						)
					)
					(not (InRect nsLeft nsTop nsRight nsBottom event))
					(not (event modifiers:))
				)
				(if (and (not (IsFlag 9)) (InRect 82 154 140 167 event))
					(if (and (not (localproc_5)) (not (IsFlag 9)))
						(Animate (gCast elements:) 0)
						(Narrator posn: 45 142 talkWidth: 224 init: 27 t1) ; "That's it! The mysterious mosaic is now fully revealed!"
					)
				else
					(localproc_1)
				)
				(event claimed: 1)
			)
			(
				(and
					(IsFlag 9)
					(== (gTheIconBar curIcon:) (gTheIconBar at: 1))
					(= local129 (localproc_14 event))
				)
				(switch local129
					(1
						(Narrator posn: -1 5 talkWidth: 224 init: 18) ; "There's a symbol of a man in the mosaic picture."
					)
					(2
						(Narrator posn: -1 5 talkWidth: 224 init: 19) ; "There's a symbol of a fish in the mosaic picture."
					)
					(3
						(Narrator posn: -1 5 talkWidth: 224 init: 21) ; "There's a symbol of a heart in the mosaic picture."
					)
					(4
						(Narrator posn: -1 5 talkWidth: 224 init: 22) ; "There's a symbol of a frond in the mosaic picture."
					)
					(5
						(Narrator posn: -1 5 talkWidth: 224 init: 20) ; "There's a symbol of a dog in the mosaic picture."
					)
				)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(t1 doVerb: 2)
			)
			(4 ; Inventory
				(if (== invItem 11) ; conchShell
					(Narrator posn: -1 5 talkWidth: 224 init: 57) ; "The bronze conch must have some purpose related to the Temple, but it doesn't work with the mosaic tile puzzle."
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance t1 of TilePiece
	(properties
		loop 1
		correctPosn 1
	)
)

(instance t2 of TilePiece
	(properties
		loop 1
		cel 1
		correctPosn 2
	)
)

(instance t3 of TilePiece
	(properties
		loop 1
		cel 2
		correctPosn 3
	)
)

(instance t4 of TilePiece
	(properties
		loop 1
		cel 3
		correctPosn 4
	)
)

(instance t5 of TilePiece
	(properties
		loop 1
		cel 4
		correctPosn 5
	)
)

(instance t6 of TilePiece
	(properties
		loop 1
		cel 5
		correctPosn 6
	)
)

(instance t7 of TilePiece
	(properties
		loop 1
		cel 6
		correctPosn 7
	)
)

(instance t8 of TilePiece
	(properties
		loop 1
		cel 7
		correctPosn 8
	)
)

(instance t9 of TilePiece
	(properties
		loop 1
		cel 8
		correctPosn 9
	)
)

(instance t10 of TilePiece
	(properties
		loop 1
		cel 9
		correctPosn 10
	)
)

(instance t11 of TilePiece
	(properties
		loop 1
		cel 10
		correctPosn 11
	)
)

(instance blankSpot of BlankSpot
	(properties
		loop 2
		correctPosn 12
	)
)

(instance carvings of Feature
	(properties
		x 242
		y 89
		onMeCheck 8
		approachX 198
		approachY 97
		lookStr 13
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 7))
			(self approachVerbs: 4) ; Inventory
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(12 ; trident
						(Narrator init: 51) ; "Adam doesn't see a place to use the trident on that section of the wall."
					)
					(11 ; conchShell
						(Narrator init: 58) ; "The bronze conch must have some purpose related to the Temple, but it doesn't work on the carvings."
					)
					(else
						(Narrator init: 24) ; "That object does not seem to work on the carvings."
					)
				)
			)
			(3 ; Do
				(Narrator init: 14) ; "Adam examines some of the carvings, but doesn't see anything to do on that part of the wall."
			)
			(10 ; Recycle
				(Narrator init: 50) ; "The mysterious carvings strain Adam's brain and he thinks about throwing them away, but he couldn't get them off the wall even if he wanted to."
			)
			(5 ; Talk
				(Narrator init: 54) ; "The Temple wall does not respond."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance OracleWall of Feature
	(properties
		x 242
		y 89
		onMeCheck 64
		approachX 198
		approachY 97
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 7))
			(self approachVerbs: 4 3 2) ; Inventory, Do, Look
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(12 ; trident
						(= local13 1)
						(localproc_9)
					)
					(else
						(Narrator init: 23) ; "That object does not seem to work on the three eyes."
					)
				)
			)
			(2 ; Look
				(localproc_9)
				(Animate (gCast elements:) 0)
				(if (or (not (IsFlag 7)) (IsFlag 73))
					(Narrator posn: -1 5 talkWidth: 224 init: 28) ; "An odd carving of three large eyes dominates the center of the back wall of the Temple."
				else
					(Narrator posn: -1 5 talkWidth: 224 store: 28)
				)
			)
			(3 ; Do
				(= local14 1)
				(localproc_9)
			)
			(5 ; Talk
				(Narrator init: 54) ; "The Temple wall does not respond."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance topEyeInset of View
	(properties
		x 143
		y 67
		view 146
		priority 14
		signal 16400
	)

	(method (doVerb)
		(bottomEyeInset doVerb: &rest)
	)
)

(instance bottomEyeInset of View
	(properties
		x 151
		y 66
		z -87
		view 146
		cel 1
		priority 13
		signal 16400
	)

	(method (init)
		(super init:)
		(localproc_11 3)
		(if (gCast contains: gDelph)
			(gDelph
				talkScript: 0
				stopUpd:
				y: (- (gDelph y:) 1000)
				z: (- (gDelph z:) 1000)
				onMeCheck: 0
			)
		)
		(localproc_12 self)
		(if (not (IsFlag 255))
			(breakage init:)
		)
	)

	(method (dispose)
		(localproc_12 self 0)
		(if (gCast contains: gDelph)
			(gDelph
				y: (+ (gDelph y:) 1000)
				z: (+ (gDelph z:) 1000)
				onMeCheck: 26505
			)
		)
		(localproc_11 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(not (gCurRoom script:))
				(not (gCast contains: oracle))
				(not
					(OneOf
						(event message:)
						KEY_TAB
						KEY_CONTROL
						KEY_F1
						KEY_F2
						KEY_F5
						KEY_F7
						KEY_F9
					)
				)
				(!= (event type:) evVERB)
				(not
					(InRect
						(topEyeInset nsLeft:)
						(topEyeInset nsTop:)
						nsRight
						nsBottom
						event
					)
				)
				(not (event modifiers:))
			)
			(event claimed: 1)
			(gCurRoom setScript: closeOracle 0 1)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (gCast contains: oracle)
					(Narrator posn: -1 5 talkWidth: 224 init: 26) ; "A secret panel in the Temple wall has opened to reveal the Oracle. Cassandra the Oracle is a John Dory fish. Like all John Dory fish, she has a mysterious third eye on her side. Perhaps it is this third eye that allows the Oracle to see into the future."
				else
					(Narrator posn: -1 5 talkWidth: 224 init: 28) ; "An odd carving of three large eyes dominates the center of the back wall of the Temple."
				)
			)
			(4 ; Inventory
				(switch invItem
					(12 ; trident
						(cond
							((and (IsFlag 7) (not (IsFlag 73)))
								(Narrator posn: -1 5 talkWidth: 224 init: 16) ; "The Oracle has given her prophecy. There is no further reason to interrupt her dreaming."
							)
							((not (gCast contains: oracle))
								(gCurRoom setScript: useTrident)
							)
							(else
								(Narrator init: 59) ; "The Oracle panel is already open. Adam doesn't need to use the trident now."
							)
						)
					)
					(11 ; conchShell
						(Narrator posn: -1 5 talkWidth: 224 init: 58) ; "The bronze conch must have some purpose related to the Temple, but it doesn't work on the carvings."
					)
					(else
						(Narrator posn: -1 5 talkWidth: 224 init: 23) ; "That object does not seem to work on the three eyes."
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: -1 5 talkWidth: 224 init: 50) ; "The mysterious carvings strain Adam's brain and he thinks about throwing them away, but he couldn't get them off the wall even if he wanted to."
			)
			(5 ; Talk
				(if (not (gCast contains: oracle))
					(Narrator posn: -1 5 talkWidth: 224 init: 54) ; "The Temple wall does not respond."
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(3 ; Do
				(if (gCast contains: oracle)
					(Narrator posn: -1 5 talkWidth: 224 init: 55) ; "Adam cannot enter the Oracle's secret chamber."
				else
					(Narrator posn: -1 5 talkWidth: 224 init: 28) ; "An odd carving of three large eyes dominates the center of the back wall of the Temple."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance door of Actor
	(properties)

	(method (init)
		(self
			view: 146
			loop: 1
			cel: 0 x 156
			y: 112
			illegalBits: 0
			priority: 13
			signal: 16401
		)
		(super init: &rest)
	)

	(method (doVerb)
		(bottomEyeInset doVerb: &rest)
	)
)

(instance breakage of Prop
	(properties
		x 156
		y 121
		view 155
		priority 14
		signal 17
	)

	(method (init)
		(if (not z)
			(proc804_8 self)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(bottomEyeInset doVerb: &rest)
	)
)

(instance background of Prop
	(properties
		x 156
		y 91
		view 151
		priority 9
		signal 16401
	)

	(method (init)
		(if (not z)
			(proc804_8 self)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Narrator posn: -1 5 talkWidth: 224 init: 26) ; "A secret panel in the Temple wall has opened to reveal the Oracle. Cassandra the Oracle is a John Dory fish. Like all John Dory fish, she has a mysterious third eye on her side. Perhaps it is this third eye that allows the Oracle to see into the future."
		else
			(bottomEyeInset doVerb: theVerb &rest)
		)
	)
)

(instance rippleBg of Prop
	(properties
		x 156
		y 92
		view 151
		loop 1
		priority 10
		signal 16400
		cycleSpeed 12
	)
)

(instance oracle of Prop
	(properties
		x 162
		y 98
		z 7
		lookStr 26
		view 143
		priority 11
		signal 20496
	)

	(method (cue)
		(if local16
			(= local16 0)
			(self dispose:)
		else
			(self loop: 1 cel: 0 setCycle: Fwd)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator posn: -1 5 talkWidth: 224 init: 15) ; "The Oracle's scales are too delicate for a human's rough touch."
			)
			(5 ; Talk
				(gCurRoom setScript: TalkWithOracle)
			)
			(4 ; Inventory
				(if (IsFlag 4)
					(switch invItem
						(19 ; goldMask
							(gCurRoom setScript: giveMask)
						)
						(else
							(gCurRoom setScript: showAnyObject)
						)
					)
				else
					(Narrator posn: -1 5 talkWidth: 224 init: 41) ; "The Oracle Cassandra is not interested in any material posessions Adam has at this time. She is beyond that sort of thing."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance trident of Prop
	(properties
		x 143
		y 113
		z 17
		view 141
		priority 15
		signal 16400
	)
)

(instance eyeFeature of Feature
	(properties
		x 163
		y 113
		z 28
		sightAngle 0
		lookStr 60
	)

	(method (onMe param1)
		(return
			(or
				(and (InRect 112 81 132 89 param1) (= local19 1))
				(and (InRect 145 81 165 89 param1) (= local19 2))
				(and (InRect 177 80 197 88 param1) (= local19 3))
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: depressEye)
			)
			(4 ; Inventory
				(if (== invItem 12) ; trident
					(gCurRoom setScript: useTrident)
				else
					(Narrator posn: -1 5 talkWidth: 224 init: 23) ; "That object does not seem to work on the three eyes."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance eye of View
	(properties
		view 141
		loop 1
		priority 15
		signal 16400
	)
)

(instance depressEye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(+= [local126 (- local19 1)] 1)
				(eye
					cel: local19
					init:
					x: [local120 (= local19 (* (- local19 1) 2))]
					y: [local120 (+ local19 1)]
				)
				(gGame
					setCursor: ((gTheIconBar at: 2) cursor:) 1 (eye x:) (eye y:)
				)
				(= cycles 10)
			)
			(1
				(Narrator posn: -1 5 talkWidth: 224 init: 2 self) ; "Adam pushes one of the eyes. The eye retracts into the wall but nothing happens."
			)
			(2
				(= local19 0)
				(eye dispose:)
				(= cycles 2)
			)
			(3
				(if
					(and
						(> [local126 0] 0)
						(> [local126 1] 0)
						(> [local126 2] 0)
					)
					(Narrator posn: -1 5 talkWidth: 224 init: 3 self) ; "Too bad Adam can't press all three eyes at once."
				else
					(= ticks 10)
				)
			)
			(4
				(HandsOn)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance fourColumns of Feature ; UNUSED
	(properties
		onMeCheck 16
		lookStr 62
	)
)

(instance pots of Feature
	(properties
		onMeCheck 512
		lookStr 34
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 35) ; "Adam doesn't need the urns. Besides, they belong in the Temple."
			)
			(10 ; Recycle
				(Narrator init: 44) ; "The Grecian urns don't need to be thrown away!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stairsF of Feature
	(properties
		onMeCheck 4096
		lookStr 39
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 40) ; "There's nothing of interest on the steps."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skyF of Feature
	(properties
		onMeCheck 16384
		lookStr 38
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 25) ; "Adam can exit the Temple the way he came in."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance floorF of Feature
	(properties
		onMeCheck 128
		lookStr 36
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 37) ; "The marble slabs on the floor are way too heavy for Adam to lift!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bubble of View
	(properties)
)

(instance tridentDesign of Feature
	(properties
		y 119
		nsTop 98
		nsLeft 112
		nsBottom 119
		nsRight 193
		lookStr 53
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator posn: -1 5 talkWidth: 224 init: 53) ; "The strange, three-pronged symbol seems to point to the three eyes."
			)
			(else
				(bottomEyeInset doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Oracle of Talker
	(properties
		nsTop 16
		nsLeft 30
		view 142
		viewInPrint 1
		charNum 1
		keepWindow 1
	)

	(method (init)
		(super init: oracleBust oracleEye oracleMouth &rest)
	)
)

(instance oracleBust of Prop
	(properties
		view 142
	)
)

(instance oracleEye of Prop
	(properties
		nsTop 12
		nsLeft 30
		view 142
		loop 2
		cycleSpeed 30
	)
)

(instance oracleMouth of Prop
	(properties
		nsTop 13
		nsLeft 35
		view 142
		loop 1
		cycleSpeed 10
	)
)

(instance restoreCode of Code
	(properties)

	(method (doit param1 param2)
		(return
			(and
				(or (param1 isKindOf: TilePiece) (param1 isKindOf: BlankSpot))
				(== param2 (param1 correctPosn:))
			)
		)
	)
)

