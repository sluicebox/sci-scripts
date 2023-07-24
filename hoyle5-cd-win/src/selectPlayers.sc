;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use KeyMouse)
(use TrackingView)
(use RulesPrint)
(use Str)
(use Array)
(use Print)
(use Game)
(use System)

(public
	selectPlayers 0
)

(local
	local0
	[local1 11]
	[local12 11]
	[local23 11]
	[local34 6]
	local40
	local41
	local42
	local43
	local44
	local45
	local46
	local47
	local48
	local49
	local50
	local51
	local52
	[local53 14] = [2 1 2 1 2 2 1 0 0 0 0 1 1 1]
	[local67 14] = [1 1 1 0 0 1 2 0 0 0 0 2 1 0]
	[local81 14] = [1 2 2 0 1 1 1 0 0 0 0 1 2 0]
	[local95 14] = [1 2 2 1 1 1 2 0 0 0 0 1 1 0]
	[local109 14] = [1 1 2 1 2 2 2 0 0 0 0 1 1 0]
	[local123 14] = [0 2 2 1 2 2 1 0 0 0 0 1 1 0]
	[local137 14] = [513 771 259 770 257 514 514 0 0 514 0 515 258 769]
	[local151 14] = [1 2 2 1 1 2 2 0 0 0 0 1 1 0]
	[local165 32] = [2 2 1 1 0 2 1 0 0 0 0 1 2 1 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17]
)

(procedure (localproc_0)
	(frameGuy1 show:)
	(frameGuy2 show:)
	(frameGuy3 show:)
	(frameGuy4 show:)
	(frameGuy5 show:)
	(frameGuy6 show:)
	(frameGuy7 show:)
	(frameGuy8 show:)
	(frameGuy9 show:)
	(frameGuy10 show:)
	(frameGuy11 show:)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3) ; UNUSED
	(= temp1 (if (== (= local0 (if (== local0 0) 1 else 0)) 0) 0 else 1))
	(= temp0 (if (== local0 0) 908 else 909))
	(if (== local0 0)
		(for ((= temp2 0)) (<= temp2 10) ((++ temp2))
			(= [local23 temp2] [local1 temp2])
		)
	else
		(for ((= temp2 0)) (<= temp2 10) ((++ temp2))
			(= [local23 temp2] [local12 temp2])
		)
	)
	(if [local23 0]
		(proc0_10 temp0 0 0 (frameGuy1 x:) (frameGuy1 y:) 8)
	)
	(if [local23 1]
		(proc0_10 temp0 0 1 (frameGuy2 x:) (frameGuy2 y:) 8)
	else
		(proc0_10 906 temp1 1 (frameGuy2 x:) (frameGuy2 y:) 8)
	)
	(if [local23 2]
		(proc0_10 temp0 0 2 (frameGuy3 x:) (frameGuy3 y:) 8)
	else
		(proc0_10 906 temp1 2 (frameGuy3 x:) (frameGuy3 y:) 8)
	)
	(if [local23 3]
		(proc0_10 temp0 0 3 (frameGuy4 x:) (frameGuy4 y:) 8)
	else
		(proc0_10 906 temp1 3 (frameGuy4 x:) (frameGuy4 y:) 8)
	)
	(if [local23 4]
		(proc0_10 temp0 0 4 (frameGuy5 x:) (frameGuy5 y:) 8)
	else
		(proc0_10 906 temp1 4 (frameGuy5 x:) (frameGuy5 y:) 8)
	)
	(if [local23 5]
		(proc0_10 temp0 0 5 (frameGuy6 x:) (frameGuy6 y:) 8)
	else
		(proc0_10 906 temp1 5 (frameGuy6 x:) (frameGuy6 y:) 8)
	)
	(if [local23 6]
		(proc0_10 temp0 0 6 (frameGuy7 x:) (frameGuy7 y:) 8)
	else
		(proc0_10 906 temp1 6 (frameGuy7 x:) (frameGuy7 y:) 8)
	)
	(if [local23 7]
		(proc0_10 temp0 0 7 (frameGuy8 x:) (frameGuy8 y:) 8)
	else
		(proc0_10 906 temp1 7 (frameGuy8 x:) (frameGuy8 y:) 8)
	)
	(if [local23 8]
		(proc0_10 temp0 0 8 (frameGuy9 x:) (frameGuy9 y:) 8)
	else
		(proc0_10 906 temp1 8 (frameGuy9 x:) (frameGuy9 y:) 8)
	)
	(RedrawCast)
)

(procedure (localproc_2 param1 param2 &tmp temp0 [temp1 99] temp100 [temp101 99] temp200 [temp201 29] temp230 temp231 temp232 temp233 temp234 temp235 temp236 temp237 temp238 temp239 temp240 temp241 temp242 temp243 temp244)
	(= temp0 (Str new:))
	(= temp100 (Str new:))
	(= temp200 (Str new:))
	(Message msgGET 3 37 0 0 (/ gCardGameScriptNumber 100) (temp0 data:))
	(Message msgGET 3 param1 6 0 1 (temp100 data:))
	(Message msgGET 3 22 11 param2 1 (temp200 data:))
	(temp100 cat: { })
	(temp100 cat: temp200)
	(= temp233
		(if global916
			(switch param1
				(15 0)
				(24 5)
				(16 8)
				(23 9)
				(27 2)
				(25 6)
				(28 1)
				(17 7)
				(18 10)
				(26 3)
				(29 4)
			)
		else
			(switch param1
				(1 0)
				(6 5)
				(2 8)
				(5 9)
				(12 2)
				(7 6)
				(13 1)
				(3 7)
				(4 10)
				(10 3)
				(14 4)
			)
		)
	)
	(cond
		(global916
			(= temp230 909)
			(= temp235 190)
			(= temp236 10)
		)
		((== gAttitudeSetting 0)
			(= temp235 220)
			(= temp236 60)
			(= temp230 912)
		)
		(else
			(= temp235 220)
			(= temp236 60)
			(= temp230 906)
		)
	)
	(= temp231 temp233)
	(= temp232 0)
	(= temp234 (Print width:))
	(= temp237 2)
	(while (!= temp237 3)
		(switch temp237
			(1
				(= temp237
					(Print
						margin: 13
						font: gUserFont
						fore: 0
						addBitmap: 917 7 0
						addText: param1 0 0 1 0 0 21
						addButtonBM: 917 1 0 2 {SKILL} 151 209
						addButtonBM: 917 1 0 3 {OKAY} 220 209
						init:
					)
				)
			)
			(2
				(Print
					margin: 13
					font: gUserFont
					fore: 0
					addBitmap: 917 7 0
					addIcon: temp230 temp231 temp232 (- temp235 75) temp236
					addButtonBM: 917 1 0 1 {BIO} 151 209
					addButtonBM: 917 1 0 3 {OKAY} 220 209
				)
				(= temp243 (IntArray new: 4))
				(= temp244 (IntArray new: 4))
				(Text 0 (temp243 data:) (temp0 data:) gUserFont (Print width:) 0) ; TextSize
				(= temp238 (/ (- (Print width:) (temp243 at: 2)) 2))
				(= temp240
					(/
						(-
							(= temp242
								(- (CelHigh 917 7 0) (* 2 (Print margin:)))
							)
							(temp243 at: 3)
						)
						2
					)
				)
				(Text
					0 ; TextSize
					(temp244 data:)
					(temp100 data:)
					gUserFont
					(Print width:)
					0
				)
				(= temp239 (/ (- (Print width:) (temp244 at: 2)) 2))
				(= temp241 (/ (- temp242 (temp244 at: 3)) 2))
				(= temp237
					(Print
						addText: temp0 temp238 150
						addText: temp100 temp239 170
						init:
					)
				)
				(temp243 dispose:)
				(temp244 dispose:)
			)
			(else
				(break)
			)
		)
	)
	(temp0 dispose:)
	(temp100 dispose:)
	(temp200 dispose:)
)

