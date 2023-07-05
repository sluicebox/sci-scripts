;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 216)
(include sci.sh)
(use Main)
(use n013)
(use ForwardCounter)
(use Cursor)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm216 0
)

(local
	local0
	local1
	local2
)

(instance rm216 of Room
	(properties
		picture 210
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(= local2 (GK keepBar:))
		(GK keepBar: 0)
		(gTheIconBar disable: erase:)
		(Load rsMESSAGE 210)
		(chair init:)
		(gabsMug init:)
		(painting init:)
		(ashTray init:)
		(artSupplies init:)
		(coffeePot init:)
		(newsPaper init:)
		(gracesCoat init:)
		(windows init:)
		(behindDoor init:)
		(graceProp init:)
		(shopDoor init:)
		(gCurRoom setScript: kidnapGrace)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(GK keepBar: local2)
		(if (GK keepBar:)
			(gTheIconBar draw:)
		)
		(DisposeScript 64956)
		(super dispose:)
	)
)

(instance kidnapGrace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(graceProp
					setCel: 0
					setLoop: 0
					cycleSpeed: 10
					setCycle: ForwardCounter 5
				)
				(gMessager say: 11 0 63 1 self 210) ; "(SPEAKING ON PHONE TO GERMANY. WORRIED)But why did he go to Africa, Gerde?"
			)
			(2
				(= seconds 3)
			)
			(3
				(graceProp
					setCel: 0
					setLoop: 0
					cycleSpeed: 10
					setCycle: ForwardCounter 5
				)
				(gMessager say: 11 0 63 2 self 210) ; "<sigh>No, it's okay. I'm just a little...anxious."
			)
			(4
				(= seconds 3)
			)
			(5
				(graceProp
					setCel: 0
					setLoop: 0
					cycleSpeed: 10
					setCycle: ForwardCounter 5
				)
				(gMessager say: 11 0 63 3 self 210) ; "No, they haven't. I just need to talk to Gabriel."
			)
			(6
				(= seconds 3)
			)
			(7
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(8
				(gCast eachElementDo: #hide)
				(= local1 (gGame setCursor:))
				(gGame setCursor: myInvisCursor)
				(SetCursor 0)
				(gCurRoom drawPic: 99 0)
				(= cycles 2)
			)
			(9
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 1)
				)
				(= cycles 1)
			)
			(10
				(Palette 2 0 255 100) ; PalIntensity
				(if (IsFlag 470)
					(self setScript: flopMovie self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{PAN2.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {PAN2.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(11
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 0)
				)
				(= cycles 1)
			)
			(12
				(gCurRoom drawPic: 210)
				(gGame setCursor: local1)
				(chair show:)
				(gabsMug show:)
				(painting show:)
				(ashTray show:)
				(artSupplies show:)
				(coffeePot show:)
				(newsPaper show:)
				(gracesCoat show:)
				(windows show:)
				(behindDoor show:)
				(graceProp show: view: 208 setCel: 0 setLoop: 3)
				(gGkSound1 number: 222 setLoop: 1 play:)
				(shopDoor show: setCycle: End self)
			)
			(13
				(graceProp view: 208 setCel: 0 setLoop: 3 setCycle: End self)
				(gMessager say: 11 0 63 4 self 210) ; "(SCREAM OF TERROR--SHE'S ATTACKED BY TETELO)Ahhhhh!"
				(SetCursor 1)
				(gGame setCursor: local1 1)
			)
			(14)
			(15
				(for ((= local0 100)) (>= local0 0) ((-= local0 2))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 2)
			)
			(16
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 99 14)
				(= cycles 1)
			)
			(17
				(if (== (gGame printLang:) 49)
					(one init: cycleSpeed: 8 setCycle: End self)
				else
					(self cue:)
				)
			)
			(18
				(if (== (gGame printLang:) 49)
					(zero init: cycleSpeed: 8 setCycle: End self)
				else
					(self cue:)
				)
			)
			(19
				(if (== (gGame printLang:) 49)
					(dayPeriod init: setCycle: End self)
				else
					(self cue:)
				)
			)
			(20
				(day init: cycleSpeed: 8 setCycle: End self)
			)
			(21
				(if (== (gGame printLang:) 49)
					(self cue:)
				else
					(one init: cycleSpeed: 8 setCycle: End self)
				)
			)
			(22
				(if (== (gGame printLang:) 49)
					(self cue:)
				else
					(zero init: cycleSpeed: 8 setCycle: End self)
				)
			)
			(23
				(gMessager say: 11 0 63 6 self 210) ; ""Deep in the earth I faced a fight that I could never win. The blameless and the base destroyed, and all that might have been."--Gabriel Knight"
			)
			(24
				(gCurRoom newRoom: 750)
			)
		)
	)
)

