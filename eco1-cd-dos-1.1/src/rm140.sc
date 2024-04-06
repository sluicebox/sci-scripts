;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use n804)
(use eRS)
(use n819)
(use EcoFeature)
(use EcoDialog)
(use Talker)
(use Polygon)
(use ForwardCounter)
(use LoadMany)
(use DPath)
(use Rev)
(use Motion)
(use Inventory)
(use User)
(use System)

(public
	rm140 0
	eyeFeature 1
	tridentDesign 2
	background 3
	dr 4
	oracleAppears 5
	HelpMePlease 6
	finishCitizens 8
	Oracle 9
	bottomEyeInset 10
	TalkWithOracle 11
	breakage 12
	oracle 13
	t1 14
	blankSpot 15
	closeOracle 16
	proc140_17 17
	proc140_18 18
	proc140_19 19
	fireAskRiddles 21
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
	[local129 4] = [35 -22 52 -9]
	[local133 4] = [37 -9 60 48]
	[local137 4] = [21 -5 41 4]
	[local141 4] = [65 -23 88 -9]
	[local145 4] = [87 -23 108 3]
	[local149 4] = [64 -1 76 9]
	[local153 4] = [26 20 39 28]
	[local157 4] = [-15 -19 14 0]
	[local161 4] = [-1 25 13 34]
	[local165 4] = [-16 32 11 44]
	[local169 4] = [11 41 28 48]
)

(procedure (proc140_17 param1 param2 &tmp temp0 temp1 temp2)
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
	)
)

(procedure (localproc_0 &tmp temp0)
	(if (not (& (t1 signal:) $0008))
		(HandsOff)
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			([local1 temp0] hide:)
		)
		(if (IsFlag 9)
			(mixedPic dispose:)
		)
		(mosaicPuzzle dispose:)
		(if (gCast contains: gDelph)
			(gDelph hide:)
		)
		(gEgo hide:)
		(eco doit:)
		(localproc_4 0)
		(if (== ((Inv at: 9) owner:) 140) ; conchShell
			(shell init:)
		)
		(gEgo show:)
		(if (gCast contains: gDelph)
			(gDelph show:)
		)
		(Animate (gCast elements:) 0)
		(if (gEgo z:)
			(gEgo y: (+ (gEgo y:) 80) z: 0)
		)
		(HandsOn)
	)
)

(procedure (proc140_18 &tmp temp0)
	(if (not (& (t1 signal:) $0008))
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			([local1 temp0] hide:)
		)
		(Animate (gCast elements:) 0)
	)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 12) ((++ temp0))
		(= [global184 temp0] ([local1 temp0] correctPosn:))
	)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 12) ((++ temp0))
		(= [local1 temp0]
			(gCast firstTrue: #perform restoreCode [global184 temp0])
		)
		([local1 temp0] node: (+ temp0 1))
	)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
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

(procedure (localproc_4 param1)
	(if (or param1 local15)
		(if (or (!= (gCurRoom curPic:) 141) local15)
			(= local15 0)
			(gCurRoom drawPic: 141 6)
			(if (not (IsFlag 9))
				(mixedPic addToPic:)
			)
		)
	else
		(gCurRoom drawPic: 140 7)
		(if (not (IsFlag 9))
			(mixedPic addToPic:)
		)
	)
)

(procedure (localproc_5)
	(if (not local18)
		(localproc_4 1)
		(ShellInset init:)
		(shell posn: 153 91 0 cel: 2 priority: 15 forceUpd:)
		(HandsOn)
		(gTheIconBar disable: 0)
	)
)

(procedure (localproc_6)
	(HandsOff)
	(gEgo hide:)
	(Animate (gCast elements:) 0)
	(localproc_4 0)
	(ShellInset dispose:)
	(shell posn: 155 105 -30 cel: 0 priority: 12 forceUpd:)
	(gEgo show:)
	(UnLoad 128 147)
	(HandsOn)
)

(procedure (localproc_7)
	(if (or (not (IsFlag 7)) (IsFlag 73))
		(if (== ((Inv at: 9) owner:) 140) ; conchShell
			(gCast delete: shell)
		)
		(if (gCast contains: gDelph)
			(gDelph hide:)
		)
		(localproc_4 1)
		(if (not (IsFlag 9))
			(mixedPic addToPic:)
		)
		(topEyeInset addToPic:)
		(bottomEyeInset addToPic:)
		(dr view: 146 loop: 1 cel: 0 x: 156 y: 112 init:)
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
			(= local13 0)
			(bottomEyeInset doVerb: 29)
		)
	else
		(EcoNarrator init: 4 0 0 16) ; "The Oracle has given her prophecy. There is no further reason to interrupt her dreaming."
	)
)