(procedure (localproc_3 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
	(randomButn disable:)
	(randomButn hide:)
	(if [local1 param1]
		(if (== local40 gPlayerCount)
			(Print
				margin: 13
				ticks: 400
				font: gUserFont
				fore: 0
				posn: 150 150
				addBitmap: 917 0 0
			)
			(= temp2 (IntArray new: 4))
			(= temp3 (Str new:))
			(Message msgGET 3 20 8 0 1 (temp3 data:)) ; "That would be too many players."
			(Text 0 (temp2 data:) (temp3 data:) gUserFont (Print width:) 0) ; TextSize
			(= temp0 (/ (- (Print width:) (temp2 at: 2)) 2))
			(= temp1
				(/
					(-
						(= temp4 (- (CelHigh 917 0 0) (* 2 (Print margin:))))
						(temp2 at: 3)
					)
					2
				)
			)
			(Print addText: 20 8 0 1 temp0 temp1 init:) ; "That would be too many players."
			(temp3 dispose:)
			(temp2 dispose:)
		else
			(= [local1 param1] 0)
			(++ local40)
			(localproc_6 param1 param2)
			(local41 guyX: local42 guyY: local43)
		)
	else
		(Print
			margin: 13
			ticks: 400
			font: gUserFont
			fore: 0
			posn: 150 150
			addBitmap: 917 0 0
		)
		(= temp2 (IntArray new: 4))
		(= temp3 (Str new:))
		(Message msgGET 3 20 9 0 1 (temp3 data:)) ; "There is no one here."
		(Text 0 (temp2 data:) (temp3 data:) gUserFont (Print width:) 0) ; TextSize
		(= temp0 (/ (- (Print width:) (temp2 at: 2)) 2))
		(= temp1
			(/
				(-
					(= temp4 (- (CelHigh 917 0 0) (* 2 (Print margin:))))
					(temp2 at: 3)
				)
				2
			)
		)
		(Print addText: 20 9 0 1 temp0 temp1 init:) ; "There is no one here."
		(temp3 dispose:)
		(temp2 dispose:)
	)
)

(procedure (localproc_4 param1 param2 param3)
	(switch param1
		(0
			(frameGuy1 hide:)
			(frameGuy1 posn: param2 param3 loop: 0)
			(frameGuy1 show:)
		)
		(1
			(frameGuy2 hide:)
			(frameGuy2 posn: param2 param3 loop: 5)
			(frameGuy2 show:)
		)
		(2
			(frameGuy3 hide:)
			(frameGuy3 posn: param2 param3 loop: 8)
			(frameGuy3 show:)
		)
		(3
			(frameGuy4 hide:)
			(frameGuy4 posn: param2 param3 loop: 9)
			(frameGuy4 show:)
		)
		(4
			(frameGuy5 hide:)
			(frameGuy5 posn: param2 param3 loop: 2)
			(frameGuy5 show:)
		)
		(5
			(frameGuy6 hide:)
			(frameGuy6 posn: param2 param3 loop: 6)
			(frameGuy6 show:)
		)
		(6
			(frameGuy7 hide:)
			(frameGuy7 posn: param2 param3 loop: 1)
			(frameGuy7 show:)
		)
		(7
			(frameGuy8 hide:)
			(frameGuy8 posn: param2 param3 loop: 7)
			(frameGuy8 show:)
		)
		(8
			(frameGuy9 hide:)
			(frameGuy9 posn: param2 param3 loop: 10)
			(frameGuy9 show:)
		)
		(9
			(frameGuy10 hide:)
			(frameGuy10 posn: param2 param3 loop: 3)
			(frameGuy10 show:)
		)
		(10
			(frameGuy11 hide:)
			(frameGuy11 posn: param2 param3 loop: 4)
			(frameGuy11 show:)
		)
	)
)

(procedure (localproc_5 &tmp temp0)
	(= local44 -1)
	(= local45 -1)
	(= local46 -1)
	(= local47 -1)
	(= local48 -1)
	(= local49 -1)
	(= global195 -1)
	(= gSkill -1)
	(= global197 -1)
	(= global198 -1)
	(= local44
		(switch gCardGameScriptNumber
			(100 [local53 (frameChoice1 guyView:)])
			(200 [local67 (frameChoice1 guyView:)])
			(300 [local81 (frameChoice1 guyView:)])
			(400 [local95 (frameChoice1 guyView:)])
			(500 [local109 (frameChoice1 guyView:)])
			(700 [local123 (frameChoice1 guyView:)])
			(1100 [local137 (frameChoice1 guyView:)])
			(1200 [local151 (frameChoice1 guyView:)])
			(1300 [local165 (frameChoice1 guyView:)])
		)
	)
	(= local47 (frameChoice1 guyView:))
	(gChar1 setChar: 1 local47 gCardGameScriptNumber)
	(if (> gPlayerCount 1)
		(= local45
			(switch gCardGameScriptNumber
				(100 [local53 (frameChoice2 guyView:)])
				(200 [local67 (frameChoice2 guyView:)])
				(300 [local81 (frameChoice2 guyView:)])
				(400 [local95 (frameChoice2 guyView:)])
				(500 [local109 (frameChoice2 guyView:)])
				(700 [local123 (frameChoice2 guyView:)])
				(1100 [local137 (frameChoice2 guyView:)])
				(1200 [local151 (frameChoice2 guyView:)])
				(1300 [local165 (frameChoice2 guyView:)])
			)
		)
		(= local48 (frameChoice2 guyView:))
		(gChar2 setChar: 2 local48 gCardGameScriptNumber)
	else
		(gChar2 active: 0)
	)
	(if (> gPlayerCount 1)
		(= local46
			(switch gCardGameScriptNumber
				(100 [local53 (frameChoice3 guyView:)])
				(200 [local67 (frameChoice3 guyView:)])
				(300 [local81 (frameChoice3 guyView:)])
				(400 [local95 (frameChoice3 guyView:)])
				(500 [local109 (frameChoice3 guyView:)])
				(700 [local123 (frameChoice3 guyView:)])
				(1100 [local137 (frameChoice3 guyView:)])
				(1200 [local151 (frameChoice3 guyView:)])
				(1300 [local165 (frameChoice3 guyView:)])
			)
		)
		(= local49 (frameChoice3 guyView:))
		(gChar3 setChar: 3 local49 gCardGameScriptNumber)
	else
		(gChar3 active: 0)
	)
	(= global195 2)
	(= gSkill local44)
	(= global197 local45)
	(= global198 local46)
	(= gNewRoomNum (if (>= global387 1) gCardGameScriptNumber else gCardGameScriptNumber))
	(gSong fade: 0 30)
	(localproc_10 200)
)

(procedure (localproc_6 param1)
	(= local41
		(cond
			((not (frameChoice1 occupied:)) frameChoice1)
			((not (frameChoice2 occupied:)) frameChoice2)
			((not (frameChoice3 occupied:)) frameChoice3)
		)
	)
	(local41 occupied: 1)
	(switch param1
		(0
			(frameGuy1 hide:)
			(local41 guyView: 0)
			(local41 guyCel: param1)
			(= local42 (frameGuy1 x:))
			(= local43 (frameGuy1 y:))
			(frameGuy1 posn: (local41 playerX:) local52 cel: 0)
			(frameGuy1 show:)
		)
		(1
			(frameGuy2 hide:)
			(local41 guyView: 5)
			(local41 guyCel: param1)
			(= local42 (frameGuy2 x:))
			(= local43 (frameGuy2 y:))
			(frameGuy2 posn: (local41 playerX:) local52 cel: 0)
			(frameGuy2 show:)
		)
		(2
			(frameGuy3 hide:)
			(local41 guyView: 1)
			(local41 guyCel: param1)
			(= local42 (frameGuy3 x:))
			(= local43 (frameGuy3 y:))
			(frameGuy3 posn: (local41 playerX:) local52 cel: 0)
			(frameGuy3 show:)
		)
		(3
			(frameGuy4 hide:)
			(local41 guyView: 4)
			(local41 guyCel: param1)
			(= local42 (frameGuy4 x:))
			(= local43 (frameGuy4 y:))
			(frameGuy4 posn: (local41 playerX:) local52 cel: 0)
			(frameGuy4 show:)
		)
		(4
			(frameGuy5 hide:)
			(local41 guyView: 11)
			(local41 guyCel: param1)
			(= local42 (frameGuy5 x:))
			(= local43 (frameGuy5 y:))
			(frameGuy5 posn: (local41 playerX:) local52 cel: 0)
			(frameGuy5 show:)
		)
		(5
			(frameGuy6 hide:)
			(local41 guyView: 6)
			(local41 guyCel: param1)
			(= local42 (frameGuy6 x:))
			(= local43 (frameGuy6 y:))
			(frameGuy6 posn: (local41 playerX:) local52 cel: 0)
			(frameGuy6 show:)
		)
		(6
			(frameGuy7 hide:)
			(local41 guyView: 12)
			(local41 guyCel: param1)
			(= local42 (frameGuy7 x:))
			(= local43 (frameGuy7 y:))
			(frameGuy7 posn: (local41 playerX:) local52 cel: 0)
			(frameGuy7 show:)
		)
		(7
			(frameGuy8 hide:)
			(local41 guyView: 2)
			(local41 guyCel: param1)
			(= local42 (frameGuy8 x:))
			(= local43 (frameGuy8 y:))
			(frameGuy8 posn: (local41 playerX:) local52 cel: 0)
			(frameGuy8 show:)
		)
		(8
			(frameGuy9 hide:)
			(local41 guyView: 3)
			(local41 guyCel: param1)
			(= local42 (frameGuy9 x:))
			(= local43 (frameGuy9 y:))
			(frameGuy9 posn: (local41 playerX:) local52 cel: 0)
			(frameGuy9 show:)
		)
		(9
			(frameGuy10 hide:)
			(local41 guyView: 9)
			(local41 guyCel: param1)
			(= local42 (frameGuy10 x:))
			(= local43 (frameGuy10 y:))
			(frameGuy10 posn: (local41 playerX:) local52 cel: 0)
			(frameGuy10 show:)
		)
		(10
			(frameGuy11 hide:)
			(local41 guyView: 13)
			(local41 guyCel: param1)
			(= local42 (frameGuy11 x:))
			(= local43 (frameGuy11 y:))
			(frameGuy11 posn: (local41 playerX:) local52 cel: 0)
			(frameGuy11 show:)
		)
	)
)

(procedure (localproc_7 &tmp temp0)
	(= temp0 (Random 0 10))
	(localproc_9 temp0 frameGuy1)
	(FrameOut)
)

(procedure (localproc_8 &tmp temp0 temp1 temp2)
	(= temp0 (Random 0 10))
	(for ((= temp1 (Random 0 10))) (== temp0 temp1) ((= temp1 (Random 0 10)))
	)
	(for
		((= temp2 (Random 0 10)))
		(or (== temp0 temp2) (== temp1 temp2))
		((= temp2 (Random 0 10)))
	)
	(localproc_9 temp0 frameGuy1)
	(FrameOut)
	(localproc_10 50)
	(localproc_9 temp1 frameGuy2)
	(FrameOut)
	(localproc_10 50)
	(localproc_9 temp2 frameGuy3)
)

(procedure (localproc_9 param1 param2)
	(switch param1
		(0
			(localproc_3 0 param2)
		)
		(1
			(localproc_3 1 param2)
		)
		(2
			(localproc_3 2 param2)
		)
		(3
			(localproc_3 3 param2)
		)
		(4
			(localproc_3 4 param2)
		)
		(5
			(localproc_3 5 param2)
		)
		(6
			(localproc_3 6 param2)
		)
		(7
			(localproc_3 7 param2)
		)
		(8
			(localproc_3 8 param2)
		)
		(9
			(localproc_3 9 param2)
		)
		(10
			(localproc_3 10 param2)
		)
	)
)

(procedure (localproc_10 param1 &tmp temp0 temp1)
	(= temp0 (+ (GetTime) param1))
	(while (> temp0 (GetTime))
	)
)

(instance selectPlayers of Room
	(properties
		picture 900
		style 14
	)

	(method (init &tmp temp0 temp1)
		(super init:)
		(gGame_opt doit: 2)
		(if global921
			(= gAttitudeSetting 0)
			(= global916 1)
		)
		(cond
			(gAttitudeSetting
				(= local51 0)
			)
			(global916
				(= local51 0)
			)
			(else
				(= local51 1)
			)
		)
		(if (and (== gCardGameScriptNumber 200) (== gAttitudeSetting 0))
			(= gAttitudeSetting 1)
			(= global916 0)
		)
		(gTheIconBar enable:)
		(EnableCursor)
		(for ((= temp0 0)) (<= temp0 83) ((++ temp0))
			(= [local0 temp0] 0)
		)
		(if (not global921)
			(Load rsVIEW 906)
		)
		(Load rsVIEW 908)
		(Load rsVIEW 909)
		(= local40 0)
		(for ((= temp0 0)) (< temp0 11) ((++ temp0))
			(= [local1 temp0] 1)
			(= [local12 temp0] 1)
			(= [local23 9] 1)
			(if (< temp0 6)
				(= [local34 temp0] 0)
			)
		)
		(= local41 0)
		(= local42 0)
		(= local43 0)
		(if (not global921)
			(things add: animateButn)
		)
		(things
			add:
				okButn
				iconButn
				busButn
				helpButn
				name1
				name2
				name3
				name4
				name5
				name6
				name7
				name8
				name9
				name10
				name11
				frameGuy1
				frameGuy2
				frameGuy3
				frameGuy4
				frameGuy5
				frameGuy6
				frameGuy7
				frameGuy8
				frameGuy9
				frameGuy10
				frameGuy11
				frameChoice1
				quitButton
		)
		(frameChoice1 beingUsed: 0 occupied: 0)
		(frameChoice2 beingUsed: 0 occupied: 0)
		(frameChoice3 beingUsed: 0 occupied: 0)
		(switch gPlayerCount
			(1
				(frameChoice1 x: 260 y: 303 beingUsed: 1 addKeyMouse:)
			)
			(3
				(frameChoice1 x: 140 y: 303 beingUsed: 1 addKeyMouse:)
				(frameChoice2 x: 260 y: 303 beingUsed: 1 addKeyMouse:)
				(frameChoice3 x: 380 y: 303 beingUsed: 1 addKeyMouse:)
			)
		)
		(frameChoice1 init:)
		(if (> gPlayerCount 1)
			(things add: frameChoice2)
			(frameChoice2 init:)
			(things add: frameChoice3)
			(frameChoice3 init:)
		)
		(= local0 1)
		(okButn init: addKeyMouse:)
		(if (not global921)
			(animateButn init: addKeyMouse:)
		)
		(iconButn init: addKeyMouse:)
		(busButn init: addKeyMouse:)
		(helpButn init: addKeyMouse:)
		(name1 init: addKeyMouse:)
		(name2 init: addKeyMouse:)
		(name3 init: addKeyMouse:)
		(name4 init: addKeyMouse:)
		(name5 init: addKeyMouse:)
		(name6 init: addKeyMouse:)
		(name7 init: addKeyMouse:)
		(name8 init: addKeyMouse:)
		(name9 init: addKeyMouse:)
		(name10 init: addKeyMouse:)
		(name11 init: addKeyMouse:)
		(frameGuy1 init: addKeyMouse:)
		(frameGuy2 init: addKeyMouse:)
		(frameGuy3 init: addKeyMouse:)
		(frameGuy4 init: addKeyMouse:)
		(frameGuy5 init: addKeyMouse:)
		(frameGuy6 init: addKeyMouse:)
		(frameGuy7 init: addKeyMouse:)
		(frameGuy8 init: addKeyMouse:)
		(frameGuy9 init: addKeyMouse:)
		(frameGuy10 init: addKeyMouse:)
		(frameGuy11 init: addKeyMouse:)
		(quitButton init: addKeyMouse:)
		(cond
			(global916
				(busButn setCel: 1)
			)
			(gAttitudeSetting
				(animateButn setCel: 1)
			)
			(else
				(iconButn setCel: 1)
			)
		)
		(localproc_0)
		(FrameOut)
		(localproc_10 50)
		(if (> gPlayerCount 1)
			(localproc_8)
		else
			(localproc_7)
		)
		(gGame setCursor: 999)
	)

	(method (doit)
		(super doit: &rest)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(things firstTrue: #handleEvent event)
	)

	(method (dispose)
		(gSong setLoop: 1)
		(gSound setLoop: 1)
		(gSound2 setLoop: 1)
		(gSong stop:)
		(things release: dispose:)
		((KeyMouse objList:) release:)
		(if (not global921)
			(UnLoad 128 906)
		)
		(UnLoad 128 909)
		(UnLoad 128 908)
		(UnLoad 128 907)
		(DisposeScript 64922)
		(super dispose:)
	)
)

(instance things of List
	(properties)
)

(instance animateButn of HoyleTrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 908 setLoop: 5 cel: 0 posn: 7 319 setPri: 9)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global916 0)
			(= local51 0)
			(self setCel: 1)
			(busButn setCel: 0)
			(iconButn setCel: 0)
			(= gAttitudeSetting 1)
			(frameGuy1 view: 906 posn: 54 56)
			(frameGuy2 view: 906 posn: 161 55)
			(frameGuy3 view: 906 posn: 266 53)
			(frameGuy4 view: 906 posn: 365 58)
			(frameGuy5 view: 906 posn: 469 56)
			(frameGuy6 view: 906 posn: 585 54)
			(frameGuy7 view: 906 posn: 82 198)
			(frameGuy8 view: 906 posn: 198 198)
			(frameGuy9 view: 906 posn: 321 204)
			(frameGuy10 view: 906 posn: 438 196)
			(frameGuy11 view: 906 posn: 550 204)
			(name1 setLoop: 0)
			(name2 setLoop: 5)
			(name3 setLoop: 8)
			(name4 setLoop: 9)
			(name5 setLoop: 2)
			(name6 setLoop: 6)
			(name7 setLoop: 1)
			(name8 setLoop: 7)
			(name9 setLoop: 10)
			(name10 setLoop: 3)
			(name11 setLoop: 4)
			(= local52 363)
			(if (> gPlayerCount 1)
				(frameChoice1 occupied: 0 playerX: 199)
				(frameChoice2 occupied: 0 playerX: 319)
				(frameChoice3 occupied: 0 playerX: 439)
			else
				(frameChoice1 occupied: 0 playerX: 319)
			)
			(= local40 0)
			(for ((= temp0 0)) (< temp0 11) ((++ temp0))
				(= [local1 temp0] 1)
			)
		)
		(event claimed:)
	)
)

