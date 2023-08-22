;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use n814)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm30 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(instance rm30 of Rm
	(properties
		noun 12
		picture 30
		style 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(80 ; calmSpell
				(if local1
					(= local2 1)
				else
					(self setScript: warning)
				)
			)
			(78 ; dazzleSpell
				(if local1
					(= local2 1)
				else
					(self setScript: warning)
				)
			)
			(50 ; detectMagicSpell
				(if local1
					(= local2 1)
				else
					(self setScript: warning)
				)
			)
			(82 ; fetchSpell
				(if local1
					(= local2 1)
				else
					(self setScript: warning)
				)
			)
			(51 ; openSpell
				(if local1
					(= local2 1)
				else
					(self setScript: warning)
				)
			)
			(77 ; triggerSpell or Pickup Inventory
				(if local1
					(= local2 1)
				else
					(self setScript: warning)
				)
			)
			(79 ; zapSpell
				(if local1
					(= local2 1)
				else
					(self setScript: warning)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(= gUseSortedFeatures local6)
		(SetFlag 20)
		(super dispose:)
	)

	(method (cue)
		(gMessager say: 17 1 6 2) ; "This would not be someone to trifle with, for he looks subtle and quick to anger."
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 243 189 243 186 315 186 315 125 294 125 294 92 291 91 291 105 275 116 253 111 237 119 205 115 183 124 153 126 139 133 150 142 136 153 125 150 105 114 195 59 223 48 166 8 161 11 186 40 198 42 205 50 196 52 103 105 63 107 86 140 92 159 73 162 62 156 44 138 30 132 25 106 22 106 24 128 0 128 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 173 144 250 125 292 153 209 175
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 147 134 168 130 184 138 157 142
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 1 139 21 138 21 159 71 175 80 172 94 170 102 179 117 181 119 189 0 189
					yourself:
				)
		)
		(LoadMany rsVIEW 530 30 199)
		(LoadMany rsSOUND 28)
		(super init:)
		(gLongSong number: 115 loop: -1 init: play:)
		(bobSound init:)
		(= local6 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(gFeatures
			add:
				rug
				armor
				ceiling
				stool
				foreGround
				vase
				bookShelf
				table
				theCasket
				westWall
				eastWall
				westStair
				eastStair
			eachElementDo: #init
		)
		(SolvePuzzle 658 3)
		(SL enable:)
		(NormalEgo)
		(gEgo posn: 160 189 init: setScript: intro)
		(peacock posn: 216 135 init: setScript: showFeathers)
		(dragon posn: 318 77 init: stopUpd:)
		(casket setPri: 15 posn: 49 169 init: stopUpd:)
		(dunker setPri: 11 posn: 235 125 init: setScript: swingBird)
		(theWiz setPri: 1 posn: 122 76 init: stopUpd:)
		(fenrus setPri: 15 posn: 263 171 init: stopUpd:)
		(lamp setPri: 8 posn: 157 77 init: setCycle: Fwd)
	)

	(method (doit)
		(cond
			((== (self script:) teleportOut))
			(local2
				(HandsOff)
				(= local2 0)
				(self setScript: teleportOut)
			)
			((and (< (gEgo y:) 40) (not local0))
				(HandsOff)
				(= local0 1)
				(gEgo setScript: intoTheTower)
			)
			((and (== (gEgo edgeHit:) EDGE_BOTTOM) (not local5))
				(HandsOff)
				(= local5 1)
				(= local2 1)
			)
			((and (== (gEgo onControl: 1) 2) (not local4))
				(HandsOff)
				(gEgo setMotion: 0 setCycle: 0 setLoop: (gEgo loop:))
				(= local4 1)
				(= local2 1)
			)
		)
		(super doit:)
	)
)

(instance Magic of Prop
	(properties
		view 530
		cycleSpeed 2
	)
)

(instance peacock of Prop
	(properties
		noun 11
		view 30
		loop 7
		priority 11
		signal 16400
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if (> (peacock cel:) 0)
					(gMessager say: 11 1 1) ; "You admire the plumage on the peacock."
					(showFeathers changeState: 3)
				else
					(gMessager say: 11 1 2) ; "The poor stuffed peacock seems bedraggled, worn, and over-used."
					(showFeathers changeState: 1)
				)
			)
			(4 ; Do
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(2 ; Talk
				(gMessager say: 11 57 0) ; "The peacock doesn't respond. Maybe its ears are too stuffed to hear."
			)
			(12 ; sword
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(16 ; dagger
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(81 ; flameDartSpell
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(20 ; rock
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance dragon of Prop
	(properties
		z 40
		noun 5
		view 30
		loop 2
		cycleSpeed 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local1
					(= local2 1)
				else
					(self setScript: warning)
				)
			)
			(12 ; sword
				(if local1
					(= local2 1)
				else
					(self setScript: warning)
				)
			)
			(16 ; dagger
				(if local1
					(= local2 1)
				else
					(self setScript: warning)
				)
			)
			(81 ; flameDartSpell
				(if local1
					(= local2 1)
				else
					(self setScript: warning)
				)
			)
			(20 ; rock
				(if local1
					(= local2 1)
				else
					(self setScript: warning)
				)
			)
			(2 ; Talk
				(gMessager say: 5 57) ; "The head doesn't respond; it looks like it's draggin'."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance casket of Prop
	(properties
		noun 3
		view 30
		loop 6
		signal 16384
		cycleSpeed 12
	)

	(method (cue)
		(self cel: 0)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(self setCycle: End self)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance dunker of Prop
	(properties
		noun 6
		view 30
		loop 4
		signal 16384
		cycleSpeed 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local7
					(= local7 0)
					(self setScript: swingBird)
				else
					(= local7 1)
					(gMessager say: 6 4) ; "Looks like you've slammed the dunker."
					(self setScript: 0 setLoop: 5 setCycle: End)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance theWiz of Prop
	(properties
		noun 17
		view 30
		loop 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 21)
					(gMessager say: 17 1 5) ; "You wonder if the portrait of Erasmus is really a painting, or something completely different."
				else
					(gMessager say: 17 1 6 1 gCurRoom) ; "Your eyes are drawn to the eyes of the figure in the portrait. His intense stare is unnerving."
				)
			)
			(4 ; Do
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(12 ; sword
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(16 ; dagger
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(81 ; flameDartSpell
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(20 ; rock
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fenrus of Prop
	(properties
		noun 8
		view 199
		loop 1
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(12 ; sword
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(16 ; dagger
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(81 ; flameDartSpell
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(20 ; rock
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lamp of Prop
	(properties
		noun 10
		view 30
		loop 1
		signal 16384
		cycleSpeed 5
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(12 ; sword
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(16 ; dagger
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(81 ; flameDartSpell
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(20 ; rock
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rug of Feature
	(properties
		noun 13
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(12 ; sword
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(16 ; dagger
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(81 ; flameDartSpell
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(20 ; rock
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 119 189 91 157 131 148 182 189
		)
		(super init:)
	)
)

(instance armor of Feature
	(properties
		noun 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(12 ; sword
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(16 ; dagger
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(81 ; flameDartSpell
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(20 ; rock
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 89 104 71 106 63 71 65 56 73 40 82 46 89 23 95 29 89 49 91 68
		)
		(super init:)
	)
)

(instance ceiling of Feature
	(properties
		noun 4
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 1) ; Look
			(gMessager say: 4 1 0) ; "From the looks of the ceiling, this castle must be a gigantic geode."
		else
			(super doVerb: theVerb invItem &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 319 25 303 30 296 20 277 23 269 18 263 26 252 20 244 12 231 4 230 9 224 8 222 13 214 12 206 9 198 9 197 6 190 2 186 5 186 11 174 11 170 6 163 14 155 17 137 16 134 12 121 21 89 15 91 10 86 9 81 12 74 12 70 8 56 24 47 12 41 15 32 11 30 19 17 18 16 32 0 30 0 0 319 0
		)
		(super init:)
	)
)

(instance stool of Feature
	(properties
		noun 14
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(12 ; sword
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(16 ; dagger
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(81 ; flameDartSpell
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(20 ; rock
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 316 122 310 125 299 121 303 116 303 104 308 101 318 104 314 115
		)
		(super init:)
	)
)

(instance foreGround of Feature
	(properties
		noun 9
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 118 189 0 189 0 156 4 153 8 159 9 172 13 169 22 174 24 180 26 176 33 174 38 178 43 178 46 179 51 172 60 178 62 181 71 185 76 174 84 179 94 172 98 180 99 184 102 183 103 187 114 183
		)
		(super init:)
	)
)

(instance bookShelf of Feature
	(properties
		noun 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gMessager say: 2 1 0 0) ; "The books on the shelves of the bookcase appear to be very old, very rare, and very magical."
			)
			(4 ; Do
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(12 ; sword
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(16 ; dagger
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(81 ; flameDartSpell
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(20 ; rock
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 240 189 242 169 269 155 304 149 319 156 319 189
		)
		(super init:)
	)
)

(instance vase of Feature
	(properties
		noun 18
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(12 ; sword
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(16 ; dagger
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(81 ; flameDartSpell
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(20 ; rock
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 312 161 302 164 288 158 287 152 295 149 296 145 300 143 305 144 306 149 313 155
		)
		(super init:)
	)
)

(instance table of Feature
	(properties
		noun 15
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 218 165 212 167 206 163 206 149 196 144 197 152 192 152 187 149 188 132 186 131 186 127 248 114 279 126 279 131 273 132 273 151 267 153 262 151 262 140 218 150
		)
		(super init:)
	)
)

(instance theCasket of Feature
	(properties
		noun 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(12 ; sword
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(16 ; dagger
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(81 ; flameDartSpell
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(20 ; rock
				(if local1
					(= local2 1)
				else
					(dragon setScript: warning)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 24 140 17 159 9 164 9 159 5 153 0 155 0 125 5 122 15 124
		)
		(super init:)
	)
)

(instance westWall of Feature
	(properties
		noun 19
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 47 102 29 120 4 122 0 124 0 31 5 27 17 32 22 17 29 20 46 15 51 23
		)
		(super init:)
	)
)

(instance eastWall of Feature
	(properties
		noun 7
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 319 119 270 97 271 24 286 22 288 23 296 21 303 31 316 24 319 28
		)
		(super init:)
	)
)

(instance eastStair of Feature
	(properties)

	(method (doVerb theVerb invItem)
		(if (== theVerb 1) ; Look
			(foreGround doVerb: theVerb)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 144 141 136 147 125 143 127 140 122 135 123 131 114 116 115 114 119 112 126 111 128 116 135 119 134 123 140 125 143 132
		)
		(super init:)
	)
)

(instance westStair of Feature
	(properties)

	(method (doVerb theVerb invItem)
		(if (== theVerb 1) ; Look
			(foreGround doVerb: theVerb)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 84 156 72 155 43 131 35 130 29 121 48 101 60 103 62 107 86 140
		)
		(super init:)
	)
)

(instance swingBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cycleSpeed: (Random 10 15) loop: 4 setCycle: End self)
			)
			(1
				(bobSound play:)
				(= cycles (Random 10 25))
			)
			(2
				(client cel: 4 setCycle: Beg self)
			)
			(3
				(client cel: 0 loop: 5 setCycle: End self)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance showFeathers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(peacock stopUpd:)
			)
			(1
				(peacock setCycle: End self)
			)
			(2
				(peacock stopUpd:)
			)
			(3
				(peacock setCycle: Beg self)
			)
			(4
				(peacock stopUpd:)
			)
		)
	)
)

(instance intro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 160 187 setMotion: MoveTo 160 184 self)
			)
			(1
				(if (not (IsFlag 20))
					(gCurRoom doVerb: 1)
				)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance intoTheTower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 166 2 self)
			)
			(1
				(= ticks 120)
			)
			(2
				(wizSound init: play:)
				(theWiz cycleSpeed: 6 setCycle: End self)
			)
			(3
				(= ticks 90)
			)
			(4
				(theWiz hide: dispose:)
				(fenrus
					setLoop: 0
					setCel: 8
					cycleSpeed: 6
					setCycle: CT 5 -1 self
				)
			)
			(5
				(wizSound play:)
				(fenrus setCycle: Beg self)
			)
			(6
				(fenrus hide: dispose:)
				(= ticks 60)
			)
			(7
				(gCurRoom newRoom: 31)
			)
		)
	)
)

(instance warning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(dragon startUpd: setCycle: Fwd)
				(= ticks 20)
			)
			(1
				(= ticks 100)
			)
			(2
				(gMessager say: 12 0 4 1 self) ; "I wouldn't do that if I were you!"
			)
			(3
				(= local1 1)
				(HandsOn)
				(dragon setCycle: 0 setCel: 0 stopUpd: setScript: 0)
			)
		)
	)
)

(instance teleportOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(fenrus setLoop: 6 cycleSpeed: 4 setCycle: Fwd)
				(dragon setCycle: Fwd)
				(= ticks 60)
			)
			(1
				(cond
					(local4
						(gMessager say: 12 0 3 1 self) ; "Naughty, naughty. You were told to go straight up the stairs."
					)
					(local5
						(gMessager say: 12 0 3 2 self) ; "Since you're leaving anyway..."
					)
					(else
						(gMessager say: 12 0 3 3 self) ; "That'll learn ya!"
					)
				)
			)
			(2
				(Magic
					ignoreActors:
					cel: 0
					setPri: (gEgo priority:)
					posn: (gEgo x:) (gEgo y:)
					init:
					setCycle: CT 5 1 self
				)
			)
			(3
				(gEgo hide:)
				(Magic setCycle: CT 3 -1 self)
			)
			(4
				(Magic setCycle: End self)
			)
			(5
				(SetFlag 142)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 -32761)
				(= ticks 18)
			)
			(6
				(gCurRoom newRoom: 28)
			)
		)
	)
)

(instance bobSound of Sound
	(properties
		number 116
	)
)

(instance wizSound of Sound
	(properties
		number 28
	)
)