(procedure (localproc_8)
	(if (gFeatures contains: eyeFeature)
		(tridentDesign dispose:)
		(eyeFeature dispose:)
	)
	(bottomEyeInset dispose:)
	(topEyeInset dispose:)
	(background dispose:)
	(if (gCast contains: gDelph)
		(gDelph show: setPri: 5 signal: 28691)
	)
	(if (gCast contains: breakage)
		(breakage addToPic:)
	else
		(dr addToPic:)
	)
)

(procedure (localproc_9 param1 &tmp temp0)
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

(procedure (localproc_10 param1 param2 param3 param4 param5 param6 param7 &tmp [temp0 20])
	(Graph grDRAW_LINE param2 param1 param2 param3 global207 -1 -1)
	(Graph grDRAW_LINE param2 param3 param4 param3 global207 -1 -1)
	(Graph grDRAW_LINE param4 param1 param4 param3 global207 -1 -1)
	(Graph grDRAW_LINE param2 param1 param4 param1 global207 -1 -1)
	(Graph grUPDATE_BOX (- param2 1) (- param1 1) (+ param4 1) (+ param3 1) 1)
	(Message msgGET 140 4 0 1 (- param7 36) @temp0)
	(Display @temp0 dsCOORD param5 param6 dsFONT 300 dsCOLOR global207)
)

(procedure (proc140_19 param1 &tmp temp0 temp1)
	(= temp0 (t1 x:))
	(= temp1 (t1 y:))
	(cond
		(
			(or
				(InRect
					(+ temp0 [local129 0])
					(+ temp1 [local129 1])
					(+ temp0 [local129 2])
					(+ temp1 [local129 3])
					param1
				)
				(InRect
					(+ temp0 [local133 0])
					(+ temp1 [local133 1])
					(+ temp0 [local133 2])
					(+ temp1 [local133 3])
					param1
				)
				(InRect
					(+ temp0 [local137 0])
					(+ temp1 [local137 1])
					(+ temp0 [local137 2])
					(+ temp1 [local137 3])
					param1
				)
			)
			(return 1)
		)
		(
			(or
				(InRect
					(+ temp0 [local141 0])
					(+ temp1 [local141 1])
					(+ temp0 [local141 2])
					(+ temp1 [local141 3])
					param1
				)
				(InRect
					(+ temp0 [local145 0])
					(+ temp1 [local145 1])
					(+ temp0 [local145 2])
					(+ temp1 [local145 3])
					param1
				)
			)
			(return 2)
		)
		(
			(or
				(InRect
					(+ temp0 [local149 0])
					(+ temp1 [local149 1])
					(+ temp0 [local149 2])
					(+ temp1 [local149 3])
					param1
				)
				(InRect
					(+ temp0 [local153 0])
					(+ temp1 [local153 1])
					(+ temp0 [local153 2])
					(+ temp1 [local153 3])
					param1
				)
			)
			(return 3)
		)
		(
			(InRect
				(+ temp0 [local157 0])
				(+ temp1 [local157 1])
				(+ temp0 [local157 2])
				(+ temp1 [local157 3])
				param1
			)
			(return 4)
		)
		(
			(or
				(InRect
					(+ temp0 [local161 0])
					(+ temp1 [local161 1])
					(+ temp0 [local161 2])
					(+ temp1 [local161 3])
					param1
				)
				(InRect
					(+ temp0 [local165 0])
					(+ temp1 [local165 1])
					(+ temp0 [local165 2])
					(+ temp1 [local165 3])
					param1
				)
				(InRect
					(+ temp0 [local169 0])
					(+ temp1 [local169 1])
					(+ temp0 [local169 2])
					(+ temp1 [local169 3])
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

(class TilePiece of EcoView
	(properties
		view 143
		priority 15
		signal 16400
		correctPosn 0
		blankTile 0
		node 0
	)

	(method (init param1)
		(= global250 4)
		(= global251 1)
		(super init: &rest)
		(= [local1 local0] self)
		(self blankTile: param1 node: (+= local0 1) hide:)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 9)
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 12) ; "The mosaic tile picture is already unscrambled."
					)
					((and blankTile (self check:))
						(self move:)
					)
					(blankTile
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 11) ; "Choose a tile next to the empty space."
					)
					(else
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 10) ; "Choose the tile you want to move into the empty space."
					)
				)
			)
			(1 ; Look
				(if (IsFlag 9)
					(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 9) ; "The mosaic tile picture on the wall is now unscrambled. Strange symbols appear in the tile's design."
				else
					(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 8) ; "On the wall is a mosaic tile picture. It looks like the seawater has caused the cement around the tiles to weaken and now the picture is scrambled."
				)
			)
			(44 ; Inventory
				(cond
					((== temp0 18)
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 57) ; "The bronze conch must have some purpose related to the Temple, but it doesn't work with the mosaic tile puzzle."
					)
					((IsFlag 9)
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 12) ; "The mosaic tile picture is already unscrambled."
					)
					(else
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 49) ; "That won't help Adam unscramble the mosaic tile picture."
					)
				)
			)
			(6 ; Recycle
				(if (IsFlag 9)
					(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 48) ; "Adam doesn't want to throw away the beautiful mosaic."
				else
					(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 47) ; "The mosaic picture is scrambled, but it needs to be fixed, not thrown away."
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
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
			(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 27 self) ; "That's it! The mysterious mosaic is now fully revealed!"
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
		(localproc_0)
		(if (IsFlag 30)
			(= local13 1)
			(localproc_7)
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
		picture 140
		style 10
		horizon 15
		south 120
		lookStr 17
	)

	(method (init)
		(LoadMany rsVIEW 140 142)
		(plant1 setCycle: Fwd init:)
		(if (and (not (gEgo has: 9)) (!= ((Inv at: 9) owner:) 120)) ; conchShell, conchShell
			(shell init: stopUpd:)
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
		(UnLoad 129 120)
		(if (not (IsFlag 9))
			(mixedPic addToPic:)
		)
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
			(localproc_2)
		)
		(blankSpot calibrate:)
		(self setRegions: 51) ; bubblesRegion
		(if (gEgo has: 2) ; goldMask
			(self setScript: enterWithMask)
		else
			(self setScript: enterScript)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (gCast contains: oracle)
					(EcoNarrator init: 4 0 0 26) ; "A secret panel in the Temple wall has opened to reveal the Oracle. Cassandra the Oracle is a John Dory fish. Like all John Dory fish, she has a mysterious third eye on her side. Perhaps it is this third eye that allows the Oracle to see into the future."
				else
					(EcoNarrator init: 4 0 0 17) ; "Adam is swimming inside the Temple of Poseidon. The glowing marble and mysterious symbols have a strange and wonderful power."
				)
			)
			(44 ; Inventory
				(switch temp0
					(else
						(super doVerb: theVerb temp0 &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((and (gEgo has: 2) (== ((User alterEgo:) edgeHit:) EDGE_BOTTOM)) ; goldMask
				(gCurRoom setScript: getProphesy)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(self setScript: NoExit)
			)
		)
		(if (and (GameIsRestarting) (== local18 1) (not (IsFlag 9)))
			(localproc_10 82 154 140 167 98 156 61)
		)
		(super doit:)
		(if (and (!= (gLongSong number:) 140) (== (gLongSong prevSignal:) -1))
			(gLongSong number: 140 loop: -1 play:)
		)
	)

	(method (newRoom newRoomNumber)
		(localproc_1)
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
				((ScriptID 2 0) init: 3 0 0 3 1 self) ; Delphineus, "We need to see the Oracle, Adam. You found her once - can you get her to appear again?"
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
				(EcoNarrator init: 4 0 0 25 self) ; "Adam can exit the Temple the way he came in."
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
				((ScriptID 2 1) init: 1 0 0 1 1 self) ; Adam, "My name is Adam. I came here with Delphineus to help save the kingdom. What can I do to help?"
			)
			(2
				(Oracle init: 2 0 0 2 0 self) ; "A prophecy from ancient year, Spoke of days of death and fear. A human boy, kind and brave,  Would the Kingdom of Eluria save.  Three riddles will your soul reveal,  Use your heart, the truth to feel."
			)
			(3
				(if (IsFlag 9)
					(if gFastCast
						(Oracle dispose:)
					)
					(gCurRoom setScript: (ScriptID 142 0)) ; askRiddles
				else
					(SetFlag 30)
					(Oracle init: 2 0 0 3 1 self) ; "The riddle symbols must be whole, To solve the mosaic is your goal."
				)
			)
			(4
				(if (IsFlag 30)
					(self setScript: closeOracle self)
				else
					(= state 5)
					(= cycles 1)
				)
			)
			(5
				(= local15 1)
				(MosaicWall doVerb: 4)
				(= cycles 1)
			)
			(6
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
				(dr show: setMotion: MoveTo 156 112 self)
			)
			(2
				(dr cel: 0)
				(gSoundEffects number: 165 loop: 1 flags: 0 play: self)
			)
			(3
				(gEgo hide:)
				(localproc_8)
				(gFeatures delete: dr topEyeInset bottomEyeInset)
				(= cycles 1)
			)
			(4
				(if (gAddToPics contains: breakage)
					(dr dispose:)
					(breakage dispose:)
					(breakage signal: 17)
				else
					(dr dispose:)
				)
				(= cycles 2)
			)
			(5
				(if register
					(= register 0)
					(localproc_4 0)
				)
				(if (== ((Inv at: 9) owner:) 140) ; conchShell
					(shell init:)
				)
				(gEgo show:)
				(= cycles 2)
			)
			(6
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
				(= cycles 2)
			)
			(1
				(Oracle init: 2 0 0 17 1 self) ; "The citizens must give their trust, To you alone - win them you must. This 'Sign of Trust' bring back to me, And you shall have the prophecy."
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 0)
				(= seconds 10)
			)
			(3
				(self setScript: closeOracle self 1)
			)
			(4
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
				(Oracle init: 2 0 0 18 1 self) ; "That is not the sign I seek, The citizens have yet to speak."
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
				(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 29 self) ; "Adam hands the gold mask to the Oracle, holding his breath with anticipation."
				(gEgo put: 2 140) ; goldMask
			)
			(1
				(Oracle init: 2 0 0 19 1 self) ; "A 'Sign of Trust' is given to me. A mask of gold for all to see. Poseidon's favor has been won, By the child 'Adam' - the chosen one."
			)
			(2
				(EcoNarrator init: 2 0 0 20 self 140) ; "Here now is the prophecy:  In the place where shadows creep, Rests the poison of the deep. What came from man must now return, Lest the Kingdom die, the oceans burn. Held hostage is the King of Peace, None shall be safe 'til he's released. Only Love can face The One Most Vile. To save us all - a human child."
			)
			(3
				((ScriptID 2 1) init: 1 0 0 7 1 self) ; Adam, "But HOW can I save the Kingdom?"
			)
			(4
				(Oracle init: 2 0 0 21 0 self) ; "Only fragments can I see, But let me tell them now to thee:  Armor for a modern knight,  From the depths, a glowing light.  A net of bones, a wall of stones,  A floating orb, a silver wire,  Will help you in a place most dire."
			)
			(5
				(Oracle init: 2 0 0 22 1 self) ; "Here on parchment are the clues, May Poseidon watch o'er you."
			)
			(6
				(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 5 self) ; "Adam takes a parchment scroll containing the prophecy from the Oracle."
				(OracleWall approachVerbs: 26505) ; ???
				(carvings approachVerbs: 26505) ; ???
				(SetFlag 7)
				(gEgo get: 25) ; scroll
			)
			(7
				(self setScript: closeOracle self 1)
			)
			(8
				(= cycles 4)
			)
			(9
				((ScriptID 2 0) init: 3 0 0 1 1 self) ; Delphineus, "Wow! A prophecy! And to think I didn't know if I should bring you, Adam! Let's get started on our quest outside the city!"
			)
			(10
				(gDelph setMotion: MoveTo 79 130 self)
			)
			(11
				(gDelph setMotion: MoveTo 79 260 self)
			)
			(12
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
				(oracle view: 142 loop: 4 cel: 0 posn: 131 79 setCycle: Fwd)
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
				(oracle view: 149 loop: 1 cel: 7 posn: 163 98 setCycle: Rev)
				(background view: 151 loop: 1 cel: 7 setCycle: Rev)
			)
			(1
				(gLongSong fade:)
				(gSoundEffects number: 146 loop: 1 play:)
				(oracle setLoop: 0 cel: 14 posn: 163 98 setCycle: Beg oracle)
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
				((ScriptID 2 0) init: 3 0 0 2 1 self) ; Delphineus, "We need to get the prophecy from the Oracle, Adam, or we'll never know WHAT to do!"
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
				(= cycles 2)
			)
			(1
				(Oracle init: 2 0 0 24 1 self) ; "Look beyond the lost ship's door To find the one you're looking for."
			)
			(2
				(gCurRoom setScript: closeOracle 0 1)
			)
		)
	)
)