(instance iconButn of HoyleTrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 908 setLoop: 6 cel: 0 posn: 7 354 setPri: 9)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if (== gCardGameScriptNumber 200)
				(Print ticks: 400 fore: 0 mode: 1 addBitmap: 916 1 0 init:)
			else
				(= global916 0)
				(self setCel: 1)
				(busButn setCel: 0)
				(animateButn setCel: 0)
				(= local51 1)
				(= gAttitudeSetting 0)
				(frameGuy1 view: 912 posn: 48 50)
				(frameGuy2 view: 912 posn: 150 50)
				(frameGuy3 view: 912 posn: 260 50)
				(frameGuy4 view: 912 posn: 370 50)
				(frameGuy5 view: 912 posn: 480 50)
				(frameGuy6 view: 912 posn: 590 50)
				(frameGuy7 view: 912 posn: 79 200)
				(frameGuy8 view: 912 posn: 201 200)
				(frameGuy9 view: 912 posn: 315 200)
				(frameGuy10 view: 912 posn: 439 200)
				(frameGuy11 view: 912 posn: 565 200)
				(name1 setLoop: 0)
				(name2 setLoop: 5)
				(name3 setLoop: 8)
				(name4 setLoop: 9)
				(name5 setLoop: 2)
				(name6 setLoop: 6)
				(name7 setLoop: 1)
				(name8 setLoop: 7)
				(name9 setLoop: 10)
				(name10 setLoop: 3)
				(name11 setLoop: 4)
				(= local52 363)
				(if (> gPlayerCount 1)
					(frameChoice1 occupied: 0 playerX: 199)
					(frameChoice2 occupied: 0 playerX: 319)
					(frameChoice3 occupied: 0 playerX: 439)
				else
					(frameChoice1 occupied: 0 playerX: 319)
				)
				(= local40 0)
				(for ((= temp0 0)) (< temp0 11) ((++ temp0))
					(= [local1 temp0] 1)
				)
			)
		)
		(event claimed:)
	)
)

