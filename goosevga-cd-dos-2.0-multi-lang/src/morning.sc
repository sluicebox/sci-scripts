;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 94)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	morning 0
)

(local
	local0
	[local1 2]
)

(procedure (localproc_0 param1) ; UNUSED
	(param1 signal: (& (| (param1 signal:) $0100) $fffd))
)

(instance morning of Rm
	(properties
		picture 60
	)

	(method (init &tmp temp0)
		(= global124 (GetPort))
		(SetPort 0)
		(Graph grFILL_BOX 0 0 200 320 2 0 0 0)
		(Graph grFILL_BOX 0 0 200 320 1 0 0 0)
		(Graph grUPDATE_BOX 0 0 200 320 1)
		(SetPort 0 0 189 319 0 0)
		(if (= local0 (== (mod global114 2) 0))
			(= picture 61)
			(train init:)
			(ball init:)
			(mitt init:)
		else
			(doll init:)
			(shoes init:)
		)
		(child init:)
		(eyes init:)
		(deskTop init:)
		(photo init:)
		(book init:)
		(super init:)
		(super setScript: sunrise)
		(= global104 0)
		(= global176 1)
		(Animate (gCast elements:) 1)
		(for ((= temp0 0)) (<= temp0 100) ((+= temp0 4))
			(Palette palSET_INTENSITY 0 255 temp0)
			(Wait 2)
		)
	)

	(method (dispose)
		(gCast eachElementDo: #dispose)
		(Animate (gCast elements:) 0)
		(SetPort global124)
		(super dispose:)
	)
)

(instance sunrise of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sun init:)
				(if local0
					(sun posn: 158 100)
				)
				(= cycles 1)
			)
			(1
				(gLongSong stop: prevSignal: 0 number: 3 loop: 1 play:)
				(sun setCycle: End self)
			)
			(2
				(sun addToPic:)
				(bird init: setCycle: Fwd)
				(if local0
					(bird posn: 137 99)
				)
				(= cycles 10)
			)
			(3
				(if (!= (gLongSong prevSignal:) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(bird setCycle: CT 0 1 self)
			)
			(5
				(gEgo posn: 92 116)
				(gGame setCursor: 901 1)
				(switch
					(Print 94 0 #mode 1 #button {Play another game} 0 #button {Quit} 1) ; "You finished!!"
					(0
						(= global176 1)
						(= global113 100)
						(gCurRoom newRoom: 90) ; intro
					)
					(1
						(= gQuit 1)
					)
				)
				(if (StrAt gCurSaveDir 0)
					(StrAt @global190 4 126)
					(gGame save:)
				)
				(TheMenuBar state: 0)
				(gCast eachElementDo: #dispose)
				(for ((= global108 100)) (>= global108 0) ((-= global108 8))
					(Palette palSET_INTENSITY 0 255 global108)
					(Wait 2)
				)
				(Animate (gCast elements:) 0)
			)
		)
	)
)

(instance sun of Prop
	(properties
		y 99
		x 159
		view 873
		cycleSpeed 10
	)
)

(instance bird of Prop
	(properties
		y 98
		x 138
		view 873
		loop 1
		priority 11
		signal 16
		cycleSpeed 2
	)
)

(instance book of View
	(properties
		y 115
		x 278
		view 891
		loop 2
		priority 14
		signal 26897
	)

	(method (init)
		(if local0
			(= view 870)
			(= x 276)
			(= y 116)
			(= loop 5)
		)
		(super init:)
	)
)

(instance deskTop of View
	(properties
		y 145
		x 21
		view 890
		loop 4
		signal 26881
	)

	(method (init)
		(if local0
			(= view 871)
			(= x 20)
			(= y 137)
			(= loop 0)
		)
		(super init:)
	)
)

(instance train of View
	(properties
		y 166
		x 218
		view 870
		loop 3
		cel 13
		signal 26881
	)
)

(instance photo of View
	(properties
		y 82
		x 250
		view 891
		loop 3
		signal 26881
	)

	(method (init)
		(if local0
			(= view 871)
			(= y 82)
			(= loop 4)
		)
		(super init:)
	)
)

(instance ball of View
	(properties
		y 91
		x 238
		view 870
		priority 14
		signal 26897
	)
)

(instance mitt of View
	(properties
		y 137
		x 245
		view 870
		loop 1
	)
)

(instance doll of View
	(properties
		y 142
		x 243
		view 890
		signal 26881
	)
)

(instance shoes of View
	(properties
		y 182
		x 110
		view 890
		loop 3
		signal 26881
	)
)

(instance child of View
	(properties
		y 128
		x 76
	)

	(method (init)
		(if local0
			(= x 73)
			(= y 128)
		)
		(= view (+ 850 global114))
		(super init:)
	)
)

(instance eyes of Prop
	(properties
		y 103
		x 83
		loop 1
		priority 14
		signal 16
	)

	(method (init)
		(if local0
			(= view 900)
			(= x 83)
			(= y 103)
		)
		(= view (child view:))
		(super init:)
		(self setScript: blink)
	)
)

(instance blink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eyes cel: 0 setCycle: End self)
			)
			(1
				(eyes setCycle: Beg)
				(= state -1)
				(= seconds (Random 3 5))
			)
		)
	)
)

