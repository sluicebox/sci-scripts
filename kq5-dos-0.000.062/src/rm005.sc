;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Sort)
(use Motion)
(use Game)
(use System)

(public
	rm005 0
)

(local
	[local0 32] = [0 176 109 176 121 149 53 149 76 126 185 126 185 114 209 114 209 126 251 126 268 141 225 141 256 175 319 175 319 0 0 0]
	[local32 18] = [0 179 72 179 104 135 102 133 231 135 275 180 319 180 319 0 0 0]
	[local50 8] = [108 161 183 161 183 145 113 145]
	[local58 24] = [0 173 100 173 130 143 76 141 87 131 214 131 234 142 246 142 274 173 319 173 319 0 0 0]
	[local82 36] = [0 173 100 173 130 143 114 142 115 137 73 137 77 130 106 130 106 135 157 135 157 130 220 130 234 142 246 142 274 173 319 173 319 0 0 0]
)

(instance rm005 of Rm
	(properties)

	(method (init)
		(super init:)
		(gEgo normal: 1 view: 0 setStep: 3 2 init:)
		(switch global313
			(1
				(self drawPic: 961 setRegions: 203 addObstacle: poly1) ; tailorShop
				(gEgo offset: 3 posn: 152 200)
			)
			(2
				(self drawPic: 928 setRegions: 204 addObstacle: poly2 poly3) ; toyShop
				(gEgo offset: 3 posn: 215 200)
			)
			(3
				(self drawPic: 996)
				(if (!= ((gInventory at: 8) owner:) 205) ; Shoe
					(self setRegions: 205) ; shoeShop
					(self addObstacle: poly5)
				else
					(self addObstacle: poly4)
				)
				(gEgo offset: 3 posn: 152 200)
			)
		)
		(poly1 points: @local0 size: 16)
		(poly2 points: @local32 size: 9)
		(poly3 points: @local50 size: 4)
		(poly4 points: @local58 size: 12)
		(poly5 points: @local82 size: 18)
		(polyList15 add: poly4)
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

