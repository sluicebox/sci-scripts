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
		(super init:)
		(HandsOff)
		(= global103 1)
		(Load rsPIC 106)
		(self setScript: animScript)
	)
)

(instance animation of Prop
	(properties
		y 124
		x 161
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
				(gGlobalSound number: 500 loop: 1 playBed:)
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
					(if global159 7 else 15)
					dsFONT
					8
				)
				(= cycles 1)
			)
			(1
				(if
					(and
						(< (gGlobalSound prevSignal:) 5)
						(!= (gGlobalSound prevSignal:) -1)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(if global159
					(proc0_19 0 254 2)
				)
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
				(DrawPic 107 30)
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
							{   No   }
							0
							#button
							{   Yes   }
							1
						)
					)
					(animation dispose:)
				)
				(= cycles 1)
			)
			(13
				(HandsOn)
				(gCurRoom newRoom: (if local0 1 else 100))
			)
		)
	)
)

(instance glint of Prop
	(properties
		y 37
		x 146
		view 500
		cycleSpeed 2
	)
)

