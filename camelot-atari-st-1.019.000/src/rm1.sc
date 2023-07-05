;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm1 0
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
	local8 = 8
	[local9 18] = [4 0 6 0 0 0 0 0 0 0 5 2 8 7 0 0 0 0]
	[local27 18] = [155 165 182 211 198 183 173 157 145 182 226 238 146 128 0 0 0 0]
	[local45 18] = [73 63 57 77 97 108 119 102 85 44 78 64 113 88 0 0 0 0]
	[local63 18] = [1 2 9 2 3 4 7 8 0 11 11 10 8 0 0 0 0 0]
	[local81 18] = [8 0 3 4 5 6 12 12 7 2 4 10 6 12 0 0 0 0]
	[local99 18] = [1 2 3 10 3 4 5 6 0 10 11 10 6 0 0 0 0 0]
	[local117 18] = [8 0 1 2 6 7 12 12 13 2 3 10 13 12 0 0 0 0]
	[local135 18] = [1 2 9 2 0 0 7 13 0 1 2 10 8 0 0 0 0 0]
	[local153 18] = [1 2 9 10 3 4 5 2 0 12 11 12 7 0 0 0 0 0]
	[local171 18] = [8 0 1 4 5 6 12 12 13 0 4 10 12 13 0 0 0 0]
	[local189 58] = [5 4 3 10 5 6 5 6 7 10 10 3 6 12 0 0 0 0 155 73 165 63 182 55 211 77 198 97 184 108 173 124 157 102 145 85 -32768 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
)

