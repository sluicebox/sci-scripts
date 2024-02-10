;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use KeyMouse)
(use TrackingView)
(use Print)
(use LoadMany)
(use Game)
(use System)

(public
	selectPlayers 0
)

(local
	local0
	[local1 9]
	[local10 9]
	[local19 9]
	[local28 6]
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	[local44 40]
	[local84 9] = [0 1 2 0 2 1 0 1 1]
	[local93 9] = [2 2 1 0 1 2 2 0 0]
	[local102 9] = [0 2 2 0 2 0 2 1 1]
	[local111 9] = [1 2 0 1 1 0 2 1 0]
	[local120 9] = [2 1 0 2 0 1 1 0 0]
	[local129 9] = [2 1 2 1 0 1 0 2 2]
	[local138 9] = [2 2 0 0 1 0 2 2 0]
	[local147 9] = [1 1 0 2 0 1 1 1 2]
	[local156 9] = [1 0 1 1 0 2 2 0 1]
	[local165 9] = [1 0 2 0 2 2 1 0 2]
	[local174 9] = [1 0 0 1 1 2 0 2 2]
	[local183 9] = [2 0 1 2 1 0 0 2 1]
	[local192 9] = [0 1 2 2 0 0 1 1 2]
	[local201 9] = [0 0 2 1 2 0 1 2 1]
	[local210 18] = [0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17]
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3)
	(= temp3 (PicNotValid))
	(PicNotValid 1)
	(= temp1 (if (== (= local0 (if (== local0 0) 1 else 0)) 0) 0 else 1))
	(= temp0 (if (== local0 0) 908 else 909))
	(if (== local0 0)
		(for ((= temp2 0)) (<= temp2 8) ((++ temp2))
			(= [local19 temp2] [local1 temp2])
		)
	else
		(for ((= temp2 0)) (<= temp2 8) ((++ temp2))
			(= [local19 temp2] [local10 temp2])
		)
	)
	(localproc_1)
	(if [local19 0]
		(DrawCel temp0 0 0 (frameGuy1 x:) (frameGuy1 y:) 8)
	else
		(DrawCel 906 temp1 0 (frameGuy1 x:) (frameGuy1 y:) 8)
	)
	(if [local19 1]
		(DrawCel temp0 0 1 (frameGuy2 x:) (frameGuy2 y:) 8)
	else
		(DrawCel 906 temp1 1 (frameGuy2 x:) (frameGuy2 y:) 8)
	)
	(if [local19 2]
		(DrawCel temp0 0 2 (frameGuy3 x:) (frameGuy3 y:) 8)
	else
		(DrawCel 906 temp1 2 (frameGuy3 x:) (frameGuy3 y:) 8)
	)
	(if [local19 3]
		(DrawCel temp0 0 3 (frameGuy4 x:) (frameGuy4 y:) 8)
	else
		(DrawCel 906 temp1 3 (frameGuy4 x:) (frameGuy4 y:) 8)
	)
	(if [local19 4]
		(DrawCel temp0 0 4 (frameGuy5 x:) (frameGuy5 y:) 8)
	else
		(DrawCel 906 temp1 4 (frameGuy5 x:) (frameGuy5 y:) 8)
	)
	(if [local19 5]
		(DrawCel temp0 0 5 (frameGuy6 x:) (frameGuy6 y:) 8)
	else
		(DrawCel 906 temp1 5 (frameGuy6 x:) (frameGuy6 y:) 8)
	)
	(if [local19 6]
		(DrawCel temp0 0 6 (frameGuy7 x:) (frameGuy7 y:) 8)
	else
		(DrawCel 906 temp1 6 (frameGuy7 x:) (frameGuy7 y:) 8)
	)
	(if [local19 7]
		(DrawCel temp0 0 7 (frameGuy8 x:) (frameGuy8 y:) 8)
	else
		(DrawCel 906 temp1 7 (frameGuy8 x:) (frameGuy8 y:) 8)
	)
	(if [local19 8]
		(DrawCel temp0 0 8 (frameGuy9 x:) (frameGuy9 y:) 8)
	else
		(DrawCel 906 temp1 8 (frameGuy9 x:) (frameGuy9 y:) 8)
	)
	(RedrawCast)
)