(instance busButn of HoyleTrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 908 setLoop: 7 cel: 0 posn: 7 389 setPri: 9)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if (== gCardGameScriptNumber 200)
				(Print ticks: 400 fore: 0 mode: 1 addBitmap: 916 1 0 init:)
			else
				(= global916 1)
				(self setCel: 1)
				(iconButn setCel: 0)
				(animateButn setCel: 0)
				(= local51 0)
				(= gAttitudeSetting 0)
				(frameGuy1 view: 909 posn: 10 12)
				(frameGuy2 view: 909 posn: 119 12)
				(frameGuy3 view: 909 posn: 227 12)
				(frameGuy4 view: 909 posn: 334 12)
				(frameGuy5 view: 909 posn: 443 12)
				(frameGuy6 view: 909 posn: 551 12)
				(frameGuy7 view: 909 posn: 40 161)
				(frameGuy8 view: 909 posn: 162 161)
				(frameGuy9 view: 909 posn: 280 161)
				(frameGuy10 view: 909 posn: 399 161)
				(frameGuy11 view: 909 posn: 520 161)
				(name1 setLoop: 11)
				(name2 setLoop: 16)
				(name3 setLoop: 19)
				(name4 setLoop: 20)
				(name5 setLoop: 13)
				(name6 setLoop: 17)
				(name7 setLoop: 12)
				(name8 setLoop: 18)
				(name9 setLoop: 21)
				(name10 setLoop: 14)
				(name11 setLoop: 15)
				(frameChoice1 occupied: 0)
				(frameChoice2 occupied: 0)
				(frameChoice3 occupied: 0)
				(= local52 315)
				(if (> gPlayerCount 1)
					(frameChoice1 occupied: 0 playerX: 160)
					(frameChoice2 occupied: 0 playerX: 280)
					(frameChoice3 occupied: 0 playerX: 400)
				else
					(frameChoice1 occupied: 0 playerX: 280)
				)
				(= local40 0)
				(for ((= temp0 0)) (< temp0 11) ((++ temp0))
					(= [local1 temp0] 1)
				)
			)
		)
		(event claimed:)
	)
)

