;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 102)
(include sci.sh)
(use Main)
(use CyclingProp)
(use n957)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	intro2Rm 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(creditTitle hide:)
	(creditTitle2 hide:)
	(dash dispose:)
	(views eachElementDo: #dispose release:)
)

(procedure (localproc_1 param1 param2 param3 param4 param5)
	(views
		add:
			((View new:)
				view: param1
				loop: param2
				cel: param3
				x: param4
				y: param5
				init:
				setPri: 12
				yourself:
			)
	)
)

(instance intro2Rm of Rm
	(properties)

	(method (init)
		(super init:)
		(self curPic: 100)
		(gIceMouseDownHandler add: self)
		(gIceKeyDownHandler add: self)
		(LoadMany rsVIEW 56 60 400 500 600 700 800 899)
		((= local0 (CyclingProp new:))
			view: 500
			loop: 0
			x: 114
			y: 122
			ignoreActors: 1
			init:
		)
		(global102 client: self)
		(self setScript: creditScript)
	)

	(method (dispose)
		(views dispose:)
		(gIceMouseDownHandler delete: self)
		(gIceKeyDownHandler delete: self)
		(HandsOn)
		(global102 dispose:)
		(super dispose:)
	)

	(method (cue)
		(if (and script (not local1))
			((LastLink 118 self) cue:)
			(if (== (global102 signal:) -1)
				(= local1 1)
			)
		)
	)

	(method (handleEvent)
		(self newRoom: 1) ; openingScene
	)
)

(instance creditScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(gGame setCursor: gTheCursor 0)
				(self setScript: kenWilliamsScript self)
			)
			(2
				(localproc_0)
				(= cycles 2)
			)
			(3
				(self setScript: jimWallsScript self)
			)
			(4
				(localproc_0)
				(= cycles 2)
			)
			(5
				(self setScript: gurukaScript self)
			)
			(6
				(localproc_0)
				(= cycles 2)
			)
			(7
				(self setScript: programmerScript self)
			)
			(8
				(localproc_0)
				(= cycles 2)
			)
			(9
				(self setScript: artScript self)
			)
			(10
				(localproc_0)
				(= cycles 2)
			)
			(11
				(self setScript: musicScript self)
			)
			(12
				(localproc_0)
				(= cycles 2)
			)
			(13
				(self setScript: systemScript self)
			)
			(14
				(localproc_0)
				(= cycles 2)
			)
			(15
				(self setScript: thanksScript self)
			)
			(16
				(= cycles 2)
			)
			(17
				(gCurRoom newRoom: 1) ; openingScene
			)
		)
	)
)