(procedure (localproc_1)
	(if (frameGuy1 underBits:)
		(UnLoad 133 (frameGuy1 underBits:))
		(frameGuy1 underBits: 0)
	)
	(if (frameGuy2 underBits:)
		(UnLoad 133 (frameGuy2 underBits:))
		(frameGuy2 underBits: 0)
	)
	(if (frameGuy3 underBits:)
		(UnLoad 133 (frameGuy3 underBits:))
		(frameGuy3 underBits: 0)
	)
	(if (frameGuy4 underBits:)
		(UnLoad 133 (frameGuy4 underBits:))
		(frameGuy4 underBits: 0)
	)
	(if (frameGuy5 underBits:)
		(UnLoad 133 (frameGuy5 underBits:))
		(frameGuy5 underBits: 0)
	)
	(if (frameGuy6 underBits:)
		(UnLoad 133 (frameGuy6 underBits:))
		(frameGuy6 underBits: 0)
	)
	(if (frameGuy7 underBits:)
		(UnLoad 133 (frameGuy7 underBits:))
		(frameGuy7 underBits: 0)
	)
	(if (frameGuy8 underBits:)
		(UnLoad 133 (frameGuy8 underBits:))
		(frameGuy8 underBits: 0)
	)
	(if (frameGuy9 underBits:)
		(UnLoad 133 (frameGuy9 underBits:))
		(frameGuy9 underBits: 0)
	)
	(if (frameChoice1 underBits:)
		(UnLoad 133 (frameChoice1 underBits:))
		(frameChoice1 underBits: 0)
	)
	(if (frameChoice2 underBits:)
		(UnLoad 133 (frameChoice2 underBits:))
		(frameChoice2 underBits: 0)
	)
	(if (frameChoice3 underBits:)
		(UnLoad 133 (frameChoice3 underBits:))
		(frameChoice3 underBits: 0)
	)
)

(procedure (localproc_2 param1 &tmp temp0) ; UNUSED
	(= temp0
		(switch param1
			(0 4)
			(1 25)
			(2 24)
			(3 6)
			(4 9)
			(5 5)
			(6 26)
			(7 23)
			(8 27)
			(9 28)
			(10 29)
			(11 30)
			(12 31)
			(13 32)
			(14 33)
			(15 34)
			(16 35)
			(17 36)
		)
	)
	(Message msgGET 3 temp0 6 0 1 @local44)
	(return @local44)
)

(procedure (localproc_3 param1 param2 &tmp [temp0 100] [temp100 40] [temp140 30] temp170 temp171 temp172 temp173 temp174)
	(Message msgGET 3 37 0 0 (/ global193 100) @temp0)
	(Message msgGET 3 param1 6 0 1 @temp100)
	(Message msgGET 3 22 11 param2 1 @temp140)
	(StrCat @temp0 @temp100)
	(StrCat @temp0 { })
	(StrCat @temp0 @temp140)
	(= temp170
		(if
			(>=
				(= temp173
					(switch param1
						(4 0)
						(25 1)
						(24 2)
						(6 3)
						(9 4)
						(5 5)
						(26 6)
						(23 7)
						(27 8)
						(28 9)
						(29 10)
						(30 11)
						(31 12)
						(32 13)
						(33 14)
						(34 15)
						(35 16)
						(36 17)
					)
				)
				9
			)
			909
		else
			908
		)
	)
	(= temp171 10)
	(if (or (== param1 26) (== param1 27) (== param1 31) (== param1 36))
		(= temp171 11)
	)
	(= temp172 (mod temp173 9))
	(= temp174 (Print width:))
	(Print
		width: 0
		font: 3
		mode: 1
		addIcon: temp170 temp171 temp172 118 0
		addText: @temp0
		posn: 77 87
		init:
	)
	(Print width: temp174)
)

