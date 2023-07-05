;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use System)

(public
	rm010 0
)

(local
	local0
	[local1 5]
)

(instance rm010 of SQRoom
	(properties
		picture 10
	)

	(method (init &tmp [temp0 50])
		(Load rsVIEW 11)
		(Load rsVIEW 10)
		(LoadMany rsSOUND 5 6 7 8 9 10 11 12 112 113 880)
		(blip init:)
		(super init:)
		(self setScript: planetScript setRegions: 707) ; intro
	)
)

(instance planetScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== (self state:) 1) (>= (gLongSong prevSignal:) 10))
			(gLongSong prevSignal: 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 13 loop: 1 vol: 127 playBed:)
				(= seconds 3)
			)
			(1
				(gNarrator ; "During the descent to this cosmic canteen he is unaware of the interest that has been generated regarding his fate."
					modeless: 0
					returnVal: 0
					nMsgType: 3
					say:
						1
						self
						2
						64
						1
						35
						67
						318
						25
						global137
						26
						global129
						27
						1
						30
						310
				)
			)
			(2
				(= ticks 90)
			)
			(3
				(FX init: number: 880 loop: -1 play:)
				(planet init: setCycle: End self)
			)
			(4
				(FX stop:)
				(planet stopUpd:)
				(= ticks 90)
			)
			(5
				(FX number: 5 loop: 1 play:)
				(DrawCel 10 1 0 108 139 global131)
				(= ticks 90)
			)
			(6
				(mag init: setCycle: End self)
			)
			(7
				(mag stopUpd:)
				(= ticks 90)
			)
			(8
				(FX number: 6 play:)
				(DrawCel 10 1 1 108 148 global131)
				(= ticks 90)
			)
			(9
				(rog init: setCycle: End self)
			)
			(10
				(rog stopUpd:)
				(= ticks 90)
			)
			(11
				(FX number: 7 play:)
				(grid init:)
				(= ticks 90)
			)
			(12
				(FX number: 8 play:)
				(grid setCycle: End self)
			)
			(13
				(grid setCel: 0 setLoop: 2 setCycle: End self)
			)
			(14
				(gLongSong number: 10 loop: 1 vol: 127 playBed:)
				(grid setLoop: 3 setCycle: Fwd)
				(= ticks 120)
			)
			(15
				(FX number: 11 play:)
				(dx1 init:)
				(dx2 init:)
				(dx3 init:)
				(dy1 init:)
				(dy2 init:)
				(dy3 init:)
				(= ticks 60)
			)
			(16
				(blip number: 113 loop: -1 play:)
				(dx1 setCycle: Fwd)
				(dx2 setCycle: Fwd)
				(dx3 setCycle: Fwd)
				(dy1 setCycle: Fwd)
				(dy2 setCycle: Fwd)
				(dy3 setCycle: Fwd)
				(= ticks 60)
			)
			(17
				(dx1 setCycle: CT 2 1 self)
				(dy1 setCycle: CT 1 1)
			)
			(18
				(dx2 setCycle: CT 5 1 self)
				(dy2 setCycle: CT 4 1)
			)
			(19
				(dx3 setCycle: CT 9 1 self)
				(dy3 setCycle: CT 2 1)
			)
			(20
				(blip stop: dispose:)
				(gLongSong number: 12 loop: 1 vol: 127 playBed:)
				(= ticks 30)
			)
			(21
				(grid stopUpd:)
				(dx1 stopUpd:)
				(dy1 stopUpd:)
				(dx2 stopUpd:)
				(dy2 stopUpd:)
				(dx3 stopUpd:)
				(dy3 stopUpd:)
				(loc init: setCel: (mod register 2))
				(if (mod register 2)
					(FX loop: 1 play:)
				)
				(++ register)
				(= ticks 30)
			)
			(22
				(if (< register 6)
					(-= state 2)
					(= cycles 1)
				else
					(= seconds 1)
				)
			)
			(23
				(tSVGRUNT ; "We have confirmation of his position, Master."
					say: 1 self 2 64 1 2 67 178 25 global136 26 global129 27 1
				)
			)
			(24
				(= seconds 1)
			)
			(25
				(tSLUDGE ; "Off to Magmetheus with you then! It is time for Wilco to meet the fate which I have crafted for him."
					say: 1 self 2 64 140 2 67 178 25 global140 26 global129 27 1
				)
			)
			(26
				(proc0_12 local0)
				(Animate (gCast elements:) 0)
				(gCurRoom newRoom: 15)
			)
		)
	)
)

(instance planet of Sq4Prop
	(properties
		view 11
	)

	(method (init)
		(super init:)
		(self setCel: 0 ignoreActors: 1 posn: 157 94 setPri: 4)
	)
)

(instance grid of Sq4Prop
	(properties
		view 11
	)

	(method (init)
		(super init:)
		(self setLoop: 1 setCel: 0 ignoreActors: 1 posn: 140 79 setPri: 5)
	)

	(method (doit)
		(super doit:)
		(if (and (== (self loop:) 2) (== (self cel:) 0))
			(FX number: 9 play:)
		)
	)
)

(instance dx1 of Sq4Prop
	(properties
		view 10
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 0 ignoreActors: 1 posn: 78 99)
	)
)

(instance dx2 of Sq4Prop
	(properties
		view 10
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 0 ignoreActors: 1 posn: 86 99)
	)
)

(instance dx3 of Sq4Prop
	(properties
		view 10
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 0 ignoreActors: 1 posn: 94 99)
	)
)

(instance dy1 of Sq4Prop
	(properties
		view 10
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 0 ignoreActors: 1 posn: 151 45)
	)
)

(instance dy2 of Sq4Prop
	(properties
		view 10
	)

	(method (init)
		(super init:)
		(self view: 10 setLoop: 0 setCel: 0 ignoreActors: 1 posn: 159 45)
	)
)

(instance dy3 of Sq4Prop
	(properties
		view 10
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 0 ignoreActors: 1 posn: 167 45)
	)
)

(instance mag of Sq4Prop
	(properties
		view 10
		cycleSpeed 3
	)

	(method (init)
		(super init:)
		(self setLoop: 2 setCel: 0 ignoreActors: 1 posn: 155 146)
	)

	(method (doit)
		(super doit:)
		(if (< (self cel:) 9)
			(blip play:)
		)
	)
)

(instance rog of Sq4Prop
	(properties
		view 10
		cycleSpeed 3
	)

	(method (init)
		(super init:)
		(self setLoop: 4 setCel: 0 ignoreActors: 1 posn: 155 155)
	)

	(method (doit)
		(super doit:)
		(if (< (self cel:) 9)
			(blip play:)
		)
	)
)

(instance loc of Sq4Prop
	(properties
		view 10
	)

	(method (init)
		(super init:)
		(self setLoop: 3 setCel: 0 ignoreActors: 1 posn: 157 169 cycleSpeed: 50)
	)
)

(instance FX of Sound
	(properties)
)

(instance blip of Sound
	(properties
		number 112
	)
)

(instance tSVGRUNT of Sq4Narrator
	(properties
		noun 5
		talkerNum 5
	)
)

(instance tSLUDGE of Sq4Narrator
	(properties
		noun 6
		talkerNum 6
	)
)