(instance helpButn of HoyleTrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 908 setLoop: 4 cel: 0 posn: 522 336 setPri: 9)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if global921
				(proc821_0 3 3 31 4)
			else
				(proc821_0 3 4 30 4)
			)
		)
		(event claimed:)
	)
)

(instance randomButn of HoyleTrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 908 setLoop: 4 cel: 0 posn: 32 335 setPri: 9)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if (> gPlayerCount 1)
				(switch (Random 0 2)
					(0
						(localproc_3 0 frameGuy1)
						(switch (Random 0 1)
							(0
								(localproc_3 1 frameGuy2)
								(localproc_3 5 frameGuy6)
							)
							(1
								(localproc_3 5 frameGuy6)
								(localproc_3 1 frameGuy2)
							)
						)
					)
					(1
						(localproc_3 1 frameGuy2)
						(switch (Random 0 1)
							(0
								(localproc_3 0 frameGuy1)
								(localproc_3 5 frameGuy6)
							)
							(1
								(localproc_3 5 frameGuy6)
								(localproc_3 0 frameGuy1)
							)
						)
					)
					(2
						(localproc_3 5 frameGuy6)
						(switch (Random 0 1)
							(0
								(localproc_3 0 frameGuy1)
								(localproc_3 1 frameGuy2)
							)
							(1
								(localproc_3 1 frameGuy2)
								(localproc_3 0 frameGuy1)
							)
						)
					)
				)
			else
				(switch (Random 0 2)
					(0
						(localproc_3 0 frameGuy1)
					)
					(1
						(localproc_3 1 frameGuy2)
					)
					(2
						(localproc_3 5 frameGuy6)
					)
				)
			)
			(localproc_5)
		)
		(event claimed:)
	)
)