(procedure (localproc_4 param1 param2)
	(cond
		((== local0 0)
			(if [local1 param1]
				(if (== local34 global194)
					(Print addText: 20 8 0 1 init:) ; "That would be too many players."
				else
					(= [local1 param1] 0)
					(++ local34)
					(localproc_5 param1 param2)
					(local35
						guyCel: param1
						guyView: 908
						guyX: local36
						guyY: local37
					)
				)
			else
				(Print addText: 20 9 0 1 init:) ; "There is no one here."
			)
		)
		([local10 param1]
			(if (== local34 global194)
				(Print addText: 20 8 0 1 init:) ; "That would be too many players."
			else
				(= [local10 param1] 0)
				(++ local34)
				(localproc_5 param1 param2)
				(local35
					guyCel: param1
					guyView: 909
					guyX: local36
					guyY: local37
				)
			)
		)
		(else
			(Print addText: 20 9 0 1 init:) ; "There is no one here."
		)
	)
)

(procedure (localproc_5 param1)
	(DrawCel
		906
		local0
		param1
		(= local36
			(switch param1
				(0
					(frameGuy1 x:)
				)
				(1
					(frameGuy2 x:)
				)
				(2
					(frameGuy3 x:)
				)
				(3
					(frameGuy4 x:)
				)
				(4
					(frameGuy5 x:)
				)
				(5
					(frameGuy6 x:)
				)
				(6
					(frameGuy7 x:)
				)
				(7
					(frameGuy8 x:)
				)
				(8
					(frameGuy9 x:)
				)
			)
		)
		(= local37
			(switch param1
				(0
					(frameGuy1 y:)
				)
				(1
					(frameGuy2 y:)
				)
				(2
					(frameGuy3 y:)
				)
				(3
					(frameGuy4 y:)
				)
				(4
					(frameGuy5 y:)
				)
				(5
					(frameGuy6 y:)
				)
				(6
					(frameGuy7 y:)
				)
				(7
					(frameGuy8 y:)
				)
				(8
					(frameGuy9 y:)
				)
			)
		)
		8
	)
	(= local35
		(cond
			((not (frameChoice1 occupied:)) frameChoice1)
			((not (frameChoice2 occupied:)) frameChoice2)
			((not (frameChoice3 occupied:)) frameChoice3)
		)
	)
	(local35 occupied: 1)
	(DrawCel
		(if (== local0 0) 908 else 909)
		10
		param1
		(local35 x:)
		(local35 y:)
		8
	)
)

