;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use Wander)
(use Sound)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm032 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm032 of Rm
	(properties
		picture 32
		style 0
		horizon 100
		north 25
		west 31
	)

	(method (init &tmp [temp0 50])
		(if (not global117)
			(= global117 19)
			(= global114 0)
			(StrCpy @global210 {Chris})
		)
		(= local2 (+ global117 1))
		(Load rsVIEW 16)
		(Load rsVIEW global117)
		(Load rsVIEW global114)
		(Load rsVIEW 131)
		(Load rsVIEW 18)
		(Load rsVIEW local2)
		(Load rsVIEW 92)
		(Load rsVIEW 39)
		(Load rsVIEW 232)
		(Load rsVIEW 17)
		(Load rsVIEW 300)
		(Load rsSOUND 17)
		(Load rsSOUND 43)
		(Load rsSOUND 1)
		(Load rsSOUND 44)
		(Load rsSOUND 46)
		(= global103 0)
		(super init:)
		(aFlower1 init: addToPic:)
		(aFlower2 init: addToPic:)
		(aFlower3 init: addToPic:)
		(aFlower4 init: addToPic:)
		(= global207 0)
		(door init: stopUpd:)
		(goose init: hide:)
		(cond
			((< gScore gPossibleScore)
				(if (== gPrevRoomNum 42)
					(= global195 -20)
					(= global196 165)
				)
				(proc0_10)
				(= global125 -1)
				(if global194
					(= gPrevRoomNum 201)
					(= global194 0)
				)
				(switch gPrevRoomNum
					(200
						(gEgo posn: 159 169)
						(gGlobalMGSound number: 1 loop: -1)
						(if (== global208 0)
							(gGlobalMGSound play:)
						)
					)
					(201
						(TheMenuBar state: 1)
						(TheMenuBar draw:)
						(SL enable:)
						(gGlobalMGSound number: 1 loop: -1)
						(if (== global208 0)
							(gGlobalMGSound play:)
						)
						(self setScript: gameStartScript)
					)
					(25
						(gEgo x: (+ (/ (* (- (gEgo x:) 70) 81) 124) 132))
					)
					(31
						(if (< (gEgo y:) 110)
							(gEgo x: 132)
						)
					)
					(33
						(gEgo y: (+ (/ (* (- (gEgo y:) 101) 76) 87) 112))
					)
					(42
						(gEgo
							x: (+ (/ (* (- (gEgo x:) 88) 19) 51) 10)
							y: 154
							edgeHit: 0
						)
						(self setScript: closeDoorScript)
					)
					(96
						(gEgo posn: 159 169)
					)
					(else
						(gEgo posn: 159 169)
						(gGlobalMGSound number: 1 loop: -1)
						(if (== global208 0)
							(gGlobalMGSound play:)
						)
					)
				)
				(if (!= gPrevRoomNum 201)
					(gEgo init:)
					(goose show:)
				else
					(goose stopUpd:)
				)
			)
			((== gScore gPossibleScore)
				(Load rsVIEW 94)
				(Load rsVIEW 142)
				(Load rsVIEW 141)
				(Load rsVIEW 140)
				(gEgo init: hide:)
				(humpty init:)
				(man init:)
				(muffet init:)
				(cat init:)
				(contrary init:)
				(king init:)
				(jackJill init:)
				(dog init: stopUpd:)
				(lady init:)
				(self setScript: gameEndScript)
			)
		)
		(if global131
			(smoke init:)
			(gooseWindow setPri: 13 init:)
		else
			(smoke init: addToPic:)
			(gooseWindow setPri: 13 init: addToPic:)
		)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(= local3 (event type:))
		(switch (event type:)
			(evMOUSEBUTTON
				(if
					(and
						(& (= temp0 (event modifiers:)) emSHIFT)
						(proc0_19 goose event)
					)
					(goose setScript: HonkScript)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(cond
			((== (gEgo onControl: 1) 2)
				(gCurRoom newRoom: 31)
			)
			((and (== (gEgo onControl: 1) 16384) (!= script openDoorScript))
				(self setScript: openDoorScript)
			)
			((== (gEgo edgeHit:) 2)
				(if (== global111 55)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 33)
			)
		)
		(super doit:)
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
				(gCurRoom newRoom: 42)
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
				(gGlobalMGSound stop:)
				(doorSound number: 43 loop: 1 play:)
			)
			(1
				(door setCycle: 0 stopUpd:)
				(doorSound number: 44 loop: 1 play: self)
			)
			(2
				(HandsOn)
				(gGlobalMGSound loop: -1 number: 1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance gameStartScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 70])
		(switch (= state newState)
			(0
				(= global103 1)
				(HandsOff)
				(flyer init: hide:)
				(= cycles 2)
			)
			(1
				(flyer
					view: 16
					show:
					cycleSpeed: 0
					setMotion: MoveTo 338 21 self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(flyer
					view: global117
					setLoop: 1
					cel: 0
					posn: 353 73
					setPri: 13
					cycleSpeed: (if global131 1 else 0)
					setMotion: MoveTo 128 171 self
				)
				(wing init:)
			)
			(4
				(wing dispose:)
				(flyer view: 17 posn: 130 173 setLoop: 1)
				(rider
					loop: 0
					cel: 0
					ignoreActors: 1
					init:
					posn: (+ (flyer x:) 2) (flyer y:)
					setCycle: CT 9 1 self
				)
			)
			(5
				(rider dispose:)
				(gEgo
					view: global114
					loop: 1
					posn: (+ (flyer x:) 2) (flyer y:)
					init:
				)
				(= cycles 10)
			)
			(6
				(motherG setPri: (- (door priority:) 1) init:)
				(door setCycle: End self)
			)
			(7
				(motherG setPri: 14 setMotion: MoveTo 19 166 self)
				(door stopUpd:)
			)
			(8
				(motherG setMotion: MoveTo 105 175 self)
			)
			(9
				(motherG setLoop: 4 setCycle: Fwd)
				(itemBalloon init:)
				(RedrawCast)
				(= local1
					(Display
						(Format
							@global270
							{%s!\nMy rhymes\nare mixed-up!}
							@global210
						)
						dsWIDTH
						120
						dsCOORD
						104
						90
						dsALIGN
						alCENTER
						dsFONT
						0
						dsCOLOR
						0
						dsSAVEPIXELS
					)
				)
				(= seconds global120)
			)
			(10
				(Display 32 0 dsRESTOREPIXELS local1)
				(Display
					{Please\nhelp me\nfix them!}
					dsWIDTH
					80
					dsCOORD
					125
					90
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(= seconds global120)
			)
			(11
				(itemBalloon dispose:)
				(motherG
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 19 166 self
				)
			)
			(12
				(motherG setMotion: MoveTo 19 140 self)
			)
			(13
				(motherG setPri: (- (door priority:) 1))
				(door setCycle: Beg self)
			)
			(14
				(door setCycle: 0)
				(motherG dispose:)
				(goose
					show:
					cycleSpeed: 0
					setCycle: Walk
					x: (flyer x:)
					y: (flyer y:)
				)
				(flyer dispose:)
				(= global103 0)
				(= cycles 1)
			)
			(15
				(NormalEgo)
				(HandsOn)
			)
		)
	)
)

(instance gameEndScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(HandsOff)
				(goose dispose:)
				(gEgo hide:)
				(flyer
					init:
					setLoop: 1
					cel: 0
					posn: 353 73
					setPri: 12
					setMotion: MoveTo 220 154 self
				)
				(wing init:)
				(riderOne init:)
			)
			(1
				(wing dispose:)
				(flyer
					view: 17
					posn: (+ (flyer x:) 1) (- (flyer y:) 1)
					setLoop: 1
				)
				(rider
					loop: 0
					cel: 0
					ignoreActors: 1
					init:
					posn: (+ (flyer x:) 2) (flyer y:)
					setCycle: CT 9 1 self
				)
				(riderOne hide:)
				(motherG
					init:
					view: (riderOne view:)
					setLoop: 2
					posn: (- (riderOne x:) 3) (+ (riderOne y:) 1)
					setPri: 10
				)
			)
			(2
				(rider hide:)
				(riderOne dispose:)
				(flyer hide:)
				(gooseDone init:)
				(gEgo
					show:
					setLoop: 1
					setCel: 0
					posn: (+ (flyer x:) 3) (flyer y:)
				)
				(motherG
					view: 92
					setLoop: -1
					setPri: 10
					posn: (+ (flyer x:) 15) (- (flyer y:) 1)
					setMotion: MoveTo 152 138 self
				)
			)
			(3
				(motherG view: 141 setLoop: 2 setCel: 0 setPri: -1 stopUpd:)
				(RedrawCast)
				(RedrawCast)
				(textBalloon init:)
				(RedrawCast)
				(Display
					(Format @global270 {Three cheers for %s!} @global210)
					dsWIDTH
					100
					dsCOORD
					150
					50
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(= seconds global120)
			)
			(4
				(textBalloon dispose:)
				(RedrawCast)
				(self setScript: cheerScript)
			)
			(5
				(self setScript: cheerScript)
			)
			(6
				(self setScript: cheerScript)
			)
			(7
				(motherG view: 141 setLoop: 2 setCel: 1 setPri: -1 stopUpd:)
				(textBalloon init:)
				(RedrawCast)
				(Display
					(Format
						@global270
						{And we want\nto give you\nthis medal,\n%s!}
						@global210
					)
					dsWIDTH
					100
					dsCOORD
					150
					47
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(= seconds 4)
			)
			(8
				(gEgo
					setCel: -1
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 166 138 self
				)
			)
			(9
				(textBalloon dispose:)
				(RedrawCast)
				(gEgo setLoop: 1 setCel: 0)
				(= cycles 2)
			)
			(10
				(gooseDone setLoop: 0)
				(motherG setCel: 0)
				(gEgo setLoop: 2 setCel: 0)
				(medalView setPri: (+ (gEgo priority:) 1) init:)
				(= cycles 40)
			)
			(11
				(textBalloon init:)
				(RedrawCast)
				(Display
					(Format
						@global270
						{Now it's time for you to go home, %s.}
						@global210
					)
					dsWIDTH
					100
					dsCOORD
					150
					47
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(= seconds global120)
			)
			(12
				(textBalloon dispose:)
				(medalView dispose:)
				(medalSide init:)
				(gEgo
					setLoop: 0
					setCel: -1
					setMotion: MoveTo (- (flyer x:) 37) (+ (flyer y:) 2) self
				)
			)
			(13
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo (+ (flyer x:) 3) (flyer y:) self
				)
			)
			(14
				(gooseDone dispose:)
				(medalSide dispose:)
				(gEgo dispose:)
				(motherG setCel: 0)
				(flyer show: cel: 0 setLoop: 0 posn: 222 156 setPri: 12)
				(gEgo hide:)
				(rider show: setLoop: 0 setCel: 9 setCycle: Beg self)
			)
			(15
				(rider setCycle: 0 dispose:)
				(medalRider init:)
				(flyer
					view: global117
					setCycle: Fwd
					setMotion: MoveTo 353 73 self
				)
				(wing init:)
			)
			(16
				(medalRider dispose:)
				(wing dispose:)
				(cat setCel: 2)
				(motherG setCel: 3)
				(man setCel: 2)
				(= cycles 15)
			)
			(17
				(muffet setCel: 1)
				(king setCel: 2)
				(contrary setCel: 2)
				(= cycles 15)
			)
			(18
				(jackJill setCel: 1)
				(lady setCel: 1)
				(rider dispose:)
				(flyer
					view: 16
					setPri: -1
					setLoop: 3
					setMotion: MoveTo -19 10 self
				)
				(byeBalloon init:)
				(RedrawCast)
				(Display
					(Format @global270 {Goodbye,\n%s!} @global210)
					dsWIDTH
					100
					dsCOORD
					190
					50
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(19
				(gCurRoom newRoom: 201)
			)
		)
	)
)

(instance cheerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(textBalloon init:)
				(RedrawCast)
				(Display {Hip!\n\nHip!} dsWIDTH 80 dsCOORD 160 45 dsALIGN alCENTER dsFONT 0 dsCOLOR 0)
				(= seconds 3)
			)
			(1
				(textBalloon dispose:)
				(hoorayBalloon init:)
				(motherG setCel: 2)
				(humpty setCycle: Fwd)
				(dog setCycle: Fwd)
				(man setCel: 1)
				(cat setCel: 1)
				(contrary setCel: 1)
				(king setCel: 1)
				(= seconds 4)
			)
			(2
				(hoorayBalloon dispose:)
				(motherG setCel: 0)
				(humpty setCel: 0 stopUpd:)
				(dog stopUpd:)
				(man setCel: 0)
				(cat setCel: 0)
				(contrary setCel: 0)
				(king setCel: 0)
				(= cycles 8)
			)
			(3
				(client cue:)
			)
		)
	)
)

(instance doorSound of Sound
	(properties
		priority 10
	)
)

(instance honk of Sound
	(properties
		number 46
		priority 10
	)
)

(instance smoke of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 131
			setLoop: 1
			posn: 67 11
			cycleSpeed: 2
			setPri: 1
			setCycle: Fwd
		)
	)
)