(instance okButn of TrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 908 setLoop: 3 cel: 0 posn: 522 392 setPri: 9)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (super handleEvent: event)
			(event claimed: 1)
			(cond
				((== local40 gPlayerCount)
					(DisableCursor)
					(= local44 -1)
					(= local45 -1)
					(= local46 -1)
					(= local47 -1)
					(= local48 -1)
					(= local49 -1)
					(= global195 -1)
					(= gSkill -1)
					(= global197 -1)
					(= global198 -1)
					(= global469
						(= local44
							(switch gCardGameScriptNumber
								(100 [local53 (frameChoice1 guyView:)])
								(200 [local67 (frameChoice1 guyView:)])
								(300 [local81 (frameChoice1 guyView:)])
								(400 [local95 (frameChoice1 guyView:)])
								(500 [local109 (frameChoice1 guyView:)])
								(700 [local123 (frameChoice1 guyView:)])
								(1100 [local137 (frameChoice1 guyView:)])
								(1200 [local151 (frameChoice1 guyView:)])
								(1300 [local165 (frameChoice1 guyView:)])
							)
						)
					)
					(if global916
						(= local47 (+ (frameChoice1 guyView:) 1400))
					else
						(= local47 (frameChoice1 guyView:))
					)
					(gChar1 setChar: 1 local47 gCardGameScriptNumber)
					(if (> gPlayerCount 1)
						(= global470
							(= local45
								(switch gCardGameScriptNumber
									(100 [local53 (frameChoice2 guyView:)])
									(200 [local67 (frameChoice2 guyView:)])
									(300 [local81 (frameChoice2 guyView:)])
									(400 [local95 (frameChoice2 guyView:)])
									(500 [local109 (frameChoice2 guyView:)])
									(700 [local123 (frameChoice2 guyView:)])
									(1100 [local137 (frameChoice2 guyView:)])
									(1200 [local151 (frameChoice2 guyView:)])
									(1300 [local165 (frameChoice2 guyView:)])
								)
							)
						)
						(if global916
							(= local48 (+ (frameChoice2 guyView:) 1400))
						else
							(= local48 (frameChoice2 guyView:))
						)
						(gChar2 setChar: 2 local48 gCardGameScriptNumber)
					else
						(gChar2 active: 0)
					)
					(if (> gPlayerCount 1)
						(= global471
							(= local46
								(switch gCardGameScriptNumber
									(100 [local53 (frameChoice3 guyView:)])
									(200 [local67 (frameChoice3 guyView:)])
									(300 [local81 (frameChoice3 guyView:)])
									(400 [local95 (frameChoice3 guyView:)])
									(500 [local109 (frameChoice3 guyView:)])
									(700 [local123 (frameChoice3 guyView:)])
									(1100 [local137 (frameChoice3 guyView:)])
									(1200 [local151 (frameChoice3 guyView:)])
									(1300 [local165 (frameChoice3 guyView:)])
								)
							)
						)
						(if global916
							(= local49 (+ (frameChoice3 guyView:) 1400))
						else
							(= local49 (frameChoice3 guyView:))
						)
						(gChar3 setChar: 3 local49 gCardGameScriptNumber)
					else
						(gChar3 active: 0)
					)
					(gGame_opt doit: 3)
					(= global195 2)
					(= gNewRoomNum (if (>= global387 1) gCardGameScriptNumber else gCardGameScriptNumber))
					(gSong fade: 0 30)
					(localproc_10 200)
				)
				((== gPlayerCount 1)
					(Print
						margin: 13
						ticks: 400
						font: gUserFont
						fore: 0
						addBitmap: 917 0 0
					)
					(= temp3 (IntArray new: 4))
					(= temp4 (Str new:))
					(Message msgGET 3 19 7 1 1 (temp4 data:)) ; "You must choose one player."
					(Text
						0 ; TextSize
						(temp3 data:)
						(temp4 data:)
						gUserFont
						(Print width:)
						0
					)
					(= temp1 (/ (- (Print width:) (temp3 at: 2)) 2))
					(= temp2
						(/
							(-
								(= temp5
									(- (CelHigh 917 0 0) (* 2 (Print margin:)))
								)
								(temp3 at: 3)
							)
							2
						)
					)
					(Print addText: 19 7 1 1 temp1 temp2 init:) ; "You must choose one player."
					(temp4 dispose:)
					(temp3 dispose:)
				)
				(else
					(Print font: gUserFont fore: 0 addBitmap: 917 0 0)
					(= temp3 (IntArray new: 4))
					(= temp4 (Str new:))
					(Message msgGET 3 19 7 2 1 (temp4 data:)) ; "You must choose three players."
					(Text
						0 ; TextSize
						(temp3 data:)
						(temp4 data:)
						gUserFont
						(Print width:)
						0
					)
					(= temp1 (/ (- (Print width:) (temp3 at: 2)) 2))
					(= temp2
						(/
							(-
								(= temp5
									(- (CelHigh 917 0 0) (* 2 (Print margin:)))
								)
								(temp3 at: 3)
							)
							2
						)
					)
					(Print addText: 19 7 2 1 temp1 temp2 init:) ; "You must choose three players."
					(temp4 dispose:)
					(temp3 dispose:)
				)
			)
		)
		(event claimed:)
	)
)

(instance frameGuy1 of HoyleTrackingView
	(properties)

	(method (init)
		(self
			offsetY: 39
			ignoreActors:
			view: 906
			setLoop: 0
			cel: 0
			posn: 54 56
			setPri: 9
		)
		(cond
			(global916
				(self view: 909 posn: 10 12)
			)
			((== gAttitudeSetting 0)
				(self view: 912 posn: 48 50)
			)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_3 0 self)
		)
		(event claimed:)
	)
)

(instance frameGuy2 of HoyleTrackingView
	(properties)

	(method (init)
		(self
			offsetY: 41
			ignoreActors:
			view: 906
			setLoop: 5
			cel: 0
			posn: 161 55
			setPri: 9
		)
		(cond
			(global916
				(self view: 909 posn: 119 12)
			)
			((== gAttitudeSetting 0)
				(self view: 912 posn: 150 50)
			)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_3 1 self)
		)
		(event claimed:)
	)
)

(instance frameGuy3 of HoyleTrackingView
	(properties)

	(method (init)
		(self
			offsetY: 41
			ignoreActors:
			view: 906
			setLoop: 8
			cel: 0
			posn: 266 53
			setPri: 9
		)
		(cond
			(global916
				(self view: 909 posn: 227 12)
			)
			((== gAttitudeSetting 0)
				(self view: 912 posn: 260 50)
			)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_3 2 self)
		)
		(event claimed:)
	)
)

(instance frameGuy4 of HoyleTrackingView
	(properties)

	(method (init)
		(self
			offsetY: 45
			ignoreActors:
			view: 906
			setLoop: 9
			cel: 0
			posn: 365 58
			setPri: 9
		)
		(cond
			(global916
				(self view: 909 posn: 334 12)
			)
			((== gAttitudeSetting 0)
				(self view: 912 posn: 370 50)
			)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_3 3 self)
		)
		(event claimed:)
	)
)

(instance frameGuy5 of HoyleTrackingView
	(properties)

	(method (init)
		(self
			offsetY: 44
			ignoreActors:
			view: 906
			setLoop: 2
			cel: 0
			posn: 469 56
			setPri: 9
		)
		(cond
			(global916
				(self view: 909 posn: 443 12)
			)
			((== gAttitudeSetting 0)
				(self view: 912 posn: 480 50)
			)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_3 4 self)
		)
		(event claimed:)
	)
)

(instance frameGuy6 of HoyleTrackingView
	(properties)

	(method (init)
		(self
			offsetY: 41
			ignoreActors:
			view: 906
			setLoop: 6
			cel: 0
			posn: 585 54
			setPri: 9
		)
		(cond
			(global916
				(self view: 909 posn: 551 12)
			)
			((== gAttitudeSetting 0)
				(self view: 912 posn: 590 50)
			)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_3 5 self)
		)
		(event claimed:)
	)
)

(instance frameGuy7 of HoyleTrackingView
	(properties)

	(method (init)
		(self
			offsetY: 46
			ignoreActors:
			view: 906
			setLoop: 1
			cel: 0
			posn: 82 198
			setPri: 9
		)
		(cond
			(global916
				(self view: 909 posn: 40 161)
			)
			((== gAttitudeSetting 0)
				(self view: 912 posn: 79 200)
			)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_3 6 self)
		)
		(event claimed:)
	)
)

(instance frameGuy8 of HoyleTrackingView
	(properties)

	(method (init)
		(self
			offsetY: 43
			ignoreActors:
			view: 906
			setLoop: 7
			cel: 0
			posn: 198 198
			setPri: 9
		)
		(cond
			(global916
				(self view: 909 posn: 162 161)
			)
			((== gAttitudeSetting 0)
				(self view: 912 posn: 200 200)
			)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_3 7 self)
		)
		(event claimed:)
	)
)

(instance frameGuy9 of HoyleTrackingView
	(properties)

	(method (init)
		(self
			offsetY: 38
			ignoreActors:
			view: 906
			setLoop: 10
			cel: 0
			posn: 321 204
			setPri: 9
		)
		(cond
			(global916
				(self view: 909 posn: 280 161)
			)
			((== gAttitudeSetting 0)
				(self view: 912 posn: 315 200)
			)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_3 8 self)
		)
		(event claimed:)
	)
)