(instance selectPlayers of Rm
	(properties
		picture 950
		style 10
	)

	(method (init &tmp temp0 temp1)
		(super init:)
		(gTheIconBar enable:)
		(gSound setLoop: 1)
		(gSound2 setLoop: 1)
		(for ((= temp0 0)) (<= temp0 83) ((++ temp0))
			(= [local0 temp0] 0)
		)
		(LoadMany rsVIEW 906 908 909)
		(= temp1 (PicNotValid))
		(PicNotValid 1)
		(= local34 0)
		(for ((= temp0 0)) (< temp0 9) ((++ temp0))
			(= [local1 temp0] 1)
			(= [local10 temp0] 1)
			(= [local19 9] 1)
			(if (< temp0 6)
				(= [local28 temp0] 0)
			)
		)
		(= local35 0)
		(= local36 0)
		(= local37 0)
		(things
			add:
				okButn
				showGuysButn
				name1
				name2
				name3
				name4
				name5
				name6
				name7
				name8
				name9
				frameGuy1
				frameGuy2
				frameGuy3
				frameGuy4
				frameGuy5
				frameGuy6
				frameGuy7
				frameGuy8
				frameGuy9
				frameChoice1
		)
		(frameChoice1 beingUsed: 0 occupied: 0)
		(frameChoice2 beingUsed: 0 occupied: 0)
		(frameChoice3 beingUsed: 0 occupied: 0)
		(switch global194
			(1
				(frameChoice1 x: 135 y: 145 beingUsed: 1 addKeyMouse:)
			)
			(3
				(frameChoice1 x: 83 y: 145 beingUsed: 1 addKeyMouse:)
				(frameChoice2 x: 135 y: 145 beingUsed: 1 addKeyMouse:)
				(frameChoice3 x: 187 y: 145 beingUsed: 1 addKeyMouse:)
			)
		)
		(if (or (== global193 800) (== global193 700))
			(DrawCel
				906
				5
				0
				(- (frameChoice2 x:) 1)
				(+ (frameChoice2 y:) 37)
				14
			)
		)
		(frameChoice1 init: stopUpd:)
		(DrawCel 906 0 9 (frameChoice1 x:) (frameChoice1 y:) 8)
		(if (> global194 1)
			(things add: frameChoice2)
			(frameChoice2 init: stopUpd:)
			(DrawCel 906 0 9 (frameChoice2 x:) (frameChoice2 y:) 8)
			(things add: frameChoice3)
			(frameChoice3 init: stopUpd:)
			(DrawCel 906 0 9 (frameChoice3 x:) (frameChoice3 y:) 8)
		)
		(localproc_1)
		(= local0 1)
		(okButn init: addKeyMouse:)
		(showGuysButn init: addKeyMouse:)
		(name1 init: addKeyMouse:)
		(name2 init: addKeyMouse:)
		(name3 init: addKeyMouse:)
		(name4 init: addKeyMouse:)
		(name5 init: addKeyMouse:)
		(name6 init: addKeyMouse:)
		(name7 init: addKeyMouse:)
		(name8 init: addKeyMouse:)
		(name9 init: addKeyMouse:)
		(frameGuy1 init: addKeyMouse:)
		(frameGuy2 init: addKeyMouse:)
		(frameGuy3 init: addKeyMouse:)
		(frameGuy4 init: addKeyMouse:)
		(frameGuy5 init: addKeyMouse:)
		(frameGuy6 init: addKeyMouse:)
		(frameGuy7 init: addKeyMouse:)
		(frameGuy8 init: addKeyMouse:)
		(frameGuy9 init: addKeyMouse:)
		(localproc_0)
	)

	(method (doit)
		(localproc_1)
		(super doit: &rest)
		(if global462
			(= gNewRoomNum (if (>= global387 1) 21 else global193))
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(things firstTrue: #handleEvent event)
	)

	(method (dispose)
		(things release: dispose:)
		((KeyMouse objList:) release:)
		(gSound setLoop: 1)
		(gSound2 setLoop: 1)
		(UnLoad 128 906)
		(UnLoad 128 909)
		(UnLoad 128 908)
		(UnLoad 128 907)
		(DisposeScript 922)
		(super dispose:)
	)
)

(instance things of List
	(properties)
)

(instance okButn of TrackingView
	(properties)

	(method (init)
		(self
			ignoreActors:
			view: 906
			setLoop: 4
			cel: 0
			posn: 240 155
			setPri: 9
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(if (super handleEvent: event)
			(event claimed: 1)
			(cond
				((== local34 global194)
					(= local38 -1)
					(= local39 -1)
					(= local40 -1)
					(= local41 -1)
					(= local42 -1)
					(= local43 -1)
					(= global195 -1)
					(= global196 -1)
					(= global197 -1)
					(= global198 -1)
					(if (== (frameChoice1 guyView:) 908)
						(= local38
							(switch global193
								(100 [local84 (frameChoice1 guyCel:)])
								(200 [local102 (frameChoice1 guyCel:)])
								(300 [local120 (frameChoice1 guyCel:)])
								(400 [local138 (frameChoice1 guyCel:)])
								(500 [local156 (frameChoice1 guyCel:)])
								(700 [local174 (frameChoice1 guyCel:)])
								(800 [local192 (frameChoice1 guyCel:)])
							)
						)
						(= local41 (frameChoice1 guyCel:))
					else
						(= local38
							(switch global193
								(100 [local93 (frameChoice1 guyCel:)])
								(200 [local111 (frameChoice1 guyCel:)])
								(300 [local129 (frameChoice1 guyCel:)])
								(400 [local147 (frameChoice1 guyCel:)])
								(500 [local165 (frameChoice1 guyCel:)])
								(700 [local183 (frameChoice1 guyCel:)])
								(800 [local201 (frameChoice1 guyCel:)])
							)
						)
						(= local41 (+ (frameChoice1 guyCel:) 9))
					)
					(gChar1 active: 1 view: [local210 local41])
					((gChar1 face:) view: [local210 local41])
					(if (> global194 1)
						(if (== (frameChoice2 guyView:) 908)
							(= local39
								(switch global193
									(100 [local84 (frameChoice2 guyCel:)])
									(200 [local102 (frameChoice2 guyCel:)])
									(300 [local120 (frameChoice2 guyCel:)])
									(400 [local138 (frameChoice2 guyCel:)])
									(500 [local156 (frameChoice2 guyCel:)])
									(700 [local174 (frameChoice2 guyCel:)])
									(800 [local192 (frameChoice2 guyCel:)])
								)
							)
							(= local42 (frameChoice2 guyCel:))
						else
							(= local39
								(switch global193
									(100 [local93 (frameChoice2 guyCel:)])
									(200 [local111 (frameChoice2 guyCel:)])
									(300 [local129 (frameChoice2 guyCel:)])
									(400 [local147 (frameChoice2 guyCel:)])
									(500 [local165 (frameChoice2 guyCel:)])
									(700 [local183 (frameChoice2 guyCel:)])
									(800 [local201 (frameChoice2 guyCel:)])
								)
							)
							(= local42 (+ (frameChoice2 guyCel:) 9))
						)
						(gChar2 active: 1 view: [local210 local42])
						((gChar2 face:) view: [local210 local42])
					else
						(gChar2 active: 0)
					)
					(if (> global194 1)
						(if (== (frameChoice3 guyView:) 908)
							(= local40
								(switch global193
									(100 [local84 (frameChoice3 guyCel:)])
									(200 [local102 (frameChoice3 guyCel:)])
									(300 [local120 (frameChoice3 guyCel:)])
									(400 [local138 (frameChoice3 guyCel:)])
									(500 [local156 (frameChoice3 guyCel:)])
									(700 [local174 (frameChoice3 guyCel:)])
									(800 [local192 (frameChoice3 guyCel:)])
								)
							)
							(= local43 (frameChoice3 guyCel:))
						else
							(= local40
								(switch global193
									(100 [local93 (frameChoice3 guyCel:)])
									(200 [local111 (frameChoice3 guyCel:)])
									(300 [local129 (frameChoice3 guyCel:)])
									(400 [local147 (frameChoice3 guyCel:)])
									(500 [local165 (frameChoice3 guyCel:)])
									(700 [local183 (frameChoice3 guyCel:)])
									(800 [local201 (frameChoice3 guyCel:)])
								)
							)
							(= local43 (+ (frameChoice3 guyCel:) 9))
						)
						(gChar3 active: 1 view: [local210 local43])
						((gChar3 face:) view: [local210 local43])
					else
						(gChar3 active: 0)
					)
					(= global195 2)
					(= global196 local38)
					(= global197 local39)
					(= global198 local40)
					(= temp0 (gChar1 view:))
					(gChar1 loop: 2)
					(= temp0 (gChar2 view:))
					(gChar2 loop: 2)
					(if
						(or
							(== (= temp0 (gChar3 view:)) 0)
							(== temp0 3)
							(== temp0 6)
							(== temp0 8)
						)
						(gChar3 loop: 3)
					else
						(gChar3 loop: 2)
					)
					(= gNewRoomNum (if (>= global387 1) 21 else global193))
				)
				((== global194 1)
					(Print addText: 19 7 1 1 init:) ; "You must choose one player."
				)
				(else
					(Print addText: 19 7 2 1 init:) ; "You must choose three players."
				)
			)
		)
		(event claimed:)
	)
)

(instance showGuysButn of TrackingView
	(properties)

	(method (init)
		(self
			ignoreActors:
			view: 906
			setLoop: 3
			cel: 0
			posn: 11 155
			setPri: 9
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if (== local0 0)
				(self setLoop: 2)
				(name1 view: 909)
				(name2 view: 909)
				(name3 view: 909)
				(name4 view: 909)
				(name5 view: 909)
				(name6 view: 909)
				(name7 view: 909)
				(name8 view: 909)
				(name9 view: 909)
				(localproc_0)
			else
				(self setLoop: 3)
				(name1 view: 908)
				(name2 view: 908)
				(name3 view: 908)
				(name4 view: 908)
				(name5 view: 908)
				(name6 view: 908)
				(name7 view: 908)
				(name8 view: 908)
				(name9 view: 908)
				(localproc_0)
			)
		)
		(event claimed:)
	)
)

(instance frameGuy1 of TrackingView
	(properties)

	(method (init)
		(self
			offsetY: 39
			ignoreActors:
			view: 907
			setLoop: 1
			cel: 0
			posn: 18 12
			setPri: 9
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_4 0 self)
		)
		(event claimed:)
	)
)

(instance frameGuy2 of TrackingView
	(properties)

	(method (init)
		(self
			offsetY: 41
			ignoreActors:
			view: 907
			setLoop: 2
			cel: 0
			posn: 93 10
			setPri: 9
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_4 1 self)
		)
		(event claimed:)
	)
)

