;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 398)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Language)
(use Feature)
(use User)
(use Actor)
(use System)

(public
	rm398 0
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
	local8
	local9
	local10
	local11
	local12
)

(instance rm398 of SQRoom
	(properties
		picture 398
	)

	(method (init)
		(myIcon init:)
		(super init:)
		(HandsOn)
		(theRoom init:)
		(= local11 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(box1 init: stopUpd: posn: 218 125)
		(box2 init: stopUpd: posn: 175 123)
		(box3 init: stopUpd: posn: 50 150)
		(box5 init: stopUpd: posn: 130 143)
		(box6 init: stopUpd: posn: 216 83)
		(box7 init: stopUpd: posn: 142 94)
		(box9 init: stopUpd: posn: 152 164)
		(if (not (IsFlag 31))
			(box10 init: stopUpd: posn: 186 128)
		)
		(= local4 11)
		(gCast eachElementDo: #perform syncPriority)
		(= local12 (gGame setSpeed:))
		(gGame setSpeed: 0)
		(gTheIconBar disable: 0 3 4 5 6)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(= gUseSortedFeatures local11)
		(gGame setSpeed: local12)
		(super dispose:)
	)
)

(instance showBox of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if
			(and
				(or (== (= temp0 ((User curEvent:) type:)) evMOUSEBUTTON) (== temp0 evKEYBOARD))
				state
			)
			(= temp0 evNULL)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(gCurRoom drawPic: (+ 699 local5) 100)
				(gCast eachElementDo: #hide)
				(scriptHandleEvent init:)
				(= cycles 1)
			)
			(1
				(switch local5
					(1
						(= local6
							(Display ; "From the folks who brought you Astro Chicken! When it comes to stimulating chickens, Cluck Egger is the expert...and now YOU can learn from him! Design the chicken of your choice (over 40 options, including lips/no lips and laying frequency) and take your creation for a wild ride over real barnyard scenery. Based on an authentic flight model of a chicken. You're in for a peck of fun now! #j\b1\bd\c4\db\c1\b7\dd\e9\e0\de\922\e0\de\fd\ff\ff \c1\b7\dd\86 \9c\99\de\97\9d\f9\9a\e4\e6\96\fd\9c\e3\ea \b8\d7\af\b8\a5\b4\af\b6\de\b0\96\de\9e\fd\f3\fd\96\a5\a5\a5\a5 \97\f0\f3\96\fa\96\f7 \ef\e5\ed\de\f9\fd\e0\de\ff  \9d\97\e5\c1\b7\dd\e9\d3\c3\de\d9\86\c3\de\bb\de\b2\dd\9c \e3\a4\9f\fa\86 \92\e5\96\e9\ec\93\99\92\e9 \e5\96\e6 \e2\fa\e3\92\9a\93\ff ( 40\b5\cc\df\bc\ae\dd\e9 \98\f0\91\fc\9e\e3\de\a4\c1\b7\dd\86\c3\de\bb\de\b2\dd\9d \f9\fd\e0\de\ff ) \9a\fa\ea\a4\c1\b7\dd\e9\eb\9a\93\d3\c3\de\d9\e6 \f3\e4\9d\de\92\e3\f9\fd\e0\de\ff \9b\91\a4 \e4\e3\f3 \92\92\c2\af\c2\b7\86\e0\e9\9c\f3\93 \9e\de\ff"
								398
								0
								dsWIDTH
								160
								dsCOORD
								160
								10
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								(proc0_18 12 global132)
								dsSAVEPIXELS
							)
						)
					)
					(2
						(= local6
							(Display ; "Following closely on the heels of his hit "Tic-Tac- Toe Construction Set," Phil Phudge does it again. Using a simple point-and-click interface, you construct the checkerboard of your dreams! Fill in an 8x8 grid with squares of your choice... red or black, in any arrangement as long it's alternating. Don't like it? Erase it and start all over again! Requires MCGA, CGA VGA, PGA or TA-RA-RA-BOOMGA. #j\cb\af\c4\9b\98 \a2\c3\a8\af\b8\a5\c0\af\b8\a5\c4\b3 \ba\dd\bd\c4\d7\b8\bc\ae\dd \be\af\c4\a3 \86\a4\f6\e6 \95\98\f8\e0\de\9c\e0\cc\a8\d9\a5\cc\a7\af\bc\de\96\de \ef\e0\f4\8f\e0\ff\ff\ff \96\fd\e0\fd\e5 \ce\df\b2\dd\c4\e4\b8\d8\af\b8\e9 \b2\dd\c0\b0\cc\aa\b0\bd\86\e2\96\8f\e3\a4\f5\f2\e9 \c1\aa\af\b6\b0\ea\de\fd\96\de\e2\98\fa\f9\fd\e0\de\ff 8x8\e9\9a\de\ea\de\fd\86\a4\98\fb\96 \91\96\e3\de \97\f0\e9 \9d\97\e5\f6\93\e6\f0\e0\9d\fd\e0\de\ff \f3\9c\a4\97\e6\92\f7\e5\99\fa\ea\de \f3\93\92\e1\e4\de \f4\f8\e5\95\9e\f9\f6\ff MCGA\a4CGA\a4VGA\a4\ef\e0\ea TA-RA- RA-BOOMGA\a0 \96\de\eb\e2\f6\93\e3\de\9d\a1"
								398
								1
								dsWIDTH
								160
								dsCOORD
								160
								10
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								(proc0_18 12 global132)
								dsSAVEPIXELS
							)
						)
					)
					(3
						(= local6
							(Display ; "The latest bomb from master storyteller Morrie Brianarty, BOOM is a post-holocaust adventure set in post- holocaust America after the holocaust. Neutron bombs have eradicated all life, leaving only YOU to wander through the wreckage. No other characters, no conflict, no puzzles, no chance of dying and no interface make this the easiest-to-finish game yet! Just boot it up and watch it explode! #j\cf\bd\c0\b0\a5\bd\c4\b0\d8\b0\c3\d7\b0\e3\de\91\f9\a4 \d3\d8\b0\a5\cc\de\d8\b1\c5\b0\c3\a8\96\f7\e9\9b\92\9c\fd \ea\de\98\e0\de\fd\9b\98\eb\fd\ff \a2BOOM\a3 \e9 \ec\de\e0\92\ea \e0\de\92\97\de\8c\98\9b\e2\e9\91\e4\e9 \e0\de\92\97\de\8c\98\9b\e2\9a\de\e9 \b1\d2\d8\b6\e6 \9e\8f\e3\92\9b\fa\e0\a4\e0\de\92\97\de\8c\98\9b\e2\9a\de \e9\b1\c4\de\cd\de\dd\c1\ac\b0\b9\de\b0\d1\e0\de\ff \e1\8d\93\9e\92\9c\ea\de\98\e0\de\fd\96\de\a4\9d\ed\de\e3 \e9\9e\92\f2\92\86\ea\96\92\9c\e3\9c\ef\92\a4 \97\f0\e0\de\99\96\de \9b\de\fd\96\de\92\e9\e5\96\86 \93\fb\e2\92\e3\92\f9\a1 \ee\96\e6\ea\e0\de\fa\f3\92\e5\92\e9\e3\de\a4 \91\f7 \9f\92\f3\e5\92\9c\a4\9c\e7\9a\e4\f3 \9e\de\8f\e0\92\e6 \e5\92\ff \e2\92\e3\de\e6\a4\b2\dd\c0\b0\cc\aa\b0\bd\f3 \e5\92\e0\f2\a4\9c\de\e2\e6\96\fd\e0\fd\e5\b9\de\b0\d1\ff \e0\fd\e6\cc\de\b0\c4\b1\af\cc\df\9c\e3\a4 \ea\de\98\ea\e2 \9d\f9\e9\86\f0\e3\f9\e0\de\99\e3\de \92\92\fd\e0\de\ff"
								398
								2
								dsWIDTH
								160
								dsCOORD
								160
								10
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								(proc0_18 12 global132)
								dsSAVEPIXELS
							)
						)
					)
					(4
						(= local6
							(Display ; "The Two Guys from Andromeda's latest sci-fi comedy, SPACE QUEST IV, will give you hours of frustration#j"
								398
								3
								dsWIDTH
								310
								dsCOORD
								10
								4
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								(proc0_18 12 global132)
								dsSAVEPIXELS
							)
						)
						(= local7
							(Display ; "unless you have this hintbook. Want to know how to get the dog into the hanging basket? Want to find out how to attach the melon? Buy this hintbook and it all becomes obvious. You'll hit your head and say, "Boy, how stupid could I have been? A moron could've figured this out. I must be a real dimwit, a pathetic nimnal, a wretched, #j\b1\dd\c4\de\db\d2\c0\de\96\f7\e9\ec\e0\f8\e9 \9b\92\9c\fd\9b\98\eb\fd \a2\bd\cd\df\b0\bd\a5\b8\b4\bd\c4IV\a3 \ea\a4\9a\e9\cb\dd\c4\cc\de \af\b8\96\de\e5\92\e4\95\fc\f7\e5\92\9f\de\ff \ec\de\f7\9b\96\de\8f\e3\f9\ca\de\bd\b9\af\c4\e6 \92\96\e6\9c\e3 \b2\c7\86 \92\fa\f9\96\9c\f8\e0\92\8f\e3\fe \d2\db\dd\86\e4\de\93\f4\8f\e3\e4\f8\e2\99\f9\96\9c\f8\e0\92\8f\e3\fe \9a\fa\86\96\94\ea\de\a4\9d\ed\de\e3\96\de \fc\96\f9\ff\ff\ff \97\8f\e4\a4\91\e0\ef\86\e0\e0\92\e3\a4 \a2\e5\fd\e3\a4\b5\da\ea \ca\de\b6\e0\de\8f\e0\fd\e0\de\a1 \9a\fd\e5 \96\fd\e0\fd\e5 \ca\df\bd\de\d9\96\de\a4\fc\96\f7\e5\96\8f\e0\e5\fd\e3\ff\ff \b5\da\ea\a4\c9\db\cf\e3\de\b1\ce\e3\de\ca\de\b6\e5 \e4\de\93\9c\f6\93 \f3\e5\92 \e6\fd\99\de\fd\e9\b8\bd\de \e0\de\8f\e0\fd\e0\de\ff\a3\e4\a4 \e5\99\de\98\e4\95\f3\93\f6\a1 \e0\f2\9c\e3\9a\de\f7\fd\ff\ff\ff"
								398
								4
								dsWIDTH
								(LangSwitch 170 195)
								dsCOORD
								(LangSwitch 150 124)
								(LangSwitch 24 28)
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								(proc0_18 12 global132)
								dsSAVEPIXELS
							)
						)
						(= local8
							(Display
								{idiotic excuse for a human being not to have figured out these simple puzzles in the first place." Try it and see!#j }
								dsWIDTH
								170
								dsCOORD
								150
								(LangSwitch 144 180)
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								(proc0_18 12 global132)
								dsSAVEPIXELS
							)
						)
					)
					(5
						(= local6
							(Display ; "It's the newest in the wacky Hymie Lipschitz series! Hymie, son of a wealthy New York furrier, has gone wild with Dad's Frequent Flier vouchers again. Can you track Hymie down and bring him home to meet the girl Mom's picked out for him? Hold on to your yarmulke, Hymie Lipschitz strikes again! 640k, Ronald-MT32 and 3.5" circumcision req'd. #j\e1\8e\8f\e4\96\fc\8f\e0\a4\ca\b2\d0\b0\a5\d8\af\cc\df \bc\af\c2\bc\d8\b0\bd\de\ff \c6\ad\b0\d6\b0\b8\e9 \99\96\de\fc\9c\8e\93\e6\fd\e9 \f1\9d\9a\e9\ca\b2\d0\b0\ea \95\e4\93\9b\fd\e9 \eb\9a\93\97\b8\b0\ce\df\dd\86 \ef\e0\9c\e3\f3 \f7\fd \f6\93\9c\e3\92\f9\a1 \ca\b2\d0\b0\96\de\e4\de\9a\e6 \92\f9\96\86\9b\96\de\9c\e0\de\9c\e3\a4\95\f0\91\92\9b\9e \f9\e0\f2\e6\92\94\e6\e2\fa\e3\96\94\8f\e3\9a\fa\f9 \96\92\fe  \9b\87\a4\ca\b2\d0\b0\a5\d8\af\cc\df\bc\af \c2\96\de\a4\ef\e0\9c\e3\f3 \e0\de\92\ec\fd\e4\93\ff\ff \9c\de\8d\fd\eb\de\ea\92\92\96\92\fe \d2\d3\d8\b0640k, Ronald-MT32, 3.5\b2\dd\c1\e9\cd\de\b0\b8\de\d9\96\de \eb\e2\f6\93\e3\de\9d\a1"
								398
								5
								dsWIDTH
								160
								dsCOORD
								160
								(LangSwitch 5 15)
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								(proc0_18 12 global132)
								dsSAVEPIXELS
							)
						)
					)
					(6
						(= local6
							(Display ; "Presenting the latest in the award-winning King's Quest series, from the still-active mind of aging Roberta Williams III, latest in the award-winning Roberta Williams series. What happens when Old Man Graham and his family are kicked out of Daventry Condo Association? You'll meet the Fabulous Bernoulli Brothers, Prof. C.D. Romberg, and of course, Rumplestiltskin! Over 12 Gigabytes in length! #j \db\ca\de\b0\c0\a5\b3\a8\d8\b1\d1\bd\de\e9\9b\92\9c\fd \9b\98\ff \9a\93\e8\fd\fa\92\e6\e5\8f\e3\f3\a4\92\f6\98 \e3\97\e5\db\ca\de\b0\c0\a5\b3\a8\d8\b1\d1\bd\de3\9e\92\e9 \9c\de\8d\9c\8e\93\9b\98\a0 \b7\dd\b8\de\bd\de\a5\b8\b4\bd\c4 \bc\d8\b0\bd\de\9b\92\9c\fd\9b\98\86\95\e4\e4\de\99\9c \f6\93\a1 \e4\9c\e4\8f\e0\b8\de\d7\ca\d1\e4\9f\e9\96\9f\de\98\96\de\a4 \c0\de\cd\de\dd\c4\d8\b0\e9\ba\dd\c4\de\d0\c6\b1\d1 \97\8e\93\96\92\96\f7\95\92\e0\de\9b\fa\e0\f7\e4\de \93\e5\f9\96\fe \9d\ea\de\f7\9c\92\ca\de\b0\c9\b3\d8\97\8e\93\e0\de\92\a4 C.D.ROM\ca\de\b0\b8\de\97\8e\93\9c\de\8d\a4 \9f\fa\e6 \d7\d1\cc\df\da\bd\c3\a8\d9\c2\b7\dd\e6 \91\93\9a\e4\96\de\e3\de\97\f9\9f\de\ff 12\b7\de\b6\de\ca\de\b2\c4\92\9c\de\8e\93\e9\f6\93\f8\8e\93 \e3\de\9d\a1"
								398
								6
								dsWIDTH
								160
								dsCOORD
								160
								5
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								(proc0_18 12 global132)
								dsSAVEPIXELS
							)
						)
					)
					(7
						(= local6
							(Display ; "It's here at last! With a combination of SAI (Simulated Artificial Intelligence), and VRAI (Virtually Real Artificial Intelligence), we at MaxThis! Software have created a simulated simulator experience that's unlike anything you've ever simulated playing before. With Sim Sim, you can create a simulated environment in which you can create any simulated environment you want! #j\e2\92\e6\f4\8f\e3\97\e0\ff SAI\e4VRAI\e9\ba\dd\cb\de\c8\b0\bc\ae\dd\e3\de\a4 \fc\96\de\cf\af\b8\bc\de\bd\a5\bf\cc\c4\b3\aa\b1\e3\de\ea\a4 \92\ef\ef\e3\de\e0\de\fa\f3\99\92\99\fd\9c\e0\9a\e4\e9 \e5\92\a4\bc\ad\d0\da\b0\c3\af\c4\de\a5\bc\ad\d0\da\b0 \c0\86\e2\98\f8\e0\de\9c\e0\ff \9a\e9\bc\d1\bc\d1\86\e2\96\94\ea\de\a4\97\f0\96\de \e9\9f\de\f1 \e4\de\fd\e5\bc\ad\d0\da\b0\c4\96\fd\97 \8e\93\e3\de\f3\e2\98\f8\e0\de\9d\9a\e4\96\de\e3\de\97 \f9\fd\e0\de\ff"
								398
								7
								dsWIDTH
								160
								dsCOORD
								160
								5
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								(proc0_18 12 global132)
								dsSAVEPIXELS
							)
						)
					)
					(8
						(= local6
							(Display ; "Formerly entitled "Hero's Flyer," this is the flight simulator you've been waiting for. Tired of flight simulators that "load" and "run?" Still looking for a sim that really crashes? Featuring a stunning 3-D filled polygon, Stunt Flyer will have you going through the roof the moment you get it home."
								398
								8
								dsWIDTH
								160
								dsCOORD
								160
								5
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								(proc0_18 12 global132)
								dsSAVEPIXELS
							)
						)
					)
					(9
						(= local6
							(Display ; "Head for the hills! It's coming, and this time, it's HUNGRY! IT CAME FOR DESSERT is a thrilling action/adventure in which a mob of pushy, overweight relatives invade your kitchen. Armed with only a Jello mold and a pastry bag, you must repel the invaders...always keeping an eye on your blood sugar level. It's the merriest mix-up since Enemaware's fabulous DEFENDER OF THE CROWN RIB ROAST. #j\95\96\e6\f1\96\8f\e3\a4\ea\9c\fa\ff\ff \98\f9\ff\a0 \98\f9\ff\ff\a0 \98\f9\ff\ff\ff \9a\fd\e4\de\ea\a4\ea\f7\86 \9d\96\9e\e3\92\f9\ff IT CAME FOR DESSERT \ea\a4 \94\f7\9f\93\e6\f2\92\fa\92\9d\f9 \ec\e4\8f\e0 \9c\fd\9e\97\e0\e1\96\de\97\f0\e9\e0\de\92\e4\de\9a\fb \86\e9\8f\e4\8f\e3\9c\ef\93\a4\dc\b8\dc\b8\9d\f9 \b1\b8\bc\ae\dd\a5\b1\c4\de\cd\de\dd\c1\ac\b0\e0\de\ff\ff\ff \be\de\d8\b0\e9\96\e0\ea\de\fd\e4 \95\96\9c\f6\93\e9 \ec\98\fb\e0\de\99\e3\de \ec\de\9f\93\9c\e0\97\f0\ea\a4 \9c\fd\e6\8d\93\9c\8c\86\95\92\e0\de\9b\e5\99\fa\ea\de \e5\f7\e5\92\a1 \a5\a5\a5\a5\e0\94\9d\de\a4\97\f0\e9 \99\e2\94\97\e1\8d\93\e9\e4\93\ec\de\fd\e6 \97\86 \e2\99\e5\96\de\f7\e8\ff \b4\c8\cf\b3\aa\b1\e9DEFENDER OF THE CROWN RIB ROAST\92\f7\92\a4\f3\8f\e4\f3 \e0\e9\9c\92\e0\de\92\9a\fd\f7\fd\e0\de\ff"
								398
								9
								dsWIDTH
								160
								dsCOORD
								160
								5
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								(proc0_18 12 global132)
								dsSAVEPIXELS
							)
						)
					)
					(10
						(= local6
							(Display ; "Imagine a character SO offensive, SO sexually inept, and SO lame-brained that you just can't wait to step into his shoes! That's Dacron Danny, first in the Sahara Off-Ramp's new educational series of true-life adventures from the team of Hal Lowe- Ken Hugo. Learn how others see YOU! Dacron Danny..... your computer guide to your inner self!"
								398
								10
								dsWIDTH
								160
								dsCOORD
								160
								5
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								(proc0_18 12 global132)
								dsSAVEPIXELS
							)
						)
					)
				)
			)
			(2
				(switch
					(Print ; "What do you want to do with this piece?"
						398
						11
						#mode
						0
						#button
						{ Price #j  \e8\e0\de\fd\86\f0\f9  }
						0
						#button
						{ Keep #j  \f3\8f\e3\95\98  }
						1
						#button
						{ Resume #j  \ee\96\e9\86\f0\f9 }
						2
						#button
						{ Done #j  \f4\f2\f9  }
						3
					)
					(0
						(Printf 398 12 (local10 myPrice:) (local10 myPrice:)) ; "This one is %d buckazoids."
						(-= state 1)
						(= cycles 1)
					)
					(1
						(if (!= local5 4)
							(Print 398 13) ; "You don't have that much money!"
							(-= state 1)
							(= cycles 1)
						else
							(gEgo get: 8) ; hintbook
							(gEgo get: 9) ; pen
							(= local2 0)
							(= global160 local5)
							(box10 dispose:)
						)
					)
					(2 0)
					(3
						(gTheIconBar enable:)
						(gCurRoom newRoom: 397)
					)
				)
				(scriptHandleEvent dispose:)
				(= cycles 1)
			)
			(3
				(gTheIconBar disable:)
				(Display 398 14 dsRESTOREPIXELS local6)
				(= cycles 1)
			)
			(4
				(gTheIconBar disable:)
				(Display 398 14 dsRESTOREPIXELS local7)
				(= cycles 1)
			)
			(5
				(gTheIconBar disable:)
				(Display 398 14 dsRESTOREPIXELS local8)
				(= cycles 1)
			)
			(6
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 398)
				(= cycles 1)
			)
			(7
				(gTheIconBar enable:)
				(client setScript: 0)
			)
		)
	)
)

(instance syncPriority of Code
	(properties)

	(method (doit param1)
		(-- local4)
		(param1 setPri: local4)
	)
)

(class boxProp of Prop
	(properties
		boxID 0
		pIndex -1
		tooHigh 0
		myPrice 0
	)

	(method (init)
		(super init:)
		(if (== boxID 4)
			(self myPrice: 5)
		else
			(self myPrice: (+ gBuckazoidCount (Random 1 15)))
		)
		(if (== global160 (self boxID:))
			(self delete:)
			(self dispose:)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1 temp2 temp3)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(= temp3
				(if (super onMe: temp0 temp1)
					(or
						(== local2 self)
						(&
							(= temp2 (OnControl PRIORITY temp0 temp1))
							(<< $0001 priority)
						)
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 3) ; Do
				(cond
					((== local2 0)
						(self startUpd:)
						(= local2 self)
						(self doit:)
						(gCast delete: self)
						(gCast addToFront: self)
						(self pIndex: 12)
					)
					((== local2 self)
						(if (!= local2 local3)
							(= local3 local2)
							(= local4 11)
							(gCast eachElementDo: #perform syncPriority)
						)
						(= local2 0)
						(self pIndex: 11 stopUpd:)
						(if (< (self y:) 90)
							(= tooHigh 1)
						)
					)
				)
				(self setPri: pIndex)
			)
			((== theVerb 2) ; Look
				(if (and (!= local2 0) (!= local2 self))
					0
				else
					(= local5 (self boxID:))
					(= local10 self)
					(gCurRoom setScript: showBox)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit &tmp temp0 [temp1 2])
		(super doit:)
		(if (and (== local2 self) (== ((gTheIconBar curIcon:) message:) 3))
			(= temp0 (User curEvent:))
			(= local0 (temp0 x:))
			(= local1 (+ (temp0 y:) 10))
			(if (> local0 235)
				(= local0 235)
			)
			(if (< local0 50)
				(= local0 50)
			)
			(if (> local1 155)
				(= local1 155)
			)
			(self x: local0 y: local1)
		)
		(if (== (self tooHigh:) 1)
			(if (< (self y:) (Random 110 160))
				(self y: (+ (self y:) 15) startUpd:)
			else
				(self stopUpd:)
				(= tooHigh 0)
			)
		)
	)
)

(instance box1 of boxProp
	(properties
		description {bin full of cheap software}
		view 399
		boxID 1
	)
)

(instance box2 of boxProp
	(properties
		description {bin full of cheap software}
		view 399
		cel 1
		boxID 2
	)
)

(instance box3 of boxProp
	(properties
		description {bin full of cheap software}
		view 399
		cel 2
		boxID 3
	)
)

(instance box10 of boxProp
	(properties
		description {bin full of cheap software}
		view 399
		cel 3
		boxID 4
	)
)

(instance box5 of boxProp
	(properties
		description {bin full of cheap software}
		view 399
		cel 4
		boxID 5
	)
)

(instance box6 of boxProp
	(properties
		description {bin full of cheap software}
		view 399
		cel 5
		boxID 6
	)
)

(instance box7 of boxProp
	(properties
		description {bin full of cheap software}
		view 399
		cel 6
		boxID 7
	)
)

(instance box8 of boxProp ; UNUSED
	(properties
		description {bin full of cheap software}
		view 399
		cel 7
		boxID 8
	)
)

(instance box9 of boxProp
	(properties
		description {bin full of cheap software}
		view 399
		cel 8
		boxID 9
	)
)

(instance box4 of boxProp ; UNUSED
	(properties
		description {bin full of cheap software}
		view 399
		cel 9
		boxID 10
	)
)

(instance theRoom of Feature
	(properties
		x 159
		y 94
		nsTop -1
		nsBottom 189
		nsRight 319
		description {room}
		sightAngle 90
	)
)

(instance myIcon of Prop
	(properties
		x 280
		y 30
		description {}
		view 399
	)

	(method (doVerb)
		(self setScript: doneWasClicked)
	)

	(method (show)
		(= loop (LangSwitch 2 1))
		(super show: &rest)
	)

	(method (init)
		(= loop (LangSwitch 2 1))
		(super init: &rest)
	)
)

(instance doneWasClicked of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myIcon setCel: 1)
				(= cycles 3)
			)
			(1
				(myIcon setCel: 0)
				(= cycles 1)
			)
			(2
				(gCurRoom newRoom: 397)
				(self dispose:)
			)
		)
	)
)

(instance scriptHandleEvent of Feature
	(properties)

	(method (handleEvent event)
		(event claimed: 1)
		(= local9 1)
	)
)