(instance kenWilliamsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(creditTitle loop: 7 cel: 0 x: 63 y: 27 init:)
				(creditTitle2 init:)
				(dash init: 147 55)
				(= seconds 1)
			)
			(1
				(localproc_1 400 3 9 18 83)
				(localproc_1 400 3 4 31 83)
				(localproc_1 400 3 12 45 83)
				(localproc_1 400 4 2 70 83)
				(localproc_1 400 3 7 81 83)
				(localproc_1 400 3 10 90 83)
				(localproc_1 400 3 10 101 83)
				(localproc_1 400 3 7 109 83)
				(localproc_1 400 3 0 119 83)
				(localproc_1 400 3 11 133 83)
				(localproc_1 400 4 0 148 83)
				(if local1
					(= seconds 10)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance jimWallsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(creditTitle loop: 2 cel: 0 x: 83 y: 39 show:)
				(dash init: 156 45)
				(= seconds 1)
			)
			(1
				(localproc_1 400 3 8 18 75)
				(localproc_1 400 3 7 27 75)
				(localproc_1 400 3 11 38 75)
				(localproc_1 400 4 2 64 75)
				(localproc_1 400 3 0 78 75)
				(localproc_1 400 3 10 90 75)
				(localproc_1 400 3 10 101 75)
				(localproc_1 400 4 0 113 75)
				(if local1
					(= seconds 10)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance gurukaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(creditTitle2 loop: 6 cel: 0 x: 75 y: 25 show:)
				(dash init: 150 31)
				(= seconds 1)
			)
			(1
				(localproc_1 400 3 5 18 62)
				(localproc_1 400 4 5 31 62)
				(localproc_1 400 3 15 44 62)
				(localproc_1 400 4 5 58 62)
				(localproc_1 400 3 9 71 62)
				(localproc_1 400 3 0 83 62)
				(localproc_1 400 4 0 102 62)
				(localproc_1 400 3 7 110 62)
				(localproc_1 400 3 12 121 62)
				(localproc_1 400 3 5 134 62)
				(localproc_1 400 3 6 146 62)
				(localproc_1 400 3 9 18 80)
				(localproc_1 400 3 6 29 80)
				(localproc_1 400 3 0 43 80)
				(localproc_1 400 3 10 55 80)
				(localproc_1 400 4 0 66 80)
				(localproc_1 400 3 0 78 80)
				(if local1
					(= seconds 10)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance programmerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(creditTitle loop: 1 cel: 0 x: 101 y: 29 show:)
				(dash init: 168 35)
				(= seconds 1)
			)
			(1
				(self setScript: jmhScript self)
			)
			(2
				(self setScript: pabloScript self)
			)
			(3
				(self setScript: dougScript)
				(if local1
					(= seconds 10)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance jmhScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 400 3 8 18 65)
				(localproc_1 400 4 4 27 65)
				(localproc_1 400 3 11 44 65)
				(localproc_1 400 3 0 60 65)
				(localproc_1 400 3 15 73 65)
				(localproc_1 400 3 9 87 65)
				(localproc_1 400 3 6 105 65)
				(localproc_1 400 3 13 119 65)
				(localproc_1 400 3 13 132 65)
				(localproc_1 400 3 3 144 65)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance pabloScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 400 3 14 18 86)
				(localproc_1 400 3 0 31 86)
				(localproc_1 400 3 1 43 86)
				(localproc_1 400 3 10 56 86)
				(localproc_1 400 3 13 68 86)
				(localproc_1 400 3 5 90 86)
				(localproc_1 400 3 6 102 86)
				(localproc_1 400 3 4 116 86)
				(localproc_1 400 3 12 130 86)
				(localproc_1 400 3 7 139 86)
				(localproc_1 400 4 0 148 86)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance dougScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 400 3 3 18 107)
				(localproc_1 400 3 13 31 107)
				(localproc_1 400 4 5 43 107)
				(localproc_1 400 3 5 56 107)
				(localproc_1 400 3 13 78 107)
				(localproc_1 400 3 10 90 107)
				(localproc_1 400 3 3 102 107)
				(localproc_1 400 4 6 116 107)
				(localproc_1 400 3 7 125 107)
				(localproc_1 400 3 4 136 107)
				(localproc_1 400 3 10 148 107)
				(localproc_1 400 3 3 160 107)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance scottScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 400 3 10 18 86)
				(localproc_1 400 3 0 31 86)
				(localproc_1 400 3 15 44 86)
				(localproc_1 400 3 15 58 86)
				(localproc_1 400 4 3 72 86)
				(localproc_1 400 4 0 96 86)
				(localproc_1 400 3 2 109 86)
				(localproc_1 400 3 13 120 86)
				(localproc_1 400 4 1 133 86)
				(localproc_1 400 4 1 146 86)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance artScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(creditTitle loop: 0 cel: 0 x: 37 y: 33 show:)
				(creditTitle2 loop: 0 cel: 1 x: 114 y: 30 show:)
				(dash init: 159 35)
				(= seconds 1)
			)
			(1
				(self setScript: cheriScript self)
			)
			(2
				(self setScript: jimLarsenScript)
				(if local1
					(= seconds 10)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance cheriScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 400 3 2 18 62)
				(localproc_1 400 3 6 30 62)
				(localproc_1 400 3 4 44 62)
				(localproc_1 400 3 15 57 62)
				(localproc_1 400 4 3 69 62)
				(localproc_1 400 3 10 80 62)
				(localproc_1 400 3 10 100 62)
				(localproc_1 400 3 13 112 62)
				(localproc_1 400 4 3 124 62)
				(localproc_1 400 3 3 135 62)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance jimLarsenScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 400 3 8 18 88)
				(localproc_1 400 3 7 27 88)
				(localproc_1 400 3 11 38 88)
				(localproc_1 400 3 10 63 88)
				(localproc_1 400 3 0 74 88)
				(localproc_1 400 3 15 87 88)
				(localproc_1 400 4 0 100 88)
				(localproc_1 400 3 4 112 88)
				(localproc_1 400 3 12 126 88)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance musicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(creditTitle loop: 8 cel: 0 x: 65 y: 32 show:)
				(dash init: 143 36)
				(= seconds 1)
			)
			(1
				(localproc_1 400 3 11 18 64)
				(localproc_1 400 3 0 34 64)
				(localproc_1 400 3 15 47 64)
				(localproc_1 400 3 6 60 64)
				(localproc_1 400 4 0 80 64)
				(localproc_1 400 3 4 94 64)
				(localproc_1 400 3 7 103 64)
				(localproc_1 400 3 1 113 64)
				(localproc_1 400 3 4 127 64)
				(localproc_1 400 3 15 140 64)
				(localproc_1 400 4 1 152 64)
				(if local1
					(= seconds 10)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance systemScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(creditTitle loop: 9 cel: 0 x: 34 y: 26 show:)
				(creditTitle2 loop: 9 cel: 1 x: 124 y: 25 show:)
				(= seconds 1)
			)
			(1
				(self setScript: jeffScript self)
			)
			(2
				(self setScript: bobScript self)
			)
			(3
				(self setScript: systemPabloScript self)
			)
			(4
				(self setScript: stuScript)
				(if local1
					(= seconds 10)
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance jeffScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 400 3 8 8 43)
				(localproc_1 400 3 4 21 43)
				(localproc_1 400 4 6 34 43)
				(localproc_1 400 4 6 47 43)
				(localproc_1 400 4 0 64 43)
				(localproc_1 400 4 1 75 43)
				(localproc_1 400 3 4 88 43)
				(localproc_1 400 3 14 101 43)
				(localproc_1 400 3 6 112 43)
				(localproc_1 400 3 4 125 43)
				(localproc_1 400 3 12 138 43)
				(localproc_1 400 4 0 149 43)
				(localproc_1 400 3 13 160 43)
				(localproc_1 400 3 12 172 43)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance bobScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 400 3 1 8 62)
				(localproc_1 400 3 13 21 62)
				(localproc_1 400 3 1 33 62)
				(localproc_1 400 3 6 52 62)
				(localproc_1 400 3 4 65 62)
				(localproc_1 400 3 7 73 62)
				(localproc_1 400 4 1 82 62)
				(localproc_1 400 3 11 96 62)
				(localproc_1 400 3 0 111 62)
				(localproc_1 400 3 12 124 62)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance systemPabloScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 400 3 14 8 80)
				(localproc_1 400 3 0 20 80)
				(localproc_1 400 3 1 32 80)
				(localproc_1 400 3 10 44 80)
				(localproc_1 400 3 13 55 80)
				(localproc_1 400 3 5 74 80)
				(localproc_1 400 3 6 85 80)
				(localproc_1 400 3 4 98 80)
				(localproc_1 400 3 12 111 80)
				(localproc_1 400 3 7 119 80)
				(localproc_1 400 4 0 127 80)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance stuScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 400 4 0 6 99)
				(localproc_1 400 4 1 17 99)
				(localproc_1 400 4 5 30 99)
				(localproc_1 400 3 0 42 99)
				(localproc_1 400 3 15 54 99)
				(localproc_1 400 4 1 66 99)
				(localproc_1 400 3 5 81 99)
				(localproc_1 400 3 13 93 99)
				(localproc_1 400 3 10 104 99)
				(localproc_1 400 3 3 114 99)
				(localproc_1 400 4 0 125 99)
				(localproc_1 400 4 1 136 99)
				(localproc_1 400 3 4 149 99)
				(localproc_1 400 3 7 157 99)
				(localproc_1 400 3 12 167 99)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance thanksScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(creditTitle loop: 7 cel: 1 x: 79 y: 27 show:)
				(dash init: 149 29)
				(= seconds 1)
			)
			(1
				(self setScript: bobStewartScript self)
			)
			(2
				(usNavy init:)
				(if local1
					(= seconds 10)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance bobStewartScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 400 3 1 14 61)
				(localproc_1 400 3 13 28 61)
				(localproc_1 400 3 1 41 61)
				(localproc_1 400 4 0 59 61)
				(localproc_1 400 4 1 70 61)
				(localproc_1 400 3 4 83 61)
				(localproc_1 400 4 2 97 61)
				(localproc_1 400 3 0 111 61)
				(localproc_1 400 3 15 123 61)
				(localproc_1 400 4 1 135 61)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance jimTracyScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 400 3 8 14 64)
				(localproc_1 400 3 7 23 64)
				(localproc_1 400 3 11 34 64)
				(localproc_1 400 4 1 54 64)
				(localproc_1 400 3 15 67 64)
				(localproc_1 400 3 0 80 64)
				(localproc_1 400 3 2 92 64)
				(localproc_1 400 4 3 104 64)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance usNavy of View
	(properties
		y 83
		x 9
		view 500
		loop 3
	)
)

(instance dash of Prop
	(properties
		y 45
		x 156
		view 400
		loop 5
	)

	(method (init param1 param2)
		(super init:)
		(if (== global132 2)
			(self posn: param1 param2 cel: 0 setCycle: Beg self)
		else
			(self posn: param1 param2 setCel: 0)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance creditTitle of View
	(properties
		y 39
		x 83
		view 400
		loop 2
	)
)

(instance creditTitle2 of View
	(properties
		y 49
		x 79
		view 400
		loop 6
	)
)

(instance views of Collect
	(properties)
)

