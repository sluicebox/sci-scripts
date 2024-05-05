;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 119)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	kq5Title 0
)

(local
	local0
	local1
)

(instance kq5Title of Rm
	(properties
		picture 55
	)

	(method (init)
		(Load rsPIC 106)
		(Load rsVIEW 500)
		(super init: &rest)
		(HandsOff)
		(self setScript: animScript)
	)
)

(instance animation of Prop
	(properties
		x 161
		y 124
		view 126
		priority 8
		cycleSpeed 1
	)
)

(instance animScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 251])
		(switch (= state newState)
			(0
				(gGlobalSound number: 500 loop: 1 playBed: self)
				(Palette palSET_INTENSITY 0 254 0)
				(DrawPic 106 5)
				(Display ; "Presents"
					119
					0
					dsCOORD
					88
					177
					dsWIDTH
					140
					dsALIGN
					alCENTER
					dsCOLOR
					(cond
						((== global105 256) 7)
						((== global105 32) 31)
						(else 15)
					)
					dsFONT
					8
				)
			)
			(1
				(if global159
					(proc0_18 0 254 2)
				)
				(= cycles 1)
			)
			(2
				(= cycles 1)
			)
			(3
				(if
					(and
						(< (gGlobalSound prevSignal:) 20)
						(!= (gGlobalSound prevSignal:) -1)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(glint setCycle: End self init:)
			)
			(5
				(if
					(and
						(< (gGlobalSound prevSignal:) 30)
						(!= (gGlobalSound prevSignal:) -1)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(6
				(glint posn: 148 143 setCycle: End self)
			)
			(7
				(if (!= (gGlobalSound prevSignal:) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(8
				(DrawPic 107 10)
				(= global318 (- (= global313 (GetTime)) global287))
				(= global287 0)
				(= global313 0)
				(cond
					((< global318 400)
						(= global318 2)
					)
					((and (> global318 401) (< global318 999))
						(= global318 1)
					)
					(else
						(= global318 0)
					)
				)
				(gGlobalSound number: 72 loop: 1 playBed:)
				(= cycles 30)
			)
			(9
				(animation cycleSpeed: 1 setCycle: End self init:)
			)
			(10
				(if (== (gGlobalSound prevSignal:) -1)
					(= cycles 1)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(11
				(= seconds 2)
			)
			(12
				(gGame setCursor: gNormalCursor 1)
				(= global103 1)
				(if global327
					(= local0 0)
				else
					(= local0
						(Print ; "Have you previously played King's Quest V?"
							119
							1
							#width
							120
							#at
							94
							10
							#time
							15
							#button
							{___No___}
							0
							#button
							{___Yes___}
							1
						)
					)
					(animation dispose:)
				)
				(= cycles 1)
			)
			(13
				(gCurRoom newRoom: (if local0 1 else 100))
			)
		)
	)
)

(instance glint of Prop
	(properties
		x 146
		y 37
		view 500
		cycleSpeed 2
	)
)