(instance frameGuy3 of TrackingView
	(properties)

	(method (init)
		(self
			offsetY: 41
			ignoreActors:
			view: 907
			setLoop: 3
			cel: 0
			posn: 167 10
			setPri: 9
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_4 2 self)
		)
		(event claimed:)
	)
)

(instance frameGuy4 of TrackingView
	(properties)

	(method (init)
		(self
			offsetY: 45
			ignoreActors:
			view: 907
			setLoop: 4
			cel: 0
			posn: 246 11
			setPri: 9
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_4 3 self)
		)
		(event claimed:)
	)
)

(instance frameGuy5 of TrackingView
	(properties)

	(method (init)
		(self
			offsetY: 44
			ignoreActors:
			view: 907
			setLoop: 5
			cel: 0
			posn: 187 75
			setPri: 9
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_4 4 self)
		)
		(event claimed:)
	)
)

(instance frameGuy6 of TrackingView
	(properties)

	(method (init)
		(self
			offsetY: 41
			ignoreActors:
			view: 907
			setLoop: 6
			cel: 0
			posn: 69 80
			setPri: 9
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_4 5 self)
		)
		(event claimed:)
	)
)

(instance frameGuy7 of TrackingView
	(properties)

	(method (init)
		(self
			offsetY: 46
			ignoreActors:
			view: 907
			setLoop: 7
			cel: 0
			posn: 127 73
			setPri: 9
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_4 6 self)
		)
		(event claimed:)
	)
)