(instance flopMovie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 137 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 138 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 139 14)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 140 14)
				(= cycles 2)
			)
			(4
				(gCurRoom drawPic: 143 14)
				(= cycles 2)
			)
			(5
				(gCurRoom drawPic: 144 14)
				(= cycles 2)
			)
			(6
				(gCurRoom drawPic: 145 14)
				(= cycles 2)
			)
			(7
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance graceProp of Prop
	(properties
		x 251
		y 115
		view 211
	)
)

(instance shopDoor of Prop
	(properties
		x 93
		y 88
		view 2103
	)
)

(instance day of Prop
	(properties
		x 31
		y 68
		view 375
	)

	(method (init)
		(= x (proc13_6 136 31 31 31 31))
		(= y (proc13_6 40 68 68 68 68))
		(super init:)
	)
)

(instance one of Prop
	(properties
		x 195
		y 40
		view 375
		loop 1
	)

	(method (init)
		(= x (proc13_6 46 195 195 195 195))
		(= y (proc13_6 120 40 40 40 40))
		(super init: &rest)
	)
)

(instance zero of Prop
	(properties
		x 265
		y 27
		view 375
		loop 10
	)

	(method (init)
		(= x (proc13_6 81 265 265 265 265))
		(= y (proc13_6 43 27 27 27 27))
		(super init: &rest)
	)
)

(instance dayPeriod of Prop
	(properties
		x 90
		y 115
		view 375
		loop 11
	)

	(method (init)
		(super init: &rest)
		(self setPri: 160)
	)
)

(instance windows of Prop
	(properties
		y 77
		view 2103
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 13)
	)
)

(instance behindDoor of Prop
	(properties
		x 71
		y 48
		view 2103
		loop 1
		cel 1
	)
)

(instance chair of View
	(properties
		x 258
		y 101
		cel 9
	)

	(method (init)
		(= view (if (IsHiRes) 10210 else 210))
		(super init: &rest)
	)
)

(instance gabsMug of View
	(properties
		x 118
		y 115
		cel 7
	)

	(method (init)
		(= view (if (IsHiRes) 10210 else 210))
		(self setPri: 11)
	)
)

(instance painting of View
	(properties
		x 269
		y 48
		cel 8
	)

	(method (init)
		(= view (if (IsHiRes) 10210 else 210))
		(super init: &rest)
	)
)

(instance ashTray of View
	(properties
		x 227
		y 81
		cel 3
	)

	(method (init)
		(= view (if (IsHiRes) 10210 else 210))
		(super init:)
		(self setPri: 8)
	)
)

(instance artSupplies of View
	(properties
		x 279
		y 103
		cel 11
	)

	(method (init)
		(= view (if (IsHiRes) 10210 else 210))
		(super init: &rest)
	)
)

(instance coffeePot of View
	(properties
		x 94
		y 117
		cel 6
	)

	(method (init)
		(= view (if (IsHiRes) 10210 else 210))
		(self setPri: 13)
		(super init: &rest)
	)
)

(instance newsPaper of View
	(properties
		x 136
		y 154
		z 31
		cel 2
	)

	(method (init)
		(= view (if (IsHiRes) 10210 else 210))
		(super init: &rest)
	)
)

(instance gracesCoat of View
	(properties
		x 111
		y 60
	)

	(method (init)
		(= view (if (IsHiRes) 10210 else 210))
		(super init: &rest)
	)
)

(instance myInvisCursor of Cursor
	(properties
		view 996
	)
)

