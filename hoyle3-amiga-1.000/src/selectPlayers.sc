;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Interface)
(use Game)
(use Actor)
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
	[local84 9] = [0 1 1 1 0 2 0 0 1]
	[local93 9] = [2 1 0 2 2 2 2 1 0]
	[local102 9] = [0 1 2 2 1 2 1 1 2]
	[local111 9] = [0 0 2 1 2 1 0 1 0]
	[local120 9] = [1 2 1 1 2 0 2 0 0]
	[local129 9] = [1 0 1 2 2 0 1 0 2]
	[local138 9] = [2 1 0 2 1 0 1 2 1]
	[local147 9] = [0 2 0 0 2 0 1 2 1]
	[local156 9] = [1 0 2 1 0 2 1 0 0]
	[local165 9] = [0 1 1 1 2 2 2 0 2]
	[local174 18] = [8 4 2 3 1 5 6 7 0 11 14 16 13 9 15 10 12 17]
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(= temp1 (if (== (= local0 (if (== local0 0) 1 else 0)) 0) 0 else 1))
	(= temp0 (if (== local0 0) 801 else 802))
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
		(DrawCel temp0 0 0 30 23 8)
	else
		(DrawCel 800 temp1 0 30 23 8)
	)
	(if [local19 1]
		(DrawCel temp0 0 1 87 23 8)
	else
		(DrawCel 800 temp1 1 87 23 8)
	)
	(if [local19 2]
		(DrawCel temp0 0 2 144 23 8)
	else
		(DrawCel 800 temp1 2 144 23 8)
	)
	(if [local19 3]
		(DrawCel temp0 0 3 201 23 8)
	else
		(DrawCel 800 temp1 3 201 23 8)
	)
	(if [local19 4]
		(DrawCel temp0 0 4 258 23 8)
	else
		(DrawCel 800 temp1 4 258 23 8)
	)
	(if [local19 5]
		(DrawCel temp0 0 5 62 86 8)
	else
		(DrawCel 800 temp1 5 62 86 8)
	)
	(if [local19 6]
		(DrawCel temp0 0 6 119 86 8)
	else
		(DrawCel 800 temp1 6 119 86 8)
	)
	(if [local19 7]
		(DrawCel temp0 0 7 176 86 8)
	else
		(DrawCel 800 temp1 7 176 86 8)
	)
	(if [local19 8]
		(DrawCel temp0 0 8 233 86 8)
	else
		(DrawCel 800 temp1 8 233 86 8)
	)
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

(procedure (localproc_2 param1)
	(switch param1
		(0
			(Format @local44 98 40) ; "M. Goose"
		)
		(1
			(Format @local44 98 41) ; "Roger"
		)
		(2
			(Format @local44 98 42) ; "Rosella"
		)
		(3
			(Format @local44 98 43) ; "Graham"
		)
		(4
			(Format @local44 98 44) ; "Laura"
		)
		(5
			(Format @local44 98 45) ; "Larry"
		)
		(6
			(Format @local44 98 46) ; "Patty"
		)
		(7
			(Format @local44 98 47) ; "Jones"
		)
		(8
			(Format @local44 98 48) ; "Sonny"
		)
		(9
			(Format @local44 98 49) ; "Adavis"
		)
		(10
			(Format @local44 98 50) ; "Lillian"
		)
		(11
			(Format @local44 98 51) ; "Mr. Big"
		)
		(12
			(Format @local44 98 52) ; "Arnoid"
		)
		(13
			(Format @local44 98 53) ; "Vohaul"
		)
		(14
			(Format @local44 98 54) ; "Baba Yaga"
		)
		(15
			(Format @local44 98 55) ; "Mordack"
		)
		(16
			(Format @local44 98 56) ; "Lolotte"
		)
		(17
			(Format @local44 98 57) ; "Sheriff"
		)
	)
	(return @local44)
)

