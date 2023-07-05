;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Polygon)
(use Motion)
(use System)

(public
	rm005 0
)

(local
	[local0 32] = [0 0 319 0 319 175 256 175 225 141 268 141 251 126 209 126 209 114 185 114 185 126 76 126 53 149 121 149 109 176 0 176]
	[local32 18] = [0 0 319 0 319 180 275 180 231 135 102 133 104 135 72 179 0 179]
	[local50 8] = [113 145 183 145 183 161 108 161]
	[local58 24] = [0 0 319 0 319 173 274 173 246 142 234 142 214 131 87 131 76 141 130 143 100 173 0 173]
	[local82 36] = [0 0 319 0 319 173 274 173 246 142 234 142 220 130 157 130 157 135 106 135 106 130 77 130 73 137 115 137 114 142 130 143 100 173 0 173]
	local118
)

(instance rm005 of KQ5Room
	(properties)

	(method (init)
		(super init:)
		(gEgo normal: 1 view: 0 setStep: 3 2 init:)
		(switch global313
			(1
				(self drawPic: 961 setRegions: 203 addObstacle: poly1) ; tailorShop
				(gEgo posn: 152 200)
			)
			(2
				(self drawPic: 928 setRegions: 204 addObstacle: poly2 poly3) ; toyShop
				(gEgo posn: 215 200)
			)
			(3
				(self drawPic: 996)
				(if (!= ((gInventory at: 8) owner:) 205) ; Shoe
					(self setRegions: 205) ; shoeShop
					(self addObstacle: poly5)
				else
					(self addObstacle: poly4)
				)
				(gEgo posn: 152 200)
			)
		)
		(poly1 points: @local0 size: 16)
		(poly2 points: @local32 size: 9)
		(poly3 points: @local50 size: 4)
		(poly4 points: @local58 size: 12)
		(poly5 points: @local82 size: 18)
		(polyList15 add: poly4)
		(= local118 obstacles)
		(= global322 polyList15)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 0) $4000)
				(HandsOff)
				(self setScript: leaveRoom)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(= obstacles local118)
		(polyList15 dispose:)
		(super dispose:)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 30) self
				)
			)
			(1
				(HandsOn)
				(gCurRoom newRoom: 4)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly5 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance polyList15 of List
	(properties)
)