(instance frameGuy8 of TrackingView
	(properties)

	(method (init)
		(self
			offsetY: 43
			ignoreActors:
			view: 907
			setLoop: 8
			cel: 0
			posn: 6 84
			setPri: 9
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_4 7 self)
		)
		(event claimed:)
	)
)

(instance frameGuy9 of TrackingView
	(properties)

	(method (init)
		(self
			offsetY: 38
			offsetX: 25
			ignoreActors:
			view: 907
			setLoop: 9
			cel: 0
			posn: 257 87
			setPri: 9
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_4 8 self)
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
		beingUsed 0
		playerName 0
	)
)

(instance frameChoice1 of Choice
	(properties)

	(method (init)
		(self
			ignoreActors:
			view: 907
			setLoop: 11
			cel: 0
			posn: x y
			setPri: 8
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(DrawCel 906 0 9 x y 8)
			(if occupied
				(= occupied 0)
				(cond
					((== local0 0)
						(if (== guyView 908)
							(DrawCel 908 0 guyCel guyX guyY 8)
							(= [local1 guyCel] 1)
						else
							(= [local10 guyCel] 1)
						)
					)
					((== guyView 909)
						(DrawCel 909 0 guyCel guyX guyY 8)
						(= [local10 guyCel] 1)
					)
					(else
						(= [local1 guyCel] 1)
					)
				)
				(-- local34)
			else
				(Print addText: 21 10 0 1 init:) ; "Choose a player."
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
			view: 907
			setLoop: 11
			cel: 0
			posn: x y
			setPri: 8
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(DrawCel 906 0 9 x y 8)
			(if occupied
				(= occupied 0)
				(cond
					((== local0 0)
						(if (== guyView 908)
							(DrawCel 908 0 guyCel guyX guyY 8)
							(= [local1 guyCel] 1)
						else
							(= [local10 guyCel] 1)
						)
					)
					((== guyView 909)
						(DrawCel 909 0 guyCel guyX guyY 8)
						(= [local10 guyCel] 1)
					)
					(else
						(= [local1 guyCel] 1)
					)
				)
				(-- local34)
			else
				(Print addText: 21 10 0 1 init:) ; "Choose a player."
			)
		)
		(event claimed:)
	)
)

(instance frameChoice3 of Choice
	(properties)

	(method (init)
		(self
			ignoreActors:
			view: 907
			setLoop: 11
			cel: 0
			posn: x y
			setPri: 8
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(DrawCel 906 0 9 x y 8)
			(if occupied
				(= occupied 0)
				(cond
					((== local0 0)
						(if (== guyView 908)
							(DrawCel 908 0 guyCel guyX guyY 8)
							(= [local1 guyCel] 1)
						else
							(= [local10 guyCel] 1)
						)
					)
					((== guyView 909)
						(DrawCel 909 0 guyCel guyX guyY 8)
						(= [local10 guyCel] 1)
					)
					(else
						(= [local1 guyCel] 1)
					)
				)
				(-- local34)
			else
				(Print addText: 21 10 0 1 init:) ; "Choose a player."
			)
		)
		(event claimed:)
	)
)

(class NamePlate of TrackingView
	(properties)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(if (== local0 0)
				(self sierraText:)
			else
				(self classicText:)
			)
			(event claimed: 1)
		)
		(event claimed:)
	)

	(method (sierraText)
		(return 1)
	)

	(method (classicText)
		(return 1)
	)
)