(instance plant1 of EcoProp
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

(instance ShellInset of EcoView
	(properties
		x 154
		y 110
		view 147
		priority 14
		signal 16
		lookStr 7
	)

	(method (init)
		(if (not z)
			(proc804_8 self)
		)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(localproc_9 2)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(localproc_9 0)
		(super dispose: &rest)
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
				(not (& (event type:) $000a)) ; evKEYUP | evMOUSERELEASE
			)
			(event claimed: 1)
			(localproc_6)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (== ((Inv at: 9) owner:) 140) ; conchShell
					(EcoNarrator store: 31)
				)
				(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 7) ; "On the front of the marble pedestal is a bas-relief of a man kneeling and blowing into a conch shell."
			)
			(44 ; Inventory
				(switch temp0
					(18
						(shell posn: 153 91 0 cel: 2 init: setPri: 15 stopUpd:)
						(gEgo put: 9 140) ; conchShell
						(Animate (gCast elements:) 0)
						(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 56) ; "Adam puts the conch shell back on the pedestal."
					)
					(else
						(super doVerb: theVerb temp0 &rest)
					)
				)
			)
			(4 ; Do
				(EcoNarrator init: 4 0 0 33) ; "The pedestal is too heavy to take. Besides, it's also connected to the Temple floor."
			)
			(6 ; Recycle
				(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 46) ; "The pedestal is too large and heavy to throw away. Besides, it belongs in the Temple."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance shell of EcoView
	(properties
		x 155
		y 105
		z -30
		view 140
		loop 2
		priority 12
		signal 16401
	)

	(method (dispose)
		(super dispose:)
		(if (== gCurRoomNum gNewRoomNum)
			(localproc_6)
		)
	)

	(method (doVerb theVerb)
		(if (or (not local18) (== local18 2))
			(switch theVerb
				(1 ; Look
					(if (not cel)
						(localproc_5)
						(Animate (gCast elements:) 0)
						(EcoNarrator
							store: 31
							posn: 45 142
							talkWidth: 224
							init: 4 0 0 32 ; "A pedestal stands in the middle of the Temple."
						)
					else
						(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 6) ; "A large, beautiful conch shell rests on top of the pedestal. It looks like it's made of solid bronze."
					)
				)
				(4 ; Do
					(if (not cel)
						(localproc_5)
					else
						(gCurRoom setScript: getConchShell)
					)
				)
				(6 ; Recycle
					(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 45) ; "The bronze conch shell is much too beautiful to just throw away!"
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
				(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 1 self) ; "Adam takes the bronze conch shell."
				(SetScore 2 256)
				(gEgo get: 9) ; conchShell
			)
			(1
				(shell dispose:)
				(self dispose:)
			)
		)
	)
)

(instance fireAskRiddles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCurRoom script:)
					(-- state)
				)
				(= cycles 1)
			)
			(1
				(gCurRoom setScript: (ScriptID 142 0) self) ; askRiddles
			)
			(2
				(= cycles 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance lalala of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance columnPed of EcoFeature
	(properties
		onMeCheck 256
		lookStr 7
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(localproc_5)
				(Animate (gCast elements:) 0)
				(if (== ((Inv at: 9) owner:) 140) ; conchShell
					(EcoNarrator store: 31)
				)
				(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 32) ; "A pedestal stands in the middle of the Temple."
			)
			(44 ; Inventory
				(if (== temp0 18)
					(shell posn: 155 105 -30 cel: 0 init: setPri: 12 stopUpd:)
					(gEgo put: 9 140) ; conchShell
					(Animate (gCast elements:) 0)
					(EcoNarrator init: 4 0 0 56) ; "Adam puts the conch shell back on the pedestal."
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(4 ; Do
				(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 33) ; "The pedestal is too heavy to take. Besides, it's also connected to the Temple floor."
			)
			(6 ; Recycle
				(EcoNarrator posn: 45 142 talkWidth: 224 init: 4 0 0 46) ; "The pedestal is too large and heavy to throw away. Besides, it belongs in the Temple."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance mixedPic of EcoView
	(properties
		x 62
		y 102
		onMeCheck 0
		view 156
		signal 16401
	)
)

(instance MosaicWall of EcoFeature
	(properties
		x 69
		y 97
		onMeCheck 2
		approachX 105
		approachY 105
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 4) ; Look, Do
	)

	(method (doVerb theVerb &tmp temp0)
		(if (or (not local18) (== local18 1))
			(cond
				((OneOf theVerb 1 4) ; Look, Do
					(if (== ((Inv at: 9) owner:) 140) ; conchShell
						(gCast delete: shell)
					)
					(localproc_4 1)
					(mosaicPuzzle addToPic:)
					(proc140_17 106 80)
					(gEgo y: (- (gEgo y:) 80) z: -80)
					(Animate (gCast elements:) 0)
					(if (not (IsFlag 9))
						(localproc_10 82 154 140 167 98 156 61)
					)
					(HandsOn)
					(gTheIconBar disable: 0 3 4 6 5)
					(t1 doVerb: 1)
				)
				((== theVerb 6) ; Recycle
					(if (IsFlag 9)
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 48) ; "Adam doesn't want to throw away the beautiful mosaic."
					else
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 47) ; "The mosaic picture is scrambled, but it needs to be fixed, not thrown away."
					)
				)
				((== theVerb 44) ; Inventory
					(if (IsFlag 9)
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 12) ; "The mosaic tile picture is already unscrambled."
					else
						(EcoNarrator posn: -1 10 talkWidth: -1 init: 4 0 0 49) ; "That won't help Adam unscramble the mosaic tile picture."
					)
				)
				(else
					(super doVerb: theVerb temp0 &rest) ; UNINIT
				)
			)
		)
	)
)

