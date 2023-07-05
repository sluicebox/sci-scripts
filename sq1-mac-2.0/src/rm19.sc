;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use eRS)
(use Polygon)
(use Motion)
(use User)

(public
	rm19 0
)

(local
	local0
)

(instance rm19 of SQRoom
	(properties
		lookStr {You are at the northwest boundary of a massive skeletal structure. Sand stretches out in all other directions.}
		picture 19
		horizon 20
		north 38
		east 20
		south 22
		west 37
		walkOffTop 1
	)

	(method (init)
		(if (== global166 2)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 65 189 65 164 102 115 213 65 319 57 319 163 298 173 258 178 257 189
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 189 0 0 319 0 319 57 301 57 275 52 257 62 235 63 227 57 216 57 216 66 188 78 179 74 148 91 123 115 136 151 121 151 120 166 137 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 177 189 166 178 152 151 139 127 170 93 236 71 291 66 319 66 319 189
						yourself:
					)
			)
		)
		(switch gPrevRoomNum
			(east
				(= style 11)
				(HandsOn)
			)
			(south
				(= style 14)
				(gEgo heading: 0 loop: 3)
				(HandsOn)
			)
			(else
				(= style 10)
			)
		)
		(gEgo init:)
		(self setRegions: 704) ; keronaRegion
		(super init:)
		(if (and (== global166 1) (== gPrevRoomNum south))
			(gEgo x: 156)
			(gEgo y: 186)
		)
	)

	(method (doit)
		(cond
			(local0 0)
			((& (gEgo onControl: 1) $4000)
				(User canControl: 0 canInput: 0)
				(gEgo setMotion: MoveTo (gEgo x:) 200)
				(= local0 1)
			)
		)
		(super doit: &rest)
	)
)