(instance frameGuy10 of HoyleTrackingView
	(properties)

	(method (init)
		(self
			offsetY: 38
			ignoreActors:
			view: 906
			setLoop: 3
			cel: 0
			posn: 438 196
			setPri: 9
		)
		(cond
			(global916
				(self view: 909 posn: 399 161)
			)
			((== gAttitudeSetting 0)
				(self view: 912 posn: 439 200)
			)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_3 9 self)
		)
		(event claimed:)
	)
)

(instance frameGuy11 of HoyleTrackingView
	(properties)

	(method (init)
		(self
			offsetY: 38
			ignoreActors:
			view: 906
			setLoop: 4
			cel: 0
			posn: 550 204
			setPri: 9
		)
		(cond
			(global916
				(self view: 909 posn: 520 161)
			)
			((== gAttitudeSetting 0)
				(self view: 912 posn: 565 200)
			)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_3 10 self)
		)
		(event claimed:)
	)
)

(class Choice of TrackingView
	(properties
		occupied 0
		guyCel 0
		guyView 0
		guyX 0
		guyY 0
		playerX 0
		beingUsed 0
		playerName 0
	)
)

(instance frameChoice1 of Choice
	(properties)

	(method (init)
		(self
			ignoreActors:
			view: 908
			setLoop: (if (> gPlayerCount 1) 0 else 1)
			cel: 0
			posn: x y
			setPri: 10
		)
		(if (or global916 local51)
			(= local52 315)
			(if (> gPlayerCount 1)
				(= playerX 160)
			else
				(= playerX 280)
			)
		else
			(= local52 363)
			(if (> gPlayerCount 1)
				(= playerX 199)
			else
				(= playerX 319)
			)
		)
		(super init: &rest)
		(if (> gPlayerCount 1)
			(self nsLeft: 140 nsRight: 259 nsTop: 303 nsBottom: 423)
		else
			(self nsLeft: 260 nsRight: 349 nsTop: 303 nsBottom: 423)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if occupied
				(= occupied 0)
				(localproc_4 guyCel guyX guyY)
				(= [local1 guyCel] 1)
				(-- local40)
			else
				(Print
					margin: 13
					ticks: 400
					font: gUserFont
					fore: 0
					posn: 150 150
					addBitmap: 917 0 0
				)
				(= temp2 (IntArray new: 4))
				(= temp3 (Str new:))
				(Message msgGET 3 21 10 0 1 (temp3 data:)) ; "Choose a player."
				(Text 0 (temp2 data:) (temp3 data:) gUserFont (Print width:) 0) ; TextSize
				(= temp0 (/ (- (Print width:) (temp2 at: 2)) 2))
				(= temp1
					(/
						(-
							(= temp4
								(- (CelHigh 917 0 0) (* 2 (Print margin:)))
							)
							(temp2 at: 3)
						)
						2
					)
				)
				(Print addText: 21 10 0 1 temp0 temp1 init:) ; "Choose a player."
				(temp3 dispose:)
				(temp2 dispose:)
			)
		)
		(event claimed:)
	)
)

(instance frameChoice2 of Choice
	(properties)

	(method (init)
		(self
			ignoreActors:
			view: 908
			setLoop: (if (== gCardGameScriptNumber 700) 2 else 0)
			cel: 0
			posn: x y
			setPri: 10
		)
		(if (or global916 local51)
			(= local52 315)
			(= playerX 280)
		else
			(= local52 363)
			(= playerX 319)
		)
		(super init: &rest)
		(self nsLeft: 260 nsRight: 349 nsTop: 303 nsBottom: 423)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if occupied
				(= occupied 0)
				(localproc_4 guyCel guyX guyY)
				(= [local1 guyCel] 1)
				(-- local40)
			else
				(Print
					margin: 13
					ticks: 400
					font: gUserFont
					fore: 0
					posn: 150 150
					addBitmap: 917 0 0
				)
				(= temp2 (IntArray new: 4))
				(= temp4 (Str new:))
				(Message msgGET 3 21 10 0 1 (temp4 data:)) ; "Choose a player."
				(Text 0 (temp2 data:) (temp4 data:) gUserFont (Print width:) 0) ; TextSize
				(= temp0 (/ (- (Print width:) (temp2 at: 2)) 2))
				(= temp1
					(/
						(-
							(= temp3
								(- (CelHigh 917 0 0) (* 2 (Print margin:)))
							)
							(temp2 at: 3)
						)
						2
					)
				)
				(Print addText: 21 10 0 1 temp0 temp1 init:) ; "Choose a player."
				(temp4 dispose:)
				(temp2 dispose:)
			)
		)
		(event claimed:)
	)
)

(instance frameChoice3 of Choice
	(properties)

	(method (init)
		(self ignoreActors: view: 908 setLoop: 0 cel: 0 posn: x y setPri: 10)
		(if (or global916 local51)
			(= local52 315)
			(= playerX 400)
		else
			(= local52 363)
			(= playerX 439)
		)
		(super init: &rest)
		(self nsLeft: 380 nsRight: 499 nsTop: 303 nsBottom: 423)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if occupied
				(= occupied 0)
				(localproc_4 guyCel guyX guyY)
				(= [local1 guyCel] 1)
				(-- local40)
			else
				(Print
					margin: 13
					ticks: 400
					font: gUserFont
					fore: 0
					posn: 150 150
					addBitmap: 917 0 0
				)
				(= temp2 (IntArray new: 4))
				(= temp3 (Str new:))
				(Message msgGET 3 21 10 0 1 (temp3 data:)) ; "Choose a player."
				(Text 0 (temp2 data:) (temp3 data:) gUserFont (Print width:) 0) ; TextSize
				(= temp0 (/ (- (Print width:) (temp2 at: 2)) 2))
				(= temp1
					(/
						(-
							(= temp4
								(- (CelHigh 917 0 0) (* 2 (Print margin:)))
							)
							(temp2 at: 3)
						)
						2
					)
				)
				(Print addText: 21 10 0 1 temp0 temp1 init:) ; "Choose a player."
				(temp3 dispose:)
				(temp2 dispose:)
			)
		)
		(event claimed:)
	)
)

(class selectTrackingView of TrackingView
	(properties)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(if
			(and
				(not (event claimed:))
				(not (& (event type:) evMOUSERELEASE))
				(not (& (event type:) evVERB))
				(<= nsLeft (event x:) (- nsRight 1))
				(<= nsTop (event y:) (- nsBottom 1))
			)
			(cond
				((proc0_2 event)
					(self enterKey:)
					(= temp0 1)
					(event claimed: 1)
				)
				((& (event type:) evMOUSEBUTTON)
					(if (= temp0 (self track:))
						(gSound2 play: 901)
					)
					(event claimed: 1)
				)
			)
		)
		(return temp0)
	)
)

