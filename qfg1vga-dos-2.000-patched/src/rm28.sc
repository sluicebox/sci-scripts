;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use n814)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm28 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm28 of Rm
	(properties
		noun 8
		picture 27
	)

	(method (cue)
		(switch local5
			(5
				(gMessager say: 3 0 0 global288)
			)
			(6
				(gMessager say: 7 0 0 global288)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 1) ; Look
			(if local3
				(gMessager say: 8 1 8) ; "What a great big, beautiful sky."
			else
				(gMessager say: 8 1 7) ; "This must be the place."
			)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)

	(method (dispose)
		(= gUseSortedFeatures local2)
		(SetFlag 18)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 28 530)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 137 159 0 154 0 72 136 136
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 210 176 159 176 140 170 150 158 209 137 319 90 319 189 0 189 0 186 223 186
					yourself:
				)
		)
		(self style: -32761)
		(super init:)
		(= local2 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(gFeatures add: rocks postPile road longShot eachElementDo: #init)
		(gLongSong fade:)
		(SL enable:)
		(= local4 (gTheIconBar at: 1))
		(gTheIconBar curIcon: local4)
		(gGame setCursor: (local4 cursor:) 1)
		(if (== global288 3)
			(= global288 1)
		else
			(++ global288)
		)
		(NormalEgo)
		(gEgo init:)
		(cond
			((IsFlag 142)
				(Magic
					posn: 17 180
					setPri: (+ (gEgo priority:) 1)
					ignoreActors:
					init:
				)
				(gEgo setScript: teleport)
			)
			((== gPrevRoomNum 29)
				(gEgo setScript: downTheMount)
			)
			(else
				(gEgo setScript: egoEnters)
			)
		)
		(greenSign setPri: 13 posn: 69 172 init:)
		(redSign setPri: 13 posn: 147 173 init:)
	)

	(method (doit)
		(cond
			((gEgo script:))
			((< (gEgo x:) 10)
				(gEgo setScript: egoExits)
			)
			((and (> (gEgo x:) 120) (< (gEgo y:) 170))
				(gEgo setScript: lookinUp)
			)
			(
				(and
					(== (gEgo loop:) 0)
					(== (gEgo onControl: 1) 2)
					(not local0)
				)
				(= local0 1)
				(greenSign setScript: showGreenSign)
			)
			(
				(and
					(== (gEgo loop:) 0)
					(== (gEgo onControl: 1) 8)
					(not local1)
				)
				(= local1 1)
				(redSign setScript: showRedSign)
			)
			((and (== (gEgo loop:) 0) (== (gEgo onControl: 1) 16) local1)
				(= local1 0)
			)
			((and (== (gEgo loop:) 0) (== (gEgo onControl: 1) 4) local0)
				(showGreenSign cue:)
			)
			((and (== (gEgo onControl: 1) 1) local0)
				(= local0 0)
			)
		)
		(super doit:)
	)
)

(instance rocks of Feature
	(properties
		noun 10
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 147 159 0 152 0 64 19 78 18 91 26 99 33 100 38 105 45 105 53 111 61 116 78 117 90 127 97 131 103 130 112 134 129 132 135 133 143 131 159 135 162 123 169 117 185 115 207 111 220 96 229 89 237 84 241 80 258 69 271 65 284 67 301 79 319 84 319 189 0 189 0 176 13 175 29 186 45 187 50 181 88 187 91 183 109 182 129 187 133 183 144 184 148 186 166 186 177 188 181 185 201 185 218 180 235 186 223 170 162 173 148 166
		)
		(super init:)
	)
)

(instance postPile of Feature
	(properties
		noun 6
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 82 120 79 117 61 115 46 105 38 105 34 100 26 98 19 91 20 78 0 63 0 30 11 30 33 41 46 51 54 40 61 37 80 37 125 55 151 51 168 55 183 31 216 29 204 48 213 58
		)
		(super init:)
	)
)

(instance road of Feature
	(properties
		noun 9
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 159 135 142 131 133 133 125 131 112 134 104 130 96 130 82 121 213 58 205 48 217 29 184 19 203 0 247 0 222 17 284 30 267 41 281 48 267 65 258 69 240 80 234 85 222 94 207 111 169 116 161 124
		)
		(super init:)
	)
)