(instance door of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 131
			setLoop: 0
			setCel: (if (== gPrevRoomNum 42) species else 0)
			posn: 37 148
		)
	)
)

(instance goose of Act
	(properties)

	(method (init)
		(super init:)
		(gooseCage init:)
		(self
			view: 18
			posn: 161 139
			setCycle: Walk
			xStep: 2
			yStep: 1
			cycleSpeed: 0
			setMotion: Wander 100
			observeBlocks: gooseCage
		)
	)
)

(instance gooseCage of Cage
	(properties)

	(method (init)
		(super init:)
		(self top: 100 left: 130 bottom: 190 right: 300)
	)
)

(instance rider of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: local2 setLoop: 1 setPri: 13)
	)
)

(instance riderOne of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 94 setLoop: 1 ignoreActors: 1)
	)

	(method (doit)
		(self
			setCel: (flyer cel:)
			posn: (+ (flyer x:) 20) (flyer y:)
			setPri: (+ (flyer priority:) 1)
		)
		(super doit:)
	)
)

(instance flyer of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: global117
			setLoop: 2
			setCycle: Walk
			ignoreHorizon: 1
			ignoreActors: 1
			illegalBits: 0
			posn: -22 21
		)
	)
)

(instance wing of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 16
			setLoop: (+ (flyer loop:) 5)
			ignoreHorizon: 1
			ignoreActors: 1
			illegalBits: 0
			setPri: 13
		)
	)

	(method (doit)
		(self
			posn: (flyer x:) (flyer y:)
			setPri: (+ (flyer priority:) 1)
			setCel: (flyer cel:)
		)
		(super doit:)
	)
)