(instance mosaicPuzzle of EcoView
	(properties
		x 144
		y 28
		view 148
		priority 14
		signal 17
	)

	(method (init)
		(super init:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gTheIconBar curIcon: (gTheIconBar at: 2))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(localproc_9 1)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(localproc_9 0)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp temp0)
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
					(not (& (event type:) $000a)) ; evKEYUP | evMOUSERELEASE
					(not (event modifiers:))
				)
				(if (and (not (IsFlag 9)) (InRect 82 154 140 167 event))
					(if (and (not (localproc_3)) (not (IsFlag 9)))
						(Animate (gCast elements:) 0)
						(EcoNarrator
							posn: -1 10
							talkWidth: -1
							init: 4 0 0 27 t1 ; "That's it! The mysterious mosaic is now fully revealed!"
						)
					)
				else
					(localproc_0)
				)
				(event claimed: 1)
			)
			(
				(and
					(IsFlag 9)
					(== (gTheIconBar curIcon:) (gTheIconBar at: 1))
					(not (& (event type:) $000a)) ; evKEYUP | evMOUSERELEASE
					(= temp0 (proc140_19 event))
				)
				(switch temp0
					(1
						(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 18) ; "There's a symbol of a man in the mosaic picture."
					)
					(2
						(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 19) ; "There's a symbol of a fish in the mosaic picture."
					)
					(3
						(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 21) ; "There's a symbol of a heart in the mosaic picture."
					)
					(4
						(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 22) ; "There's a symbol of a frond in the mosaic picture."
					)
					(5
						(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 20) ; "There's a symbol of a dog in the mosaic picture."
					)
				)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(t1 doVerb: 1)
			)
			(44 ; Inventory
				(if (== temp0 18)
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 57) ; "The bronze conch must have some purpose related to the Temple, but it doesn't work with the mosaic tile puzzle."
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
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

(instance carvings of EcoFeature
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
			(self approachVerbs: 9) ; ???
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(44 ; Inventory
				(switch temp0
					(29
						(EcoNarrator init: 4 0 0 51) ; "Adam doesn't see a place to use the trident on that section of the wall."
					)
					(18
						(EcoNarrator init: 4 0 0 58) ; "The bronze conch must have some purpose related to the Temple, but it doesn't work on the carvings."
					)
					(else
						(EcoNarrator init: 4 0 0 24) ; "That object does not seem to work on the carvings."
					)
				)
			)
			(4 ; Do
				(EcoNarrator init: 4 0 0 14) ; "Adam examines some of the carvings, but doesn't see anything to do on that part of the wall."
			)
			(6 ; Recycle
				(EcoNarrator init: 4 0 0 50) ; "The mysterious carvings strain Adam's brain and he thinks about throwing them away, but he couldn't get them off the wall even if he wanted to."
			)
			(2 ; Talk
				(EcoNarrator init: 4 0 0 54) ; "The Temple wall does not respond."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance OracleWall of EcoFeature
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
			(self approachVerbs: 9 4 1) ; ???, Do, Look
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(44 ; Inventory
				(switch temp0
					(29
						(= local13 1)
						(localproc_7)
					)
					(else
						(EcoNarrator init: 4 0 0 23) ; "That object does not seem to work on the three eyes."
					)
				)
			)
			(1 ; Look
				(localproc_7)
				(Animate (gCast elements:) 0)
				(if (or (not (IsFlag 7)) (IsFlag 73))
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 28) ; "An odd carving of three large eyes dominates the center of the back wall of the Temple."
				else
					(EcoNarrator posn: -1 5 talkWidth: -1 store: 28)
				)
			)
			(4 ; Do
				(= local14 1)
				(localproc_7)
			)
			(2 ; Talk
				(EcoNarrator init: 4 0 0 54) ; "The Temple wall does not respond."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance topEyeInset of EcoView
	(properties
		x 143
		y 67
		view 146
		priority 14
		signal 16401
	)

	(method (doVerb)
		(bottomEyeInset doVerb: &rest)
	)
)

(instance bottomEyeInset of EcoView
	(properties
		x 151
		y 66
		z -87
		view 146
		cel 1
		priority 13
		signal 16401
	)

	(method (init)
		(super init:)
		(localproc_9 3)
		(if (gCast contains: gDelph)
			(gDelph
				talkScript: 0
				stopUpd:
				y: (- (gDelph y:) 1000)
				z: (- (gDelph z:) 1000)
				onMeCheck: 0
			)
		)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(if (not (IsFlag 255))
			(breakage init:)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(if (gCast contains: gDelph)
			(gDelph
				y: (+ (gDelph y:) 1000)
				z: (+ (gDelph z:) 1000)
				onMeCheck: 26505
			)
		)
		(localproc_9 0)
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
				(not (& (event type:) $000a)) ; evKEYUP | evMOUSERELEASE
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

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (gCast contains: oracle)
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 26) ; "A secret panel in the Temple wall has opened to reveal the Oracle. Cassandra the Oracle is a John Dory fish. Like all John Dory fish, she has a mysterious third eye on her side. Perhaps it is this third eye that allows the Oracle to see into the future."
				else
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 28) ; "An odd carving of three large eyes dominates the center of the back wall of the Temple."
				)
			)
			(44 ; Inventory
				(switch temp0
					(29
						(cond
							((and (IsFlag 7) (not (IsFlag 73)))
								(EcoNarrator
									posn: -1 5
									talkWidth: -1
									init: 4 0 0 16 ; "The Oracle has given her prophecy. There is no further reason to interrupt her dreaming."
								)
							)
							((not (gCast contains: oracle))
								(gCurRoom setScript: (ScriptID 141 0)) ; useTrident
							)
							(else
								(EcoNarrator init: 4 0 0 59) ; "The Oracle panel is already open. Adam doesn't need to use the trident now."
							)
						)
					)
					(18
						(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 58) ; "The bronze conch must have some purpose related to the Temple, but it doesn't work on the carvings."
					)
					(else
						(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 23) ; "That object does not seem to work on the three eyes."
					)
				)
			)
			(6 ; Recycle
				(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 50) ; "The mysterious carvings strain Adam's brain and he thinks about throwing them away, but he couldn't get them off the wall even if he wanted to."
			)
			(2 ; Talk
				(if (not (gCast contains: oracle))
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 54) ; "The Temple wall does not respond."
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(4 ; Do
				(if (gCast contains: oracle)
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 55) ; "Adam cannot enter the Oracle's secret chamber."
				else
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 28) ; "An odd carving of three large eyes dominates the center of the back wall of the Temple."
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance dr of EcoActor
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

(instance breakage of EcoProp
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
		((ScriptID 140 10) doVerb: &rest) ; bottomEyeInset
	)
)

(instance background of EcoProp
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
		(if (== theVerb 1) ; Look
			(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 26) ; "A secret panel in the Temple wall has opened to reveal the Oracle. Cassandra the Oracle is a John Dory fish. Like all John Dory fish, she has a mysterious third eye on her side. Perhaps it is this third eye that allows the Oracle to see into the future."
		else
			(bottomEyeInset doVerb: theVerb &rest)
		)
	)
)

