;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 706)
(include sci.sh)
(use Main)
(use DScript)
(use PolyPath)
(use Motion)
(use Actor)

(public
	viewCartridge 0
)

(local
	[local0 251]
)

(instance screen of Prop
	(properties
		x 152
		y 135
		view 161
		loop 1
		cycleSpeed 6
	)
)

(instance viewCartridge of DScript
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(UnLoad 129 99)
		(DisposeScript 706)
	)

	(method (handleEvent event)
		(if clrByKey
			(if (<= counter 0)
				(event claimed: 1)
				(= seconds 0)
				(= cycles 1)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (doit)
		(super doit:)
		(-- counter)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong fade:)
				(= ticks 18)
			)
			(1
				(gEgo ignoreActors: 1 setMotion: PolyPath 139 178 self)
			)
			(2
				(gEgo setHeading: 45 self)
			)
			(3
				(screen init: setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #stopUpd)
				((ScriptID 703 14) dispose:) ; sarienOfficer1
				((ScriptID 703 15) dispose:) ; sarienOfficer2
				(gCurRoom drawPic: 99 10)
				(Display 706 0 dsALIGN alCENTER dsWIDTH 165 dsCOORD 78 40 dsCOLOR global136) ; "LOADING"
				(= seconds 3)
			)
			(5
				(gCurRoom drawPic: 99 13)
				(gLongSong2 number: 413 loop: -1 play:)
				(Display 706 1 dsALIGN alCENTER dsWIDTH 165 dsCOORD 78 40 dsCOLOR global136) ; "Whoever shall read this: My name is Dr. Slash Vohaul, I am a scientist with The Star Generator Project aboard the Starlab Arcada."
				(= seconds 10)
			)
			(6
				(gCurRoom drawPic: 99 13)
				(Display 706 2 dsALIGN alCENTER dsWIDTH 165 dsCOORD 78 40 dsCOLOR global136) ; "We have just successfully completed development and testing of The Star Generator. During this time I have come to believe that our progress has been monitored by others. I fear that the Sariens may have learned of our mission."
				(= seconds 16)
			)
			(7
				(gCurRoom drawPic: 99 13)
				(Display 706 3 dsALIGN alCENTER dsWIDTH 165 dsCOORD 78 40 dsCOLOR global136) ; "If my fears prove true, The Star Generator and the people of our universe are in serious jeopardy."
				(= seconds 10)
			)
			(8
				(gCurRoom drawPic: 99 13)
				(Display 706 4 dsALIGN alCENTER dsWIDTH 165 dsCOORD 78 40 dsCOLOR global136) ; "The Star Generator is a miraculous device. Used as intended, it will help preserve life for eons to come."
				(= seconds 12)
			)
			(9
				(gCurRoom drawPic: 99 13)
				(Display 706 5 dsALIGN alCENTER dsWIDTH 165 dsCOORD 78 40 dsCOLOR global136) ; "Used as a device for evil, it would cause the destruction of millions of lives and enslave all who oppose the Sariens."
				(= seconds 12)
			)
			(10
				(gCurRoom drawPic: 99 13)
				(Display 706 6 dsALIGN alCENTER dsWIDTH 165 dsCOORD 78 40 dsCOLOR global136) ; "Encoded within this cartridge are all the plans and specifications for the construction of the Star Generator."
				(= seconds 12)
			)
			(11
				(gCurRoom drawPic: 99 13)
				(Display 706 7 dsALIGN alCENTER dsWIDTH 165 dsCOORD 78 40 dsCOLOR global136) ; "Should any disaster befall the Star Generator project, scientists would be able to create a duplicate of the Star Generator with this information."
				(= seconds 12)
			)
			(12
				(gCurRoom drawPic: 99 13)
				(Display 706 8 dsALIGN alCENTER dsWIDTH 165 dsCOORD 78 40 dsCOLOR global136) ; "Please guard it with your life and return it to the Xenon ruling body as quickly as possible."
				(= seconds 10)
			)
			(13
				(gCurRoom drawPic: 99 13)
				(SetScore 5 152)
				(Format @local0 706 9 global184) ; "Important note: The Star Generator is capable of self-destruction. This was introduced to the system as a precaution. To activate it one must enter the code: %4d"
				(Display @local0 dsALIGN alCENTER dsWIDTH 165 dsCOORD 78 40 dsCOLOR global136)
				(= seconds 20)
			)
			(14
				(gCurRoom drawPic: 99 13)
				(Display 706 10 dsALIGN alCENTER dsWIDTH 165 dsCOORD 78 40 dsCOLOR global136) ; "A five minute time will begin to count down. Beware - anyone within five kilometers of the Star Generator will be in danger once the timer has been initiated. Please be careful and GOOD LUCK !"
				(= seconds 16)
			)
			(15
				(gCurRoom drawPic: 99 13)
				(Display 706 11 dsALIGN alCENTER dsWIDTH 165 dsCOORD 78 40 dsCOLOR global136) ; "END"
				(= seconds 4)
			)
			(16
				(gCurRoom drawPic: 99 13)
				(gLongSong2 fade: loop: 0)
				(gLongSong play: 0 fade: 127 25 10 0)
				(gCast eachElementDo: #show)
				(gCast eachElementDo: #startUpd)
				(gEgo ignoreActors: 0)
				((ScriptID 703 14) init: activate:) ; sarienOfficer1
				((ScriptID 703 15) init: activate:) ; sarienOfficer2
				((gEgo _head:) hide:)
				(gCurRoom drawPic: 61 10)
				(screen setLoop: 2 cel: 0 cycleSpeed: 20 setCycle: Fwd)
				(= seconds 3)
			)
			(17
				(screen dispose:)
				(= seconds 1)
			)
			(18
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