(instance medalView of View
	(properties
		y 127
		x 167
		view 142
		loop 1
	)
)

(instance medalSide of Prop
	(properties
		view 142
		loop 1
		cel 2
	)

	(method (doit)
		(self
			posn: (+ (gEgo x:) 2) (- (gEgo y:) 15)
			setPri: (+ (gEgo priority:) 1)
		)
		(super doit:)
	)
)

(instance medalRider of Prop
	(properties
		view 142
		loop 3
	)

	(method (doit)
		(self
			posn: (+ (flyer x:) 2) (- (flyer y:) 10)
			setPri: (+ (flyer priority:) 1)
			setCel: (flyer cel:)
		)
		(super doit:)
	)
)

(instance motherG of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 92
			setCycle: Walk
			illegalBits: 0
			ignoreActors: 1
			ignoreControl: 16384
			posn: 19 142
		)
	)
)

(instance itemBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 39 setLoop: 1 posn: 165 140 setPri: 15 stopUpd:)
	)
)

(instance textBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 39 setLoop: 1 posn: 200 100 setPri: 15 stopUpd:)
	)
)

(instance hoorayBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 141 setLoop: 3 posn: 240 80 setPri: 15 stopUpd:)
	)
)

(instance byeBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 141 setLoop: 4 posn: 240 80 setPri: 15 stopUpd:)
	)
)