(procedure (localproc_3 param1 param2)
	(cond
		((== local0 0)
			(if [local1 param1]
				(if (== local34 global189)
					(gSound play: 902)
					(Print 98 27) ; "That would make too many players."
				else
					(gSound play: 901)
					(= [local1 param1] 0)
					(++ local34)
					(localproc_4 param1 param2)
					(local35
						guyCel: param1
						guyView: 801
						guyX: local36
						guyY: local37
					)
				)
			else
				(gSound play: 902)
				(Print 98 28) ; "There is nobody here."
			)
		)
		([local10 param1]
			(if (== local34 global189)
				(gSound play: 902)
				(Print 98 27) ; "That would make too many players."
			else
				(gSound play: 901)
				(= [local10 param1] 0)
				(++ local34)
				(localproc_4 param1 param2)
				(local35
					guyCel: param1
					guyView: 802
					guyX: local36
					guyY: local37
				)
			)
		)
		(else
			(gSound play: 902)
			(Print 98 28) ; "There is nobody here."
		)
	)
)

(procedure (localproc_4 param1)
	(DrawCel
		800
		local0
		param1
		(= local36
			(switch param1
				(0 30)
				(1 87)
				(2 144)
				(3 201)
				(4 258)
				(5 62)
				(6 119)
				(7 176)
				(8 233)
			)
		)
		(= local37
			(switch param1
				(0 23)
				(1 23)
				(2 23)
				(3 23)
				(4 23)
				(5 86)
				(6 86)
				(7 86)
				(8 86)
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
		(if (== local0 0) 801 else 802)
		0
		param1
		(- (local35 x:) 17)
		(- (local35 y:) 38)
		8
	)
)

(instance selectPlayers of Rm
	(properties
		picture 800
		style 10
	)

	(method (init &tmp temp0)
		(super init:)
		(gTheIconBar enable:)
		(gSound setLoop: 1)
		(gSound2 setLoop: 1)
		(for ((= temp0 0)) (<= temp0 83) ((++ temp0))
			(= [local0 temp0] 0)
		)
		(Load rsVIEW 800)
		(Load rsVIEW 801)
		(Load rsVIEW 802)
		(Load rsSOUND 901)
		(Load rsSOUND 902)
		(Load rsSOUND 900)
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
				frameGuy1
				frameGuy2
				frameGuy3
				frameGuy4
				frameGuy5
				frameGuy6
				frameGuy7
				frameGuy8
				frameGuy9
				name1
				name2
				name3
				name4
				name5
				name6
				name7
				name8
				name9
				frameChoice1
		)
		(frameChoice1 beingUsed: 0 occupied: 0)
		(frameChoice2 beingUsed: 0 occupied: 0)
		(frameChoice3 beingUsed: 0 occupied: 0)
		(switch global189
			(1
				(frameChoice1 x: 162 y: 193 beingUsed: 1 addKeyMouse:)
			)
			(2
				(frameChoice1 x: 130 y: 193 beingUsed: 1 addKeyMouse:)
				(frameChoice2 x: 190 y: 193 beingUsed: 1 addKeyMouse:)
			)
			(3
				(frameChoice1 x: 112 y: 193 beingUsed: 1 addKeyMouse:)
				(frameChoice2 x: 162 y: 193 beingUsed: 1 addKeyMouse:)
				(frameChoice3 x: 212 y: 193 beingUsed: 1 addKeyMouse:)
			)
		)
		(frameChoice1 init: stopUpd:)
		(DrawCel 800 1 1 (- (frameChoice1 x:) 17) (- (frameChoice1 y:) 38) 8)
		(if (> global189 1)
			(things add: frameChoice2)
			(frameChoice2 init: stopUpd:)
			(DrawCel
				800
				1
				1
				(- (frameChoice2 x:) 17)
				(- (frameChoice2 y:) 38)
				8
			)
		)
		(if (> global189 2)
			(things add: frameChoice3)
			(frameChoice3 init: stopUpd:)
			(DrawCel
				800
				1
				1
				(- (frameChoice3 x:) 17)
				(- (frameChoice3 y:) 38)
				8
			)
		)
		(localproc_1)
		(= local0 1)
		(localproc_0)
		(okButn init: addKeyMouse:)
		(showGuysButn init: addKeyMouse:)
		(frameGuy1 init: addKeyMouse:)
		(frameGuy2 init: addKeyMouse:)
		(frameGuy3 init: addKeyMouse:)
		(frameGuy4 init: addKeyMouse:)
		(frameGuy5 init: addKeyMouse:)
		(frameGuy6 init: addKeyMouse:)
		(frameGuy7 init: addKeyMouse:)
		(frameGuy8 init: addKeyMouse:)
		(frameGuy9 init: addKeyMouse:)
		(name1 init: addKeyMouse:)
		(name2 init: addKeyMouse:)
		(name3 init: addKeyMouse:)
		(name4 init: addKeyMouse:)
		(name5 init: addKeyMouse:)
		(name6 init: addKeyMouse:)
		(name7 init: addKeyMouse:)
		(name8 init: addKeyMouse:)
		(name9 init: addKeyMouse:)
		(instruction loop: global295 init:)
	)

	(method (doit)
		(localproc_1)
		(super doit: &rest)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(things firstTrue: #handleEvent event)
	)

	(method (dispose)
		(things release: dispose:)
		((KeyMouse objList:) release:)
		(gSong setLoop: 1)
		(gSound setLoop: 1)
		(gSound2 setLoop: 1)
		(super dispose:)
	)
)

(instance things of List
	(properties)
)

(instance okButn of TrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 800 setLoop: 5 cel: 0 posn: 278 193 setPri: 9)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if (== local34 global189)
				(gSound play: 900)
				(= local38 -1)
				(= local39 -1)
				(= local40 -1)
				(= local41 -1)
				(= local42 -1)
				(= local43 -1)
				(= global190 -1)
				(= global191 -1)
				(= global192 -1)
				(= global193 -1)
				(if (frameChoice1 beingUsed:)
					(if (== (frameChoice1 guyView:) 801)
						(= local38
							(switch global187
								(100 [local84 (frameChoice1 guyCel:)])
								(300 [local120 (frameChoice1 guyCel:)])
								(400 [local156 (frameChoice1 guyCel:)])
								(200 [local102 (frameChoice1 guyCel:)])
								(500 [local138 (frameChoice1 guyCel:)])
							)
						)
						(= local41 (frameChoice1 guyCel:))
					else
						(= local38
							(switch global187
								(100 [local93 (frameChoice1 guyCel:)])
								(300 [local129 (frameChoice1 guyCel:)])
								(400 [local165 (frameChoice1 guyCel:)])
								(200 [local111 (frameChoice1 guyCel:)])
								(500 [local147 (frameChoice1 guyCel:)])
							)
						)
						(= local41 (+ (frameChoice1 guyCel:) 9))
					)
					(gChar1 active: 1 view: [local174 local41])
					((gChar1 face:) view: [local174 local41])
				)
				(if (frameChoice2 beingUsed:)
					(if (== (frameChoice2 guyView:) 801)
						(= local39
							(switch global187
								(100 [local84 (frameChoice2 guyCel:)])
								(300 [local120 (frameChoice2 guyCel:)])
								(400 [local156 (frameChoice2 guyCel:)])
								(200 [local102 (frameChoice2 guyCel:)])
								(500 [local138 (frameChoice2 guyCel:)])
							)
						)
						(= local42 (frameChoice2 guyCel:))
					else
						(= local39
							(switch global187
								(100 [local93 (frameChoice2 guyCel:)])
								(300 [local129 (frameChoice2 guyCel:)])
								(400 [local165 (frameChoice2 guyCel:)])
								(200 [local111 (frameChoice2 guyCel:)])
								(500 [local147 (frameChoice2 guyCel:)])
							)
						)
						(= local42 (+ (frameChoice2 guyCel:) 9))
					)
					(gChar2 active: 1 view: [local174 local42])
					((gChar2 face:) view: [local174 local42])
				else
					(gChar2 active: 0)
				)
				(if (frameChoice3 beingUsed:)
					(if (== (frameChoice3 guyView:) 801)
						(= local40
							(switch global187
								(100 [local84 (frameChoice3 guyCel:)])
								(300 [local120 (frameChoice3 guyCel:)])
								(400 [local156 (frameChoice3 guyCel:)])
								(200 [local102 (frameChoice3 guyCel:)])
								(500 [local138 (frameChoice3 guyCel:)])
							)
						)
						(= local43 (frameChoice3 guyCel:))
					else
						(= local40
							(switch global187
								(100 [local93 (frameChoice3 guyCel:)])
								(300 [local129 (frameChoice3 guyCel:)])
								(400 [local165 (frameChoice3 guyCel:)])
								(200 [local111 (frameChoice3 guyCel:)])
								(500 [local147 (frameChoice3 guyCel:)])
							)
						)
						(= local43 (+ (frameChoice3 guyCel:) 9))
					)
					(gChar3 active: 1 view: [local174 local43])
					((gChar3 face:) view: [local174 local43])
				else
					(gChar3 active: 0)
				)
				(cond
					((== global194 2)
						(= global190 local38)
						(Format @global150 3 0 (localproc_2 local41)) ; "%s"
						(cond
							((== global195 2)
								(= global191 local39)
								(Format @global157 3 0 (localproc_2 local42)) ; "%s"
								(cond
									((== global196 2)
										(= global192 local40)
										(Format ; "%s"
											@global164
											3
											0
											(localproc_2 local43)
										)
									)
									((== global197 2)
										(= global193 local40)
										(Format ; "%s"
											@global171
											3
											0
											(localproc_2 local43)
										)
									)
								)
							)
							((== global196 2)
								(= global192 local39)
								(Format @global164 3 0 (localproc_2 local42)) ; "%s"
								(if (== global197 2)
									(= global193 local40)
									(Format @global171 3 0 (localproc_2 local43)) ; "%s"
								)
							)
							((== global197 2)
								(= global193 local39)
								(Format @global171 3 0 (localproc_2 local42)) ; "%s"
							)
						)
					)
					((== global195 2)
						(= global191 local38)
						(Format @global157 3 0 (localproc_2 local41)) ; "%s"
						(cond
							((== global196 2)
								(= global192 local39)
								(Format @global164 3 0 (localproc_2 local42)) ; "%s"
								(if (== global197 2)
									(= global193 local40)
									(Format @global171 3 0 (localproc_2 local43)) ; "%s"
								)
							)
							((== global197 2)
								(= global193 local39)
								(Format @global171 3 0 (localproc_2 local42)) ; "%s"
							)
						)
					)
					((== global196 2)
						(= global192 local38)
						(Format @global164 3 0 (localproc_2 local41)) ; "%s"
						(if (== global197 2)
							(= global193 local39)
							(Format @global171 3 0 (localproc_2 local42)) ; "%s"
						)
					)
					((== global197 2)
						(= global193 local38)
						(Format @global171 3 0 (localproc_2 local41)) ; "%s"
					)
				)
				(= gNewRoomNum global187)
			else
				(gSound play: 902)
				(Print 98 25) ; "You must select more players"
			)
		)
		(event claimed:)
	)
)

