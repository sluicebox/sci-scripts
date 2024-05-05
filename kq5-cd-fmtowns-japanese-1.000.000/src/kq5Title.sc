;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 119)
(include sci.sh)
(use Main)
(use Interface)
(use Sync)
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
		(super init: &rest)
		(HandsOff)
		(gGame setCursor: 5 1)
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

(instance theScriptSync of ScriptSync
	(properties)
)

(instance animScript of Script
	(properties)

	(method (doit)
		(if
			(and
				(<= state 8)
				(or
					(and
						(== state 2)
						(or
							(>= (theScriptSync prevSignal:) 5)
							(>= (gGlobalSound prevSignal:) 10)
						)
					)
					(and
						(== state 4)
						(or
							(>= (theScriptSync prevSignal:) 20)
							(>= (gGlobalSound prevSignal:) 20)
						)
					)
					(and
						(== state 6)
						(or
							(>= (theScriptSync prevSignal:) 30)
							(>= (gGlobalSound prevSignal:) 30)
						)
					)
					(and
						(== state 8)
						(or
							(>= (gGlobalSound prevSignal:) -1)
							(>= (theScriptSync prevSignal:) 40)
						)
					)
				)
			)
			(= cycles 1)
		)
		(super doit: &rest)
	)

	(method (changeState newState &tmp [temp0 251])
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (== (DoSound sndGET_POLYPHONY) 32)
					(gGlobalSound number: 500 loop: 1 playBed:)
				else
					(theScriptSync init: 9996)
					(DoAudio audPLAY 9996)
				)
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
			(2)
			(3
				(if global159
					(proc0_18 0 254 2)
				)
				(= cycles 1)
			)
			(4)
			(5
				(glint setCycle: End self init:)
			)
			(6)
			(7
				(glint posn: 148 143 setCycle: End self)
			)
			(8)
			(9
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
				(if (== (DoSound sndGET_POLYPHONY) 32)
					(gGlobalSound number: 72 loop: 1 playBed:)
				else
					(Say 9997 self)
				)
				(= cycles 30)
			)
			(10
				(animation cycleSpeed: 1 setCycle: End self init:)
			)
			(11
				(if (== (DoSound sndGET_POLYPHONY) 32)
					(if (== (gGlobalSound prevSignal:) -1)
						(= cycles 1)
					else
						(-- state)
						(= cycles 1)
					)
				)
			)
			(12
				(= seconds 2)
			)
			(13
				(Say 9247 self)
			)
			(14
				(HandsOn)
				(gGame setCursor: 999 1)
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
			(15
				(gGame setCursor: 5 1)
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

