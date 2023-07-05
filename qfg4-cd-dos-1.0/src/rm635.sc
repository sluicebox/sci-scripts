;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 635)
(include sci.sh)
(use Main)
(use GloryRm)
(use Motion)
(use Actor)
(use System)

(public
	rm635 0
)

(instance rm635 of GloryRm
	(properties
		picture 630
	)

	(method (init)
		(gGlory handsOff:)
		(ClearFlag 6)
		(gEgo
			view: 160
			loop: 0
			cel: 0
			x: 158
			y: 140
			priority: 144
			scaleX: 113
			scaleY: 113
			setScale:
			fixPriority: 1
			init:
		)
		(townFolk init:)
		(fire setCycle: Fwd init:)
		(candles setCycle: Fwd init:)
		(burgomeister scaleX: 117 scaleY: 117 setScale: init:)
		(innKeeper scaleX: 117 scaleY: 117 setScale: setCycle: Fwd init:)
		(bella scaleX: 120 scaleY: 120 setScale: init:)
		(tanya scaleX: 119 scaleY: 119 setScale: init:)
		(gypsy scaleX: 115 scaleY: 115 setScale: init:)
		(igor scaleX: 120 scaleY: 120 setScale: init:)
		(cranium scaleX: 120 scaleY: 120 setScale: init:)
		(shopKeeper scaleX: 120 scaleY: 120 setScale: setCycle: Fwd init:)
		(gateKeeper scaleX: 116 scaleY: 116 setScale: init:)
		(moreTown scaleX: 134 scaleY: 134 setScale: init:)
		(mor scaleX: 125 scaleY: 125 setScale: init:)
		(mormor scaleX: 117 scaleY: 117 setScale: init:)
		(mortown init:)
		(evenmor scaleX: 113 scaleY: 113 setScale: init:)
		(mormormor scaleX: 112 scaleY: 112 setScale: init:)
		(aaahg scaleX: 112 scaleY: 112 setScale: init:)
		(whew scaleX: 115 scaleY: 115 setScale: init:)
		(evenmormor scaleX: 112 scaleY: 112 setScale: init:)
		(mormormorMore scaleX: 136 scaleY: 136 setScale: init:)
		(gCurRoom setScript: rewardCeremony)
		(super init:)
	)
)

(instance rewardCeremony of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 360)
			)
			(1
				(gMessager say: 2 6 3 0 self) ; "Two weeks pass from the final encounter in the Dark One's Cave. Your friends and acquaintances in Mordavia hold a party in your honor at Castle Borgov."
			)
			(2
				(gMessager say: 1 6 1 0 self) ; "So even as we speak, the swamp is drying up. Soon the pass will open, and we may trade with the outside world."
			)
			(3
				(gMessager say: 2 6 2 0 self) ; "The people fill the room with their cheers."
			)
			(4
				(gMessager say: 3 6 4 0 self) ; "He returned Tanya to us. For that, we shall be forever grateful."
			)
			(5
				(gMessager say: 2 6 5 0 self) ; "Everyone again gives a cheer of happiness."
			)
			(6
				(gMessager say: 2 6 6 0 self) ; "You suddenly hear a familiar pair of voices."
			)
			(7
				(innKeeper setCycle: 0 signal: (& (innKeeper signal:) $fffe))
				(shopKeeper setCycle: 0 signal: (& (shopKeeper signal:) $fffe))
				(gEgo
					view: 161
					scaleX: 128
					scaleY: 128
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(8
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(9
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(10
				(gCurRoom newRoom: 52) ; CharSave
				(self dispose:)
			)
		)
	)
)

(instance fire of Prop
	(properties
		x 163
		y 71
		view 631
		loop 1
	)
)

(instance candles of Prop
	(properties
		x 92
		y 39
		view 631
	)
)

(instance burgomeister of View
	(properties
		x 180
		y 142
		view 160
		cel 1
	)
)

(instance innKeeper of Prop
	(properties
		x 130
		y 143
		view 160
		loop 2
		cel 5
	)
)

(instance bella of View
	(properties
		x 124
		y 147
		view 160
		cel 2
	)
)

(instance tanya of View
	(properties
		x 131
		y 145
		view 160
		cel 3
	)
)

(instance gypsy of View
	(properties
		x 146
		y 138
		view 160
		cel 4
	)
)

(instance igor of View
	(properties
		x 199
		y 140
		view 160
		cel 5
	)
)

(instance cranium of View
	(properties
		x 215
		y 146
		view 160
		cel 6
	)
)

(instance shopKeeper of Prop
	(properties
		x 222
		y 148
		view 160
		loop 4
		cel 3
	)
)

(instance gateKeeper of View
	(properties
		x 227
		y 141
		view 160
		cel 7
	)
)

(instance townFolk of View
	(properties
		x 213
		y 161
		view 263
		cel 7
	)
)

(instance mortown of View
	(properties
		x 111
		y 161
		view 263
		cel 5
	)
)

(instance mor of View
	(properties
		x 96
		y 156
		view 263
		cel 4
	)
)

(instance mormor of View
	(properties
		x 241
		y 143
		view 263
		loop 1
		cel 3
	)
)

(instance moreTown of View
	(properties
		x 119
		y 172
		view 263
		loop 3
		cel 4
	)
)

(instance evenmor of View
	(properties
		x 200
		y 136
		view 263
		loop 3
		cel 3
	)
)

(instance mormormor of View
	(properties
		x 72
		y 121
		view 263
		loop 1
	)
)

(instance aaahg of View
	(properties
		x 92
		y 98
		view 263
		loop 1
		cel 1
	)
)

(instance whew of View
	(properties
		x 263
		y 139
		view 263
		loop 2
	)
)

(instance evenmormor of View
	(properties
		x 251
		y 130
		view 263
		cel 2
	)
)

(instance mormormorMore of View
	(properties
		x 178
		y 180
		view 263
		loop 3
		cel 5
	)
)