(instance showGuysButn of TrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 800 setLoop: 4 cel: 0 posn: 41 194 setPri: 9)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gSound play: 900)
			(event claimed: 1)
			(if (== local0 0)
				(self setLoop: 3)
				(name1 view: 802)
				(name2 view: 802)
				(name3 view: 802)
				(name4 view: 802)
				(name5 view: 802)
				(name6 view: 802)
				(name7 view: 802)
				(name8 view: 802)
				(name9 view: 802)
				(proc0_1)
				(localproc_0)
			else
				(self setLoop: (if (not (Random 0 1000)) 15 else 4))
				(name1 view: 801)
				(name2 view: 801)
				(name3 view: 801)
				(name4 view: 801)
				(name5 view: 801)
				(name6 view: 801)
				(name7 view: 801)
				(name8 view: 801)
				(name9 view: 801)
				(proc0_1)
				(localproc_0)
			)
		)
		(event claimed:)
	)
)

(instance frameGuy1 of TrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 800 setLoop: 2 cel: 0 posn: 47 61 setPri: 9)
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

(instance frameGuy2 of TrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 800 setLoop: 2 cel: 0 posn: 104 61 setPri: 9)
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

(instance frameGuy3 of TrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 800 setLoop: 2 cel: 0 posn: 161 61 setPri: 9)
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