(instance name1 of NamePlate
	(properties
		view 908
		loop 1
		priority 10
	)

	(method (init)
		(self
			ignoreActors:
			setLoop: loop
			posn: 20 57
			setPri: priority
			associatedObj: frameGuy1
			stopUpd:
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_3
			4
			(switch global193
				(100 3)
				(200 3)
				(300 5)
				(400 5)
				(500 6)
				(700 6)
				(800 3)
			)
		)
	)

	(method (classicText)
		(localproc_3
			28
			(switch global193
				(100 5)
				(200 6)
				(300 5)
				(400 6)
				(500 6)
				(700 5)
				(800 3)
			)
		)
	)
)

(instance name2 of NamePlate
	(properties
		view 908
		loop 2
		priority 10
	)

	(method (init)
		(self
			ignoreActors:
			setLoop: loop
			posn: 96 57
			setPri: priority
			associatedObj: frameGuy2
			stopUpd:
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_3
			25
			(switch global193
				(100 6)
				(200 5)
				(300 6)
				(400 5)
				(500 3)
				(700 3)
				(800 6)
			)
		)
	)

	(method (classicText)
		(localproc_3
			29
			(switch global193
				(100 5)
				(200 5)
				(300 6)
				(400 6)
				(500 3)
				(700 3)
				(800 3)
			)
		)
	)
)

(instance name3 of NamePlate
	(properties
		view 908
		loop 3
		priority 10
	)

	(method (init)
		(self
			ignoreActors:
			setLoop: loop
			posn: 160 56
			setPri: priority
			associatedObj: frameGuy3
			stopUpd:
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_3
			24
			(switch global193
				(100 5)
				(200 5)
				(300 3)
				(400 3)
				(500 6)
				(700 3)
				(800 5)
			)
		)
	)

	(method (classicText)
		(localproc_3
			30
			(switch global193
				(100 6)
				(200 3)
				(300 5)
				(400 3)
				(500 5)
				(700 6)
				(800 5)
			)
		)
	)
)

