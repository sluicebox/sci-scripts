;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52)
(include sci.sh)
(use Main)
(use Timer)
(use System)

(public
	sCredits 0
)

(local
	local0 = 1
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance sCredits of Script
	(properties)

	(method (init)
		(if (not register)
			(gCast eachElementDo: #addToPic)
			(gTheIconBar disable:)
			(Cursor showCursor: 0)
			(Load rsFONT 2207 3110)
			(Load rsMESSAGE 194)
			(Load rsPIC 98 99)
			(songTimer setReal: self 240)
			(if (and (== gMsgType 2) (DoAudio audCD 10))
				(DoAudio audCD 2 2 0 236)
			else
				(gGlobalSound number: 24 loop: 1 play: self)
			)
			(++ register)
		)
		(super init: &rest)
	)

	(method (changeState newState &tmp [temp0 50] [temp50 500] temp550 temp551)
		(switch (= state newState)
			(0
				(if local1
					(Message msgGET 194 3 0 0 local0 @temp0)
					(Message msgGET 194 3 0 0 (++ local0) @temp50)
				else
					(Message msgGET 194 0 0 0 local0 @temp0)
					(Message msgGET 194 0 0 0 (++ local0) @temp50)
				)
				(if (>= (++ local0) 32)
					(= local1 1)
					(= local0 1)
				)
				(= local2
					(Display @temp0 dsCOLOR 0 dsCOORD 64 61 dsWIDTH 200 dsFONT 3110 dsALIGN alCENTER dsSAVEPIXELS)
				)
				(= local3
					(Display @temp50 dsCOLOR 0 dsCOORD 64 81 dsWIDTH 200 dsFONT 2207 dsALIGN alCENTER dsSAVEPIXELS)
				)
				(= local4
					(Display @temp0 dsCOLOR 7 dsCOORD 63 60 dsWIDTH 200 dsFONT 3110 dsALIGN alCENTER dsSAVEPIXELS)
				)
				(= local5
					(Display @temp50 dsCOLOR 7 dsCOORD 63 80 dsWIDTH 200 dsFONT 2207 dsALIGN alCENTER dsSAVEPIXELS)
				)
				(= seconds 6)
			)
			(1
				(Display 52 0 dsRESTOREPIXELS local5)
				(Display 52 0 dsRESTOREPIXELS local4)
				(Display 52 0 dsRESTOREPIXELS local3)
				(Display 52 0 dsRESTOREPIXELS local2)
				(if (and (not local1) (== local0 15))
					(for ((= temp550 100)) (> temp550 0) ((-- temp550))
						(Palette palSET_INTENSITY 0 255 temp550)
						(for ((= temp551 0)) (< temp551 10) ((++ temp551))
						)
					)
					(if global169
						(DrawPic 98 15)
					else
						(DrawPic 98)
					)
				)
				(= cycles 2)
			)
			(2
				(if (and (not local1) (== local0 15))
					(Palette palSET_INTENSITY 0 231 100)
				)
				(if (and local1 (== local0 1) local6)
					(= cycles 2)
				else
					(if local1
						(= local6 1)
					)
					(self init:)
				)
			)
			(3
				(if (== gScore gPossibleScore)
					(Format
						@temp50
						{You received %d out of %d points. You've completed %d percent of the main-path puzzles in King's Quest VI.}
						gScore
						gPossibleScore
						(/ (* gScore 100) gPossibleScore)
					)
				else
					(Format
						@temp50
						{You received %d out of %d points. You've completed approximately %d percent of the main-path puzzles in King's Quest VI.}
						gScore
						gPossibleScore
						(/ (* gScore 100) gPossibleScore)
					)
				)
				(= local2
					(Display @temp50 dsCOLOR 7 dsCOORD 64 60 dsWIDTH 200 dsFONT 3110 dsALIGN alCENTER dsSAVEPIXELS)
				)
				(= seconds 9)
			)
			(4
				(Display 52 0 dsRESTOREPIXELS local2)
				(= cycles 2)
			)
			(5
				(if (<= gScore 230)
					(Message msgGET 194 0 0 1 2 @temp50) ; "We hope you'll play again!"
				else
					(Message msgGET 194 0 0 1 3 @temp50) ; "Congratulations on your excellent performance! If you want to go "beyond" the ultimate score, we recommend that you try the other, "easier" entrance to the castle. You can do so easily by restoring back to a point just before the Druid's rain storm. DON'T GO BACK TO SEE THE DRUIDS--instead, head for the castle. New puzzle challenges await you!"
				)
				(Display @temp50 dsCOLOR 7 dsCOORD 64 60 dsWIDTH 200 dsFONT gSmallFont dsALIGN alCENTER)
				(= seconds 20)
			)
			(6
				(if global169
					(DrawPic 99 15)
				else
					(DrawPic 99)
				)
				(Cursor showCursor: 1)
			)
			(7
				(for ((= temp550 100)) (> temp550 0) ((-- temp550))
					(Palette palSET_INTENSITY 0 255 temp550)
					(for ((= temp551 0)) (< temp551 10) ((++ temp551))
					)
				)
				(= cycles 5)
			)
			(8
				(= gQuit 1)
			)
		)
	)
)

(instance songTimer of Timer
	(properties)
)