(instance frameGuy4 of TrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 800 setLoop: 2 cel: 0 posn: 218 61 setPri: 9)
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

(instance frameGuy5 of TrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 800 setLoop: 2 cel: 0 posn: 275 61 setPri: 9)
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

(instance frameGuy6 of TrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 800 setLoop: 2 cel: 0 posn: 79 124 setPri: 9)
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

(instance frameGuy7 of TrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 800 setLoop: 2 cel: 0 posn: 136 124 setPri: 9)
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

(instance frameGuy8 of TrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 800 setLoop: 2 cel: 0 posn: 193 124 setPri: 9)
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

(instance frameGuy9 of TrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 800 setLoop: 2 cel: 0 posn: 250 124 setPri: 9)
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
		(self ignoreActors: view: 800 setLoop: 2 cel: 0 posn: x y setPri: 8)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(DrawCel 800 1 1 (- x 17) (- y 38) 8)
			(gSound play: 902)
			(if occupied
				(= occupied 0)
				(cond
					((== local0 0)
						(if (== guyView 801)
							(DrawCel 801 0 guyCel guyX guyY 8)
							(= [local1 guyCel] 1)
						else
							(= [local10 guyCel] 1)
						)
					)
					((== guyView 802)
						(DrawCel 802 0 guyCel guyX guyY 8)
						(= [local10 guyCel] 1)
					)
					(else
						(= [local1 guyCel] 1)
					)
				)
				(-- local34)
			else
				(Print 98 26) ; "Select an opponent from above."
			)
		)
		(event claimed:)
	)
)