(instance name4 of NamePlate
	(properties
		view 908
		loop 4
		priority 10
	)

	(method (init)
		(self
			ignoreActors:
			setLoop: loop
			posn: 251 64
			setPri: priority
			associatedObj: frameGuy4
			stopUpd:
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_3
			6
			(switch global193
				(100 3)
				(200 3)
				(300 5)
				(400 3)
				(500 6)
				(700 6)
				(800 5)
			)
		)
	)

	(method (classicText)
		(localproc_3
			31
			(switch global193
				(100 3)
				(200 6)
				(300 6)
				(400 5)
				(500 3)
				(700 5)
				(800 6)
			)
		)
	)
)

(instance name5 of NamePlate
	(properties
		view 908
		loop 8
		priority 10
	)

	(method (init)
		(self
			ignoreActors:
			setLoop: loop
			posn: 2 131
			setPri: priority
			associatedObj: frameGuy8
			stopUpd:
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_3
			23
			(switch global193
				(100 6)
				(200 6)
				(300 3)
				(400 5)
				(500 3)
				(700 5)
				(800 6)
			)
		)
	)

	(method (classicText)
		(localproc_3
			35
			(switch global193
				(100 3)
				(200 6)
				(300 5)
				(400 6)
				(500 3)
				(700 5)
				(800 5)
			)
		)
	)
)

(instance name6 of NamePlate
	(properties
		view 908
		loop 6
		priority 10
	)

	(method (init)
		(self
			ignoreActors:
			setLoop: loop
			posn: 71 124
			setPri: priority
			associatedObj: frameGuy6
			stopUpd:
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_3
			5
			(switch global193
				(100 6)
				(200 3)
				(300 6)
				(400 3)
				(500 5)
				(700 5)
				(800 3)
			)
		)
	)

	(method (classicText)
		(localproc_3
			33
			(switch global193
				(100 5)
				(200 3)
				(300 6)
				(400 6)
				(500 5)
				(700 3)
				(800 3)
			)
		)
	)
)

(instance name7 of NamePlate
	(properties
		view 908
		loop 7
		priority 10
	)

	(method (init)
		(self
			ignoreActors:
			setLoop: loop
			posn: 129 124
			setPri: priority
			associatedObj: frameGuy7
			stopUpd:
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_3
			26
			(switch global193
				(100 3)
				(200 5)
				(300 6)
				(400 5)
				(500 5)
				(700 3)
				(800 6)
			)
		)
	)

	(method (classicText)
		(localproc_3
			34
			(switch global193
				(100 5)
				(200 5)
				(300 3)
				(400 6)
				(500 6)
				(700 3)
				(800 6)
			)
		)
	)
)

(instance name8 of NamePlate
	(properties
		view 908
		loop 5
		priority 10
	)

	(method (init)
		(self
			ignoreActors:
			setLoop: loop
			posn: 182 124
			setPri: priority
			associatedObj: frameGuy5
			stopUpd:
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_3
			9
			(switch global193
				(100 5)
				(200 5)
				(300 3)
				(400 6)
				(500 3)
				(700 6)
				(800 3)
			)
		)
	)

	(method (classicText)
		(localproc_3
			32
			(switch global193
				(100 6)
				(200 6)
				(300 3)
				(400 3)
				(500 5)
				(700 6)
				(800 5)
			)
		)
	)
)

(instance name9 of NamePlate
	(properties
		view 908
		loop 9
		priority 10
	)

	(method (init)
		(self
			ignoreActors:
			setLoop: loop
			posn: 250 132
			setPri: priority
			associatedObj: frameGuy9
			stopUpd:
		)
		(super init: &rest)
	)

	(method (sierraText)
		(localproc_3
			27
			(switch global193
				(100 6)
				(200 6)
				(300 3)
				(400 3)
				(500 6)
				(700 5)
				(800 5)
			)
		)
	)

	(method (classicText)
		(localproc_3
			36
			(switch global193
				(100 3)
				(200 3)
				(300 5)
				(400 5)
				(500 5)
				(700 6)
				(800 6)
			)
		)
	)
)

