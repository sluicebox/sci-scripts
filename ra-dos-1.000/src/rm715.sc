;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 715)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm715 0
)

(local
	local0
)

(instance rm715 of LBRoom
	(properties
		picture 715
		style 12
		east 720
		west 710
	)

	(method (init)
		(gEgo wearingGown: 1 view: 715 loop: 3 cel: 0 posn: 121 142 init:)
		(LoadMany rsSOUND 710 712 713)
		(LoadMany rsVIEW 711 712 713 715 710 714 716)
		(super init:)
		(WrapMusic init: 1 1710 1712 1713)
		(gTheIconBar disable: 7)
		(tut addToPic:)
		(rameses init:)
		(sunnie1 init: setCycle: Fwd)
		(sunnie2 init: setCycle: Fwd)
		(sunnie3 init: setCycle: Fwd)
		(sunnie4 init: setCycle: Fwd)
		(sunnie5 init: setCycle: Fwd)
		(sunnie6 init: setCycle: Fwd)
		(sunnie7 init: setCycle: Fwd)
		(sunnie8 init: setCycle: Fwd)
		(sunnie9 init: setCycle: Fwd)
		(sunnie10 init: setCycle: Fwd)
		(gCurRoom setScript: sQuestion)
	)

	(method (dispose)
		(gGameMusic2 fade:)
		(super dispose: &rest)
	)
)

(instance sQuestion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(= ticks 180)
			)
			(2
				(sunnie1 setCycle: End self)
				(sunnie2 setCycle: End)
				(sunnie3 setCycle: End self)
				(sunnie4 setCycle: End)
				(sunnie5 setCycle: End self)
				(sunnie6 setCycle: End)
				(sunnie7 setCycle: End)
				(sunnie8 setCycle: End)
				(sunnie9 setCycle: End)
				(sunnie10 setCycle: End)
			)
			(3)
			(4)
			(5
				(sunnie1 addToPic:)
				(sunnie2 addToPic:)
				(sunnie3 addToPic:)
				(sunnie4 addToPic:)
				(sunnie5 addToPic:)
				(sunnie6 addToPic:)
				(sunnie7 addToPic:)
				(sunnie8 addToPic:)
				(sunnie9 addToPic:)
				(sunnie10 addToPic:)
				(WrapMusic dispose:)
				(= cycles 1)
			)
			(6
				(gMessager say: 1) ; "You don't really plan to KILL me, do you?"
				(= cycles 1)
			)
			(7
				(gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
				(= local0 (not (StrCmp @global136 {WOMB})))
				(= cycles 1)
			)
			(8
				(gTheIconBar disable: 7)
				(if local0
					(gGame points: 1 156)
					(= global136 0)
					(gMessager say: 1 0 2) ; "That'th correct. Now, the thecond riddle: What ith the room you enter without leaving?"
					(= cycles 1)
				else
					(gCurRoom setScript: sDeath)
				)
			)
			(9
				(gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
				(= local0 (not (StrCmp @global136 {TOMB})))
				(= cycles 1)
			)
			(10
				(gTheIconBar disable: 7)
				(if local0
					(gGame points: 1 157)
					(gMessager say: 1 0 3) ; "Very imprethive. You are the firtht person who ever anthered that riddle correctly. The withe Amon Ra apparently wanth uth to thpare your life. Will you thwear to keep our locathion a thecret?"
					(= cycles 1)
				else
					(gCurRoom setScript: sDeath)
				)
			)
			(11
				(rameses setCycle: End self)
			)
			(12
				(rameses stopUpd:)
				(= cycles 1)
			)
			(13
				(gEgo
					normalize: 831
					loop: 1
					scaleSignal: 1
					scaleX: 110
					scaleY: 110
					setHeading: 0 self
				)
			)
			(14
				(gEgo setLoop: 3 setMotion: MoveTo 123 159 self)
			)
			(15
				(gEgo setPri: 9 setMotion: MoveTo 130 159 self)
			)
			(16
				(gEgo setLoop: 0 setMotion: MoveTo 152 186 self)
			)
			(17
				(gEgo edgeHit: EDGE_RIGHT)
				(gCurRoom newRoom: 720)
				(self dispose:)
			)
		)
	)
)

(instance sDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rameses setCycle: End self)
			)
			(1
				(gMessager say: 1 0 1 1) ; "I'm thorry, but you're wrong. Amon Ra apparently wantth you ath a thacrifithe."
				(= cycles 1)
			)
			(2
				(rameses setLoop: 1 setCel: 0 setCycle: CT 5 1 self)
			)
			(3
				(wrap init:)
				(rameses setPri: 15 setCycle: CT 0 1 self)
			)
			(4
				(rameses setPri: -1 setCycle: CT 5 1 self)
			)
			(5
				(wrap setCel: (+ (wrap cel:) 1))
				(rameses setPri: 15 setCycle: CT 0 1 self)
			)
			(6
				(rameses setPri: -1 setCycle: CT 5 1 self)
			)
			(7
				(wrap setCel: (+ (wrap cel:) 1))
				(rameses setPri: 15 setCycle: CT 0 1 self)
			)
			(8
				(rameses setPri: -1 setCycle: CT 5 1 self)
			)
			(9
				(wrap setCel: (+ (wrap cel:) 1))
				(rameses setPri: 15 setCycle: CT 0 1 self)
			)
			(10
				(rameses setPri: -1 setCycle: CT 5 1 self)
			)
			(11
				(lauraWrap init:)
				(= ticks 120)
			)
			(12
				(gNarrator x: 59 y: 30)
				(gMessager say: 1 0 1 2) ; "No! Wait! Mmmph! Mmmph!"
				(= cycles 1)
			)
			(13
				(= ticks 180)
			)
			(14
				(= global145 7) ; "That about wraps it up for this mystery."
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance tut of Actor
	(properties
		x 141
		y 142
		view 716
		loop 1
		signal 16385
	)
)

(instance rameses of Actor
	(properties
		x 108
		y 142
		view 715
		signal 16384
	)
)

(instance sunnie1 of Prop
	(properties
		x 27
		y 181
		view 710
		loop 1
		signal 16384
	)
)

(instance sunnie2 of Prop
	(properties
		x 157
		y 189
		view 710
		loop 2
		signal 16384
	)
)

(instance sunnie3 of Prop
	(properties
		x 65
		y 181
		view 711
		loop 2
		signal 16384
	)
)

(instance sunnie4 of Prop
	(properties
		x 203
		y 190
		view 711
		loop 1
		signal 16384
	)
)

(instance sunnie5 of Prop
	(properties
		x 47
		y 188
		view 712
		loop 1
		signal 16384
	)
)

(instance sunnie6 of Prop
	(properties
		x 94
		y 179
		view 712
		loop 2
		signal 16384
	)
)

(instance sunnie7 of Prop
	(properties
		x 183
		y 188
		view 713
		loop 2
		signal 16384
	)
)

(instance sunnie8 of Prop
	(properties
		x 123
		y 187
		view 713
		loop 1
		signal 16384
	)
)

(instance sunnie9 of Prop
	(properties
		x 96
		y 189
		view 714
		loop 1
		signal 16384
	)
)

(instance sunnie10 of Prop
	(properties
		x 137
		y 183
		view 714
		loop 2
		signal 16384
	)
)

(instance wrap of View
	(properties
		x 119
		y 101
		view 715
		loop 4
		priority 11
		signal 17
	)
)

(instance lauraWrap of View
	(properties
		x 70
		y 59
		view 715
		loop 2
		priority 15
		signal 16401
	)
)