(instance longShot of Feature
	(properties
		noun 4
		nsBottom 140
		nsRight 319
	)
)

(instance magicMount of Feature
	(properties
		noun 5
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 66 189 116 180 157 157 185 135 191 117 203 103 211 89 251 89 258 96 260 100 274 119 283 119 302 136 319 142 319 189
		)
		(super init:)
	)
)

(instance farPavilions of Feature
	(properties
		noun 2
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 127 173 114 180 63 189 0 189 0 177 3 175 9 179 21 174 34 179 40 175 45 177 50 177 54 180 64 175 67 177 72 173 78 175 94 165 98 166 103 164 111 170 118 169
		)
		(super init:)
	)
)

(instance castle of Feature
	(properties
		noun 1
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 1) ; Look
			(switch (Random 0 3)
				(0
					(gMessager say: 1 1 2) ; "Perhaps it's a tower of power."
				)
				(1
					(gMessager say: 1 1 4) ; "It looks a bit like a purple mannequin."
				)
				(2
					(gMessager say: 1 1 3) ; "Could it be a bottle of purple salad dressing?"
				)
				(3
					(gMessager say: 1 1 1) ; "It looks like a cross between a castle and an angry purple rhinoceros."
				)
			)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 249 88 210 88 207 94 209 74 212 69 213 57 216 57 219 76 224 70 220 59 224 49 229 46 229 39 227 39 227 36 231 34 229 30 232 25 236 30 236 34 239 36 237 39 238 44 243 49 243 55 240 60 241 67 249 83
		)
		(super init:)
	)
)

(instance redSign of Prop
	(properties
		view 28
		loop 1
	)
)

(instance greenSign of Prop
	(properties
		view 28
	)
)

(instance Magic of Prop
	(properties
		view 530
		cycleSpeed 2
	)
)

(instance downTheMount of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setPri: 12
					posn: 178 169
					init:
					setMotion: MoveTo 107 163 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 24 170 self)
			)
			(2
				(gEgo setMotion: PolyPath 24 174 self)
			)
			(3
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookinUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: 12 setMotion: PolyPath 178 169 self)
			)
			(1
				(gEgo hide:)
				(= ticks 240)
			)
			(2
				(gCurRoom drawPic: 28 14)
				(gFeatures eachElementDo: #dispose release:)
				(= ticks 6)
			)
			(3
				(HandsOn)
				(gTheIconBar disable: 1 3 4 6 5 7 8)
				(gFeatures
					add: magicMount farPavilions castle
					eachElementDo: #init
				)
				(= local3 1)
				(= ticks 260)
			)
			(4
				(= ticks 260)
			)
			(5
				(gEgo setPri: -1)
				(gCurRoom newRoom: 29)
			)
		)
	)
)

(instance egoExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo -20 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 27)
			)
		)
	)
)

(instance showGreenSign of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(signSound play:)
				(greenSign ignoreActors: 0 setCycle: End self)
			)
			(1
				(signSound stop:)
				(= local5 5)
				(if (not (IsFlag 156))
					(gMessager say: 8 0 5 1 gCurRoom) ; "A sign appears. It reads:"
				else
					(rm28 cue:)
				)
				(SetFlag 156)
				(greenSign ignoreActors: setCycle: Beg self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance showRedSign of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(signSound play:)
				(redSign ignoreActors: 0 setCycle: End self)
			)
			(1
				(signSound stop:)
				(gEgo setMotion: 0)
				(= local5 6)
				(if (not (IsFlag 155))
					(gMessager say: 8 0 6 1 gCurRoom) ; "Another sign appears. It reads:"
				else
					(rm28 cue:)
				)
				(SetFlag 155)
				(redSign ignoreActors: setCycle: Beg self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance teleport of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 17 180 loop: 2 cel: 1 hide:)
				(Magic cycleSpeed: 4 setCycle: CT 5 1 self)
			)
			(1
				(signSound play:)
				(gEgo show:)
				(Magic setCycle: CT 3 -1 self)
			)
			(2
				(Magic setCycle: End self)
			)
			(3
				(signSound stop:)
				(ClearFlag 142)
				(gEgo setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(HandsOff)
				(gEgo posn: 1 180 setMotion: MoveTo 20 180 self)
			)
			(1
				1
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance signSound of Sound
	(properties
		number 28
	)
)