(instance frameChoice2 of Choice
	(properties)

	(method (init)
		(self ignoreActors: view: 800 setLoop: 2 cel: 0 posn: x y setPri: 8)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(DrawCel 800 1 1 (- x 17) (- y 38) 8)
			(gSound play: 902)
			(if occupied
				(= occupied 0)
				(cond
					((== local0 0)
						(if (== guyView 801)
							(DrawCel 801 0 guyCel guyX guyY 8)
							(= [local1 guyCel] 1)
						else
							(= [local10 guyCel] 1)
						)
					)
					((== guyView 802)
						(DrawCel 802 0 guyCel guyX guyY 8)
						(= [local10 guyCel] 1)
					)
					(else
						(= [local1 guyCel] 1)
					)
				)
				(-- local34)
			else
				(Print 98 26) ; "Select an opponent from above."
			)
		)
		(event claimed:)
	)
)

(instance frameChoice3 of Choice
	(properties)

	(method (init)
		(self ignoreActors: view: 800 setLoop: 2 cel: 0 posn: x y setPri: 8)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(DrawCel 800 1 1 (- x 17) (- y 38) 8)
			(gSound play: 902)
			(if occupied
				(= occupied 0)
				(cond
					((== local0 0)
						(if (== guyView 801)
							(DrawCel 801 0 guyCel guyX guyY 8)
							(= [local1 guyCel] 1)
						else
							(= [local10 guyCel] 1)
						)
					)
					((== guyView 802)
						(DrawCel 802 0 guyCel guyX guyY 8)
						(= [local10 guyCel] 1)
					)
					(else
						(= [local1 guyCel] 1)
					)
				)
				(-- local34)
			else
				(Print 98 26) ; "Select an opponent from above."
			)
		)
		(event claimed:)
	)
)

(class NamePlate of TrackingView
	(properties)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(gSound play: 900)
			(if (== local0 0)
				(self goodText:)
			else
				(self badText:)
			)
		)
		(event claimed:)
	)

	(method (goodText)
		(return 1)
	)

	(method (badText)
		(return 1)
	)
)

(instance name1 of NamePlate
	(properties
		view 801
		loop 1
		priority 10
	)

	(method (init)
		(self ignoreActors: setLoop: loop posn: 47 77 setPri: priority)
		(super init: &rest)
	)

	(method (goodText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 58)) ; "%s", "Mother Goose"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
		)
		(Print @temp60 #mode 1)
	)

	(method (badText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 49)) ; "%s", "Adavis"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
		)
		(Print @temp60 #mode 1)
	)
)

(instance name2 of NamePlate
	(properties
		view 801
		loop 2
		priority 10
	)

	(method (init)
		(self ignoreActors: setLoop: loop posn: 104 77 setPri: priority)
		(super init: &rest)
	)

	(method (goodText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 41)) ; "%s", "Roger"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
		)
		(Print @temp60 #mode 1)
	)

	(method (badText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 50)) ; "%s", "Lillian"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
		)
		(Print @temp60 #mode 1)
	)
)