(instance humpty of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 140 setLoop: 0 posn: 231 177 setPri: 15 stopUpd:)
	)
)

(instance man of View
	(properties)

	(method (init)
		(super init:)
		(self view: 140 setLoop: 1 posn: 261 171 stopUpd:)
	)
)

(instance muffet of View
	(properties)

	(method (init)
		(super init:)
		(self view: 140 setLoop: 7 posn: 288 169 stopUpd:)
	)
)

(instance cat of View
	(properties)

	(method (init)
		(super init:)
		(self view: 140 setLoop: 6 posn: 307 155 stopUpd:)
	)
)

(instance contrary of View
	(properties)

	(method (init)
		(super init:)
		(self view: 140 setLoop: 5 posn: 283 140 stopUpd:)
	)
)

(instance king of View
	(properties)

	(method (init)
		(super init:)
		(self view: 140 setLoop: 3 posn: 270 124 stopUpd:)
	)
)

(instance jackJill of View
	(properties)

	(method (init)
		(super init:)
		(self view: 140 setLoop: 2 posn: 243 131 stopUpd:)
	)
)

(instance dog of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 141 setLoop: 0 posn: 135 156 setCycle: Fwd)
	)
)

(instance lady of View
	(properties)

	(method (init)
		(super init:)
		(self view: 140 setLoop: 4 posn: 156 105 stopUpd:)
	)
)

(instance gooseDone of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 17
			setLoop: 1
			posn: (+ (flyer x:) 1) (- (flyer y:) 1)
			stopUpd:
		)
	)
)

(instance gooseWindow of View
	(properties
		y 72
		x 80
		view 232
	)
)

(instance HonkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goose setMotion: 0)
				(honk play: self)
			)
			(1
				(goose setMotion: Wander 100 setCycle: Walk)
			)
		)
	)
)

(instance aFlower1 of Prop
	(properties
		y 115
		x 140
		view 300
	)
)

(instance aFlower2 of Prop
	(properties
		y 122
		x 136
		view 300
	)
)

(instance aFlower3 of Prop
	(properties
		y 129
		x 131
		view 300
	)
)

(instance aFlower4 of Prop
	(properties
		y 137
		x 127
		view 300
	)
)