(procedure (localproc_0)
	(Print &rest #width 120 #at 20 20 #font 4)
)

(procedure (localproc_1 param1 &tmp temp0)
	(return
		(switch param1
			(2 0)
			(4 1)
			(8 2)
			(16 3)
			(32 4)
			(64 5)
			(128 6)
			(256 7)
			(512 8)
			(1024 9)
			(2048 10)
			(4096 11)
			(8192 12)
			(16384 13)
			(-32768 14)
		)
	)
)

(procedure (localproc_2 param1)
	(return
		(switch param1
			(0 2)
			(1 4)
			(2 8)
			(3 16)
			(4 32)
			(5 64)
			(6 128)
			(7 256)
			(8 512)
			(9 1024)
			(10 2048)
			(11 4096)
			(12 8192)
			(13 16384)
			(14 -32768)
		)
	)
)

(procedure (localproc_3 param1 param2 param3)
	(switch param1
		(16
			(return (> param2 127))
		)
		(1024
			(return (< param3 110))
		)
		(4096
			(return (and (< 234 param2 245) (< 58 param3 67)))
		)
		(2048
			(return (< param3 95))
		)
		(16384
			(return (and (< 114 param2 142) (< 77 param3 100)))
		)
		(8
			(return 1)
		)
		(4
			(return 1)
		)
		(32
			(return 1)
		)
		(2
			(return 1)
		)
		(512
			(return 1)
		)
		(8192
			(return 1)
		)
		(128
			(return 1)
		)
		(256
			(return 1)
		)
		(64
			(return 1)
		)
		(-32768
			(return 0)
		)
		(else
			(return 0)
		)
	)
)

(procedure (localproc_4 param1 param2 param3 &tmp temp0)
	(= temp0 (< param2 0))
	(switch param1
		(16
			(if (or (> param2 127) temp0)
				((localproc_0 1 0 88)) ; "There is nothing of import to you here and urgent matters await you elsewhere."
			else
				(localproc_0 1 1 88) ; "You have further fortifications and docks along the edge of the lake. You may come here again someday, if happier times return."
			)
		)
		(1024
			(if (or (< param3 110) temp0)
				(localproc_0 1 2 88) ; "This is the ladies' tower and you have no business there at the moment whatsoever."
			else
				(localproc_0 1 3 88) ; "This is the front gate and tunnel, heavily guarded and sealed with gates and a portcullis. You reach it through the outer courtyard."
			)
			(return 0)
		)
		(4096
			(if (or temp0 (and (< 234 param2 245) (< 58 param3 67)))
				(localproc_0 1 4 88) ; "You have granted possession of this small tower room to me where only the brave dare to tread. And even then, with caution."
			else
				(localproc_0 1 5 88) ; "This is the hilltop on which Camelot rests."
				(return 0)
			)
		)
		(2
			(localproc_0 1 6 88) ; "It is your own room, King Arthur."
		)
		(2048
			(if (or (< param3 95) temp0)
				(localproc_0 1 7 88) ; "Here is your Treasury."
			else
				(localproc_0 1 8 88) ; "It is part of the road leading down the hill. You will find yourself here soon enough, when your preparations are complete."
				(return 0)
			)
		)
		(8
			(localproc_0 1 9 88) ; "Often Gwenhyver may be found here, in the Queen's Bower."
		)
		(16384
			(if (or temp0 (and (< 114 param2 142) (< 77 param3 100)))
				(localproc_0 1 10 88) ; "This is the Chapel of the Two Gods."
			else
				(localproc_0 1 11 88) ; "This is the lake that surrounds the peninsula on which Camelot sits. Now it is nearly gone, dried to a few stagnant pools."
				(return 0)
			)
		)
		(-32768
			(if (and (< 156 param2 198) (< 63 param3 104))
				(localproc_0 1 12 88) ; "This is the inner courtyard. You have no business there at present."
			else
				(localproc_0 1 13 88) ; "These protected grounds serve many purposes. There are practice grounds for fighting and jousting, areas of garden, areas for animals in case of seige. None of this is of import to your mission."
			)
			(return 0)
		)
		(8192
			(localproc_0 1 14 88) ; "This is the outer courtyard, adjacent to the stables."
		)
		(128
			(localproc_0 1 15 88) ; "Many of your soldiers barrack here. Also, there are storage rooms. But there is nothing you need here for this mission."
			(return 0)
		)
		(else
			((localproc_0 1 0 88)) ; "There is nothing of import to you here and urgent matters await you elsewhere."
			(return 0)
		)
	)
)

(instance rm1 of Rm
	(properties
		picture 1
		style 6
	)

	(method (init)
		(super init:)
		(= local3
			(switch gPrevRoomNum
				(4 0)
				(6 2)
				(7 13)
				(5 10)
				(2 11)
				(8 12)
			)
		)
		(gEgo
			view: (if (IsFlag 3) 28 else 29)
			posn: [local27 local3] [local45 local3]
			init:
			setStep: 1 1
		)
		(if (or (== gPrevRoomNum 101) (== gPrevRoomNum 112) (== gPrevRoomNum 100)) ; Intro, SpeedTst, Title
			(gGame setSpeed: 4)
		)
		(proc0_13 258)
		(gAddToPics doit:)
		(= local7 (localproc_1 (gEgo onControl: 1)))
		(User canInput: 0)
		(gRmMusic number: 16 loop: -1 play:)
		(if (not (IsFlag 13))
			(Print 1 16 #width 100 #font 4 #at 20 20 #dispose) ; "'Tis the floor plan of your stronghold, Camelot. Waste no time in preparing for your vital mission, m'lord."
			(SetFlag 13)
		)
	)

	(method (newRoom newRoomNumber)
		(if (IsFlag 3)
			(SetMenu 1283 112 1)
		)
		(HandsOn)
		(super newRoom: newRoomNumber)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if local0
			(++ local1)
		)
		(= temp0 (localproc_1 (gEgo onControl: 1)))
		(if (and (!= local7 temp0) (not global80))
			(= local7 temp0)
		)
	)

	(method (handleEvent event &tmp [temp0 3])
		(if (or (not (User canControl:)) (event claimed:))
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(event claimed: 1)
				(if (& (event modifiers:) emSHIFT)
					(clr)
					(localproc_4
						(OnControl CONTROL (event x:) (event y:))
						(event x:)
						(event y:)
					)
				else
					(clr)
					(switch
						(= local5
							(localproc_1 (OnControl CONTROL (event x:) (event y:)))
						)
						(local7
							(cond
								(
									(and
										[local9 local7]
										(localproc_3
											(localproc_2 local5)
											(event x:)
											(event y:)
										)
									)
									(gCurRoom newRoom: [local9 local7])
								)
								(
									(localproc_3
										(localproc_2 local5)
										(event x:)
										(event y:)
									)
									(localproc_4
										(localproc_2 local5)
										(event x:)
										(event y:)
									)
								)
							)
						)
						(else
							(if
								(localproc_3
									(OnControl CONTROL (event x:) (event y:))
									(event x:)
									(event y:)
								)
								(gEgo setScript: moveHim 0)
							)
						)
					)
				)
			)
			($0040 ; direction
				(event claimed: 1)
				(= local5
					(switch (event message:)
						(JOY_UP [local63 local7])
						(JOY_DOWN [local81 local7])
						(JOY_RIGHT [local99 local7])
						(JOY_LEFT [local117 local7])
						(JOY_UPRIGHT [local153 local7])
						(JOY_UPLEFT [local135 local7])
						(JOY_DOWNRIGHT [local189 local7])
						(JOY_DOWNLEFT [local171 local7])
					)
				)
				(clr)
				(gEgo setMotion: 0)
				(gEgo setScript: moveHim 1)
			)
			(evKEYBOARD
				(if (== (event message:) KEY_RETURN)
					(event claimed: 1)
					(clr)
					(if [local9 local7]
						(gCurRoom newRoom: [local9 local7])
					else
						((localproc_0 1 0 88)) ; "There is nothing of import to you here and urgent matters await you elsewhere."
					)
				)
			)
		)
	)
)

(instance moveHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(gEgo illegalBits: 0)
				(= local3
					(switch local7
						(9 2)
						(10
							(if (== local5 11) 10 else 3)
						)
						(11
							(if (== local5 10) 11 else 3)
						)
						(12 7)
						(13 8)
						(else local7)
					)
				)
				(= local4
					(switch local5
						(9 2)
						(10
							(if (== local3 11) 11 else 3)
						)
						(11
							(if (== local3 10) 10 else 3)
						)
						(12 7)
						(13 8)
						(else local5)
					)
				)
				(= local2
					(or (< 0 (- local4 local3) 4) (> (- local3 local4) 4))
				)
				(= local6 local3)
				(= cycles 4)
			)
			(1
				(if (!= local6 local4)
					(gEgo
						setMotion: MoveTo [local27 local6] [local45 local6] self
					)
				else
					(self changeState: 3)
				)
			)
			(2
				(cond
					(local2
						(if (> (++ local6) local8)
							(= local6 0)
						)
					)
					((< (-- local6) 0)
						(= local6 local8)
					)
				)
				(self changeState: 1)
			)
			(3
				(gEgo
					setMotion: MoveTo [local27 local4] [local45 local4] self
				)
			)
			(4
				(gEgo
					setMotion: MoveTo [local27 local5] [local45 local5] self
				)
			)
			(5
				(= local7 local5)
				(localproc_4 (localproc_2 local5) -1 -1)
				(User canControl: 1)
			)
		)
	)
)