(instance name3 of NamePlate
	(properties
		view 801
		loop 3
		priority 10
	)

	(method (init)
		(self ignoreActors: setLoop: loop posn: 161 77 setPri: priority)
		(super init: &rest)
	)

	(method (goodText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 42)) ; "%s", "Rosella"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
		)
		(Print @temp60 #mode 1)
	)

	(method (badText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 51)) ; "%s", "Mr. Big"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
		)
		(Print @temp60 #mode 1)
	)
)

(instance name4 of NamePlate
	(properties
		view 801
		loop 4
		priority 10
	)

	(method (init)
		(self ignoreActors: setLoop: loop posn: 218 77 setPri: priority)
		(super init: &rest)
	)

	(method (goodText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 43)) ; "%s", "Graham"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
		)
		(Print @temp60 #mode 1)
	)

	(method (badText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 52)) ; "%s", "Arnoid"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
		)
		(Print @temp60 #mode 1)
	)
)

(instance name5 of NamePlate
	(properties
		view 801
		loop 5
		priority 10
	)

	(method (init)
		(self ignoreActors: setLoop: loop posn: 275 77 setPri: priority)
		(super init: &rest)
	)

	(method (goodText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 44)) ; "%s", "Laura"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
		)
		(Print @temp60 #mode 1)
	)

	(method (badText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 53)) ; "%s", "Vohaul"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
		)
		(Print @temp60 #mode 1)
	)
)

(instance name6 of NamePlate
	(properties
		view 801
		loop 6
		priority 10
	)

	(method (init)
		(self ignoreActors: setLoop: loop posn: 79 140 setPri: priority)
		(super init: &rest)
	)

	(method (goodText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 45)) ; "%s", "Larry"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
		)
		(Print @temp60 #mode 1)
	)

	(method (badText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 54)) ; "%s", "Baba Yaga"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
		)
		(Print @temp60 #mode 1)
	)
)

(instance name7 of NamePlate
	(properties
		view 801
		loop 7
		priority 10
	)

	(method (init)
		(self ignoreActors: setLoop: loop posn: 136 140 setPri: priority)
		(super init: &rest)
	)

	(method (goodText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 46)) ; "%s", "Patty"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
		)
		(Print @temp60 #mode 1)
	)

	(method (badText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 55)) ; "%s", "Mordack"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
		)
		(Print @temp60 #mode 1)
	)
)

(instance name8 of NamePlate
	(properties
		view 801
		loop 8
		priority 10
	)

	(method (init)
		(self ignoreActors: setLoop: loop posn: 193 140 setPri: priority)
		(super init: &rest)
	)

	(method (goodText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 47)) ; "%s", "Jones"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
		)
		(Print @temp60 #mode 1)
	)

	(method (badText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 56)) ; "%s", "Lolotte"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
		)
		(Print @temp60 #mode 1)
	)
)

(instance name9 of NamePlate
	(properties
		view 801
		loop 9
		priority 10
	)

	(method (init)
		(self ignoreActors: setLoop: loop posn: 250 140 setPri: priority)
		(super init: &rest)
	)

	(method (goodText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 48)) ; "%s", "Sonny"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
		)
		(Print @temp60 #mode 1)
	)

	(method (badText &tmp [temp0 30] [temp30 30] [temp60 40])
		(Format @temp60 98 59 (Format @temp0 98 57)) ; "%s", "Sheriff"
		(switch global187
			(100
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(200
				(StrCat @temp60 (Format @temp30 98 60)) ; "BEGINNER"
			)
			(300
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
			(500
				(StrCat @temp60 (Format @temp30 98 61)) ; "AVERAGE"
			)
			(400
				(StrCat @temp60 (Format @temp30 98 62)) ; "EXPERT"
			)
		)
		(Print @temp60 #mode 1)
	)
)

(instance instruction of View
	(properties
		x 160
		y 11
		view 800
		loop 6
		priority 9
	)

	(method (init)
		(self ignoreActors: setLoop: loop posn: x y setPri: priority)
		(super init: &rest)
	)
)