(instance quitButton of selectTrackingView
	(properties
		x 522
		y 364
		view 908
		loop 8
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global748 0)
			(if global924
				((ScriptID 930 0) init: 9131 0 900) ; yesNo
			else
				((ScriptID 930 0) init: 913 2 gCardGameScriptNumber) ; yesNo
			)
			(DisposeScript 930)
			(cond
				((== global748 1)
					(if global924
						(gGame quitGame:)
						(proc0_8 0)
					else
						(= gNewRoomNum 975) ; chooseGame
					)
				)
				((== global748 3)
					(gGame quitGame:)
				)
			)
		)
	)
)

(class NamePlate of TrackingView
	(properties)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(self sierraText:)
			(event claimed: 1)
		)
		(event claimed:)
	)

	(method (sierraText)
		(return 1)
	)
)

(instance name1 of NamePlate
	(properties
		priority 10
		view 907
	)

	(method (init)
		(if global916
			(self loop: 11)
		)
		(self
			ignoreActors:
			setLoop: loop
			posn: 1 122
			setPri: priority
			associatedObj: frameGuy1
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_2
			(if global916 15 else 1)
			(switch gCardGameScriptNumber
				(100 5)
				(200 6)
				(300 6)
				(400 6)
				(500 6)
				(700 3)
				(1100 6)
				(1200 6)
				(1300 5)
			)
		)
	)
)

(instance name2 of NamePlate
	(properties
		priority 10
		view 907
		loop 5
	)

	(method (init)
		(if global916
			(self loop: 16)
		)
		(self
			ignoreActors:
			setLoop: loop
			posn: 110 122
			setPri: priority
			associatedObj: frameGuy2
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_2
			(if global916 24 else 6)
			(switch gCardGameScriptNumber
				(100 5)
				(200 6)
				(300 6)
				(400 6)
				(500 5)
				(700 5)
				(1100 5)
				(1200 5)
				(1300 5)
			)
		)
	)
)

(instance name3 of NamePlate
	(properties
		priority 10
		view 907
		loop 8
	)

	(method (init)
		(if global916
			(self loop: 19)
		)
		(self
			ignoreActors:
			setLoop: loop
			posn: 218 122
			setPri: priority
			associatedObj: frameGuy3
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_2
			(if global916 16 else 2)
			(switch gCardGameScriptNumber
				(100 6)
				(200 6)
				(300 5)
				(400 5)
				(500 6)
				(700 5)
				(1100 6)
				(1200 5)
				(1300 5)
			)
		)
	)
)

(instance name4 of NamePlate
	(properties
		priority 10
		view 907
		loop 9
	)

	(method (init)
		(if global916
			(self loop: 20)
		)
		(self
			ignoreActors:
			setLoop: loop
			posn: 326 122
			setPri: priority
			associatedObj: frameGuy4
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_2
			(if global916 23 else 5)
			(switch gCardGameScriptNumber
				(100 5)
				(200 3)
				(300 6)
				(400 6)
				(500 5)
				(700 5)
				(1100 6)
				(1200 6)
				(1300 3)
			)
		)
	)
)

(instance name5 of NamePlate
	(properties
		priority 10
		view 907
		loop 2
	)

	(method (init)
		(if global916
			(self loop: 13)
		)
		(self
			ignoreActors:
			setLoop: loop
			posn: 434 122
			setPri: priority
			associatedObj: frameGuy8
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_2
			(if global916 27 else 12)
			(switch gCardGameScriptNumber
				(100 6)
				(200 5)
				(300 6)
				(400 6)
				(500 6)
				(700 6)
				(1100 3)
				(1200 6)
				(1300 6)
			)
		)
	)
)

(instance name6 of NamePlate
	(properties
		priority 10
		view 907
		loop 6
	)

	(method (init)
		(if global916
			(self loop: 17)
		)
		(self
			ignoreActors:
			setLoop: loop
			posn: 543 122
			setPri: priority
			associatedObj: frameGuy6
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_2
			(if global916 25 else 7)
			(switch gCardGameScriptNumber
				(100 6)
				(200 5)
				(300 6)
				(400 5)
				(500 5)
				(700 6)
				(1100 5)
				(1200 5)
				(1300 6)
			)
		)
	)
)

(instance name7 of NamePlate
	(properties
		priority 10
		view 907
		loop 1
	)

	(method (init)
		(if global916
			(self loop: 12)
		)
		(self
			ignoreActors:
			setLoop: loop
			posn: 32 271
			setPri: priority
			associatedObj: frameGuy7
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_2
			(if global916 28 else 13)
			(switch gCardGameScriptNumber
				(100 6)
				(200 6)
				(300 5)
				(400 6)
				(500 6)
				(700 6)
				(1100 6)
				(1200 6)
				(1300 5)
			)
		)
	)
)

(instance name8 of NamePlate
	(properties
		priority 10
		view 907
		loop 7
	)

	(method (init)
		(if global916
			(self loop: 18)
		)
		(self
			ignoreActors:
			setLoop: loop
			posn: 153 271
			setPri: priority
			associatedObj: frameGuy5
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_2
			(if global916 17 else 3)
			(switch gCardGameScriptNumber
				(100 5)
				(200 6)
				(300 5)
				(400 5)
				(500 5)
				(700 5)
				(1100 5)
				(1200 5)
				(1300 6)
			)
		)
	)
)

(instance name9 of NamePlate
	(properties
		priority 10
		view 907
		loop 10
	)

	(method (init)
		(if global916
			(self loop: 21)
		)
		(self
			ignoreActors:
			setLoop: loop
			posn: 272 271
			setPri: priority
			associatedObj: frameGuy9
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_2
			(if global916 18 else 4)
			(switch gCardGameScriptNumber
				(100 6)
				(200 3)
				(300 3)
				(400 6)
				(500 6)
				(700 6)
				(1100 3)
				(1200 6)
				(1300 6)
			)
		)
	)
)

(instance name10 of NamePlate
	(properties
		priority 10
		view 907
		loop 3
	)

	(method (init)
		(if global916
			(self loop: 14)
		)
		(self
			ignoreActors:
			setLoop: loop
			posn: 391 271
			setPri: priority
			associatedObj: frameGuy10
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_2
			(if global916 26 else 10)
			(switch gCardGameScriptNumber
				(100 3)
				(200 3)
				(300 3)
				(400 3)
				(500 3)
				(700 3)
				(1100 6)
				(1200 6)
				(1300 3)
			)
		)
	)
)

(instance name11 of NamePlate
	(properties
		priority 10
		view 907
		loop 4
	)

	(method (init)
		(if global916
			(self loop: 15)
		)
		(self
			ignoreActors:
			setLoop: loop
			posn: 512 271
			setPri: priority
			associatedObj: frameGuy11
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_2
			(if global916 29 else 14)
			(switch gCardGameScriptNumber
				(100 6)
				(200 3)
				(300 3)
				(400 3)
				(500 3)
				(700 3)
				(1100 3)
				(1200 6)
				(1300 6)
			)
		)
	)
)

