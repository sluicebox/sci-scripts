;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Window)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm012 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm012 of Rm
	(properties
		picture 12
		style 0
		horizon 100
		east 13
		south 19
		west 11
	)

	(method (init)
		(Load rsSOUND 17)
		(Load rsSOUND 43)
		(Load rsSOUND 44)
		(Load rsSOUND 41)
		(Load rsSOUND 27)
		(Load rsVIEW 77)
		(Load rsVIEW 41)
		(Load rsVIEW 125)
		(Load rsVIEW 300)
		(Load rsVIEW 133)
		(Load rsVIEW 39)
		(super init:)
		(= global207 0)
		(= global125 -1)
		(door init: stopUpd:)
		(switch gPrevRoomNum
			(6
				(= global125 5)
				(gEgo setPri: 5 x: 309 y: 108)
			)
			(11
				(gEgo y: (+ (/ (* (- (gEgo y:) 137) 16) 52) 173))
			)
			(5
				(= global125 5)
				(gEgo setPri: 5 x: 309 y: 108)
			)
			(13
				(= global125 5)
				(gEgo setPri: 5 x: 309 y: 108)
			)
			(19
				(cond
					((> (gEgo x:) 167)
						(= global125 5)
						(gEgo posn: 306 119 setPri: 5)
					)
					((< (gEgo x:) 50)
						(gEgo posn: 5 186)
					)
					(else
						(gEgo
							x: (+ (/ (* (- (gEgo x:) 131) 24) 24) 179)
							y: 185
						)
					)
				)
			)
			(38
				(gEgo
					loop: 2
					x: (+ (/ (* (- (gEgo x:) 158) 32) 46) 158)
					y: 146
				)
				(self setScript: closeDoorScript)
			)
			(else
				(gEgo posn: 160 135)
			)
		)
		(gEgo init:)
		(proc0_10)
		(bg init:)
		(gAddToPics
			add:
				bg
				flower
				((Clone flower) loop: 1 cel: 1 x: 50 y: 165)
				((Clone flower) loop: 1 cel: 0 x: 49 y: 174)
				((Clone flower) loop: 0 cel: 1 x: 58 y: 179)
				((Clone flower) loop: 2 cel: 1 x: 50 y: 178)
				((Clone flower) loop: 1 cel: 0 x: 296 y: 141 priority: 11)
			eachElementDo: #init
			doit:
		)
		(cond
			([global675 12]
				(peterDone init:)
				(wifeDone init:)
				(= local2 1)
			)
			((== global111 41)
				(if (< global131 1)
					(peter
						setLoop: 0
						setCel: 0
						ignoreActors: 1
						ignoreControl: -1
						ignoreHorizon: 1
						xStep: 3
						yStep: 2
						posn: 100 149
						init:
					)
				else
					(peter
						ignoreActors: 1
						ignoreControl: -1
						ignoreHorizon: 1
						xStep: 3
						yStep: 2
						stopUpd:
						init:
					)
				)
				(door setCel: (door lastCel:))
			)
			(else
				(peter
					ignoreActors: 1
					ignoreControl: -1
					ignoreHorizon: 1
					xStep: 3
					yStep: 2
					stopUpd:
					init:
				)
			)
		)
		(if
			(and
				(not [global675 12])
				(== (gEgo onControl: 1) 8192)
				(= local1 (proc0_11 41))
			)
			(= [global675 12] 1)
			(= global206 gSpeed)
			(switch global131
				(0
					(gGame setSpeed: 4)
				)
				(1
					(gGame setSpeed: 7)
				)
				(2
					(gGame setSpeed: 10)
				)
			)
			(peter setScript: rhymeScript)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 12)
						(== local3 1)
						(== (event message:) KEY_RETURN)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (rhymeScript state:) 12) (== local3 1))
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (rhymeScript state:) 12) (== local3 1))
					(rhymeScript cycles: 1)
				)
				(if
					(and
						(& temp0 emSHIFT)
						(!= local2 1)
						(proc0_16 event 94 111 105 145)
					)
					(LookAt peter)
					(peter setScript: talkScript)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(if (== global111 47)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 13)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(if (< (gEgo x:) 283)
					(gCurRoom newRoom: 5)
				else
					(gCurRoom newRoom: 6)
				)
			)
			(
				(and
					(== (gEgo onControl: 1) 16384)
					(!= script openDoorScript)
					(not [global675 12])
				)
				(self setScript: openDoorScript)
			)
			((== (gEgo onControl: 1) 2)
				(gCurRoom newRoom: 19)
			)
		)
		(super doit:)
		(if (> (gEgo distanceTo: peter) 30)
			(= global108 0)
		)
		(if
			(and
				(not [global675 12])
				(== (gEgo onControl: 1) 8192)
				(not global108)
				(< (gEgo distanceTo: peter) 30)
			)
			(= global108 1)
			(LookAt peter)
			(peter setScript: talkScript)
		)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGlobalMGSound stop:)
				(doorSound number: 17 loop: 1 play:)
				(door setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 38)
			)
		)
	)
)