(instance rippleBg of EcoProp
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

(instance oracle of EcoProp
	(properties
		x 163
		y 98
		z 7
		view 143
		priority 11
		signal 20496
		lookStr 26
	)

	(method (cue)
		(if local16
			(= local16 0)
			(self dispose:)
		else
			(self loop: 1 cel: 0 setCycle: Fwd)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 15) ; "The Oracle's scales are too delicate for a human's rough touch."
			)
			(2 ; Talk
				(gCurRoom setScript: TalkWithOracle)
			)
			(44 ; Inventory
				(if (IsFlag 4)
					(switch temp0
						(11
							(gCurRoom setScript: giveMask)
						)
						(else
							(gCurRoom setScript: showAnyObject)
						)
					)
				else
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 41) ; "The Oracle Cassandra is not interested in any material posessions Adam has at this time. She is beyond that sort of thing."
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance eyeFeature of EcoFeature
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

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: depressEye)
			)
			(44 ; Inventory
				(if (== temp0 29)
					(gCurRoom setScript: (ScriptID 141 0)) ; useTrident
				else
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 23) ; "That object does not seem to work on the three eyes."
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance eye of EcoView
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
				(gGame setCursor: ((gTheIconBar at: 2) cursor:))
				(SetCursor (eye x:) (eye y:))
				(= cycles 10)
			)
			(1
				(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 2 self) ; "Adam pushes one of the eyes. The eye retracts into the wall but nothing happens."
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
					(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 3 self) ; "Too bad Adam can't press all three eyes at once."
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

(instance fourColumns of EcoFeature ; UNUSED
	(properties
		onMeCheck 16
		lookStr 62
	)
)

(instance pots of EcoFeature
	(properties
		onMeCheck 512
		lookStr 34
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 4 0 0 35) ; "Adam doesn't need the urns. Besides, they belong in the Temple."
			)
			(6 ; Recycle
				(EcoNarrator init: 4 0 0 44) ; "The Grecian urns don't need to be thrown away!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stairsF of EcoFeature
	(properties
		onMeCheck 4096
		lookStr 39
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 4 0 0 40) ; "There's nothing of interest on the steps."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skyF of EcoFeature
	(properties
		onMeCheck 16384
		lookStr 38
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 4 0 0 25) ; "Adam can exit the Temple the way he came in."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance floorF of EcoFeature
	(properties
		onMeCheck 128
		lookStr 36
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 4 0 0 37) ; "The marble slabs on the floor are way too heavy for Adam to lift!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tridentDesign of EcoFeature
	(properties
		y 119
		nsTop 98
		nsLeft 112
		nsBottom 119
		nsRight 193
		lookStr 53
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator posn: -1 5 talkWidth: -1 init: 4 0 0 53) ; "The strange, three-pronged symbol seems to point to the three eyes."
			)
			(else
				(bottomEyeInset doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Oracle of EcoTalker
	(properties
		nsTop 76
		nsLeft 135
		view 142
		charNum 1
		keepWindow 1
	)

	(method (init)
		(oracle setPri: 0)
		(super init: oracleBust oracleEye oracleMouth &rest)
	)

	(method (display)
		(proc821_1 &rest 64 -1 10 111 77 name)
	)

	(method (dispose)
		(super dispose: &rest)
		(oracle setPri: 11 setCycle: Fwd)
	)
)

(instance oracleBust of EcoProp
	(properties
		view 142
		priority 14
		signal 16401
	)
)

(instance oracleEye of EcoProp
	(properties
		nsTop 12
		nsLeft 30
		view 142
		loop 2
		cycleSpeed 30
	)
)

(instance oracleMouth of EcoProp
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