(instance closeDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(door setCycle: Beg self)
				(doorSound number: 43 loop: 1 play:)
			)
			(1
				(door stopUpd:)
				(doorSound number: 44 loop: 1 play: self)
			)
			(2
				(HandsOn)
				(gCurRoom setScript: 0)
				(gGlobalMGSound loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
			)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local2 1)
				(HandsOff)
				(peter setLoop: 7 setCycle: Fwd)
				(itemBalloon init: setCel: 0 show:)
				(RedrawCast)
				(Display
					{Oh,\nmy wife\nis gone\nagain!}
					dsWIDTH
					100
					dsCOORD
					95
					46
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(rhymeSound number: 41 loop: 1 play:)
				(= seconds global120)
			)
			(1
				(itemBalloon setCel: 1)
				(itemVisual init: show:)
				(peter setLoop: 2 setCel: 2)
				(= seconds global121)
			)
			(2
				(itemVisual hide:)
				(itemBalloon hide:)
				(peter setCel: 1)
				(= global103 0)
				(= local2 0)
				(HandsOn)
			)
		)
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local2 1)
				(= global209 1)
				(HandsOff)
				(wife init:)
				(gEgo setAvoider: Avoid setMotion: MoveTo 155 186 self)
				(if (< global131 1)
					(peter
						setCycle: Walk
						cycleSpeed: 1
						moveSpeed: 1
						setMotion: MoveTo 175 180
					)
				)
			)
			(1
				(proc0_18)
				(= cycles 5)
			)
			(2
				(gEgo setScript: musicScript setLoop: 3)
				(if (> global131 0)
					(peter setLoop: 0 setCel: 0 posn: 100 149)
				)
				(= seconds 1)
			)
			(3
				(if (> global131 0)
					(wife setMotion: MoveTo 237 158 self)
				else
					(wife setMotion: MoveTo 207 158 self)
				)
			)
			(4
				(if (> global131 0)
					(peter
						setCycle: Walk
						cycleSpeed: 1
						moveSpeed: 1
						setMotion: MoveTo 175 180
					)
					(wife setMotion: MoveTo 202 142 self)
				else
					(= cycles 1)
				)
			)
			(5
				(if (< global131 1)
					(= cycles 1)
				else
					(wife setMotion: MoveTo 237 158 self)
				)
			)
			(6
				(wife setMotion: MoveTo 185 179)
			)
			(7
				(peter setLoop: 2 setCel: 0)
				(wife hide:)
				(kiss init:)
				(heart1 setCycle: End self cycleSpeed: 1 init:)
			)
			(8
				(heart2 setCycle: End self cycleSpeed: 1 init:)
			)
			(9
				(kiss dispose:)
				(peter setLoop: 4 setCycle: Walk setMotion: MoveTo 143 140)
				(wife show: setMotion: MoveTo 167 128 self)
			)
			(10
				(peter setLoop: 2 setCel: 3 stopUpd:)
				(doorSound number: 43 loop: 1 play:)
				(door setCycle: Beg self)
			)
			(11
				(door stopUpd:)
				(wife setLoop: 2 stopUpd:)
				(peter setCel: 4)
				(gEgo setMotion: 0 setAvoider: 0 setCycle: Walk setLoop: -1)
				(= local0 0)
				(= global103 0)
				(= seconds 3)
			)
			(12
				(gGame setSpeed: global206)
			)
			(13
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(rhymeBox dispose:)
				(proc0_12)
				(if (== gScore gPossibleScore)
					(gEgo setAvoider: Avoid)
					(proc0_14 160 174)
				else
					(NormalEgo)
					(HandsOn)
					(= global209 0)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (rhymeSound prevSignal:) -1)
			(rhymeSound prevSignal: 0)
			(= local3 1)
		)
	)
)

(instance musicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhymeSound loop: 1 play: self)
				(rhymeBox init:)
				(rhymeBox open:)
			)
			(1
				(Display
					{Peter, Peter, pumpkin-eater,}
					dsWIDTH
					250
					dsCOORD
					5
					5
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(2
				(Display
					{Had a wife and couldn't keep her;}
					dsWIDTH
					250
					dsCOORD
					5
					17
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(3
				(Display
					{He put her in a pumpkin shell,}
					dsWIDTH
					250
					dsCOORD
					5
					29
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(4
				(Display
					{And there he kept her very well.}
					dsWIDTH
					250
					dsCOORD
					5
					41
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(5
				(rhymeScript cue:)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance rhymeSound of Sound
	(properties
		number 27
		priority 10
	)
)

(instance doorSound of Sound
	(properties
		priority 10
	)
)

(instance peter of Actor
	(properties
		x 100
		y 135
		view 77
		loop 2
		cel 1
	)
)

(instance peterDone of View
	(properties)

	(method (init)
		(super init:)
		(self view: 77 posn: 143 140 setLoop: 2 setCel: 4 stopUpd:)
	)
)

(instance wife of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 41
			posn: (local1 x:) (local1 y:)
			yStep: 2
			xStep: 3
			setCycle: Walk
			cycleSpeed: 1
			moveSpeed: 1
			ignoreControl: -1
		)
	)
)

(instance wifeDone of View
	(properties)

	(method (init)
		(super init:)
		(self view: 41 posn: 167 128 setLoop: 2 species 2 stopUpd:)
	)
)

(instance kiss of View
	(properties)

	(method (init)
		(super init:)
		(self view: 77 posn: 180 130 setLoop: 3 setCel: 1 setPri: 10 stopUpd:)
	)
)

(instance heart1 of Prop
	(properties
		x 149
		y 151
		view 77
		loop 5
	)
)

(instance heart2 of Prop
	(properties
		x 195
		y 146
		view 77
		loop 6
	)
)

(instance door of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 125
			setLoop: 1
			setCel: (if (== gPrevRoomNum 38) species else 0)
			cycleSpeed: 1
			posn: 192 136
		)
	)
)

(instance bg of PicView
	(properties
		x 173
		y 131
		view 125
		priority 4
	)
)

(instance flower of PicView
	(properties
		x 50
		y 156
		view 300
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self view: 133 setLoop: 0 posn: 146 74 setPri: 15 hide: stopUpd:)
	)
)

(instance itemBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 39 setLoop: 1 posn: 145 100 setPri: 14 hide: stopUpd:)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 12
			left: 5
			bottom: 65
			right: 228
			type: 4
			title: {Peter Pumpkin Eater}
			back: 2
		)
	)
)

