;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 398)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Dialog)
(use Sq4Narrator)
(use Sq4Feature)
(use User)
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
	[local12 100]
	[local112 30]
	[local142 30]
	[local172 30]
	[local202 30]
	[local232 40]
	[local272 40]
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
		(= local10 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(box1 posn: 218 125 init: stopUpd:)
		(box2 posn: 175 123 init: stopUpd:)
		(box3 posn: 50 150 init: stopUpd:)
		(box5 posn: 130 143 init: stopUpd:)
		(box6 posn: 216 83 init: stopUpd:)
		(box7 posn: 142 94 init: stopUpd:)
		(box9 posn: 152 164 init: stopUpd:)
		(if (not (IsFlag 31))
			(box10 posn: 186 128 init: stopUpd:)
		)
		(= local4 11)
		(gCast eachElementDo: #perform syncPriority)
		(= local11 gGameSpeed)
		(= gGameSpeed 0)
		(gTheIconBar disable: 0 3 4 5 6)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(= gUseSortedFeatures local10)
		(= gGameSpeed local11)
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

	(method (changeState newState &tmp temp0)
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
						(salesPitch talkWidth: 160 x: 160 y: 10 say: 1 self) ; "From the folks who brought you Astro Chicken! When it comes to stimulating chickens, Cluck Egger is the expert...and now YOU can learn from him! Design the chicken of your choice (over 40 options, including lips/no lips and laying frequency) and take your creation for a wild ride over real barnyard scenery. Based on an authentic flight model of a chicken. You're in for a peck of fun now!"
					)
					(2
						(salesPitch talkWidth: 160 x: 160 y: 10 say: 2 self) ; "Following closely on the heels of his hit "Tic-Tac- Toe Construction Set," Phil Phudge does it again. Using a simple point-and-click interface, you construct the checkerboard of your dreams! Fill in an 8x8 grid with squares of your choice... red or black, in any arrangement as long it's alternating. Don't like it? Erase it and start all over again! Requires MCGA, CGA VGA, PGA or TA-RA-RA-BOOMGA."
					)
					(3
						(salesPitch talkWidth: 160 x: 160 y: 10 say: 3 self) ; "The latest bomb from master storyteller Morrie Brianarty, BOOM is a post-holocaust adventure set in post- holocaust America after the holocaust. Neutron bombs have eradicated all life, leaving only YOU to wander through the wreckage. No other characters, no conflict, no puzzles, no chance of dying and no interface make this the easiest-to-finish  game yet! Just boot it up and watch it explode!"
					)
					(4
						(salesPitch talkWidth: 170 x: 150 y: 1 say: 4 self) ; "The Two Guys from Andromeda's latest sci-fi comedy, SPACE QUEST IV, will give you hours of frustration unless you have this hintbook. Want to know how to get the dog into the hanging basket? Want to find out how to attach the melon? Buy this hintbook and it all becomes obvious. You'll hit your head and say, "Boy, how stupid could I have been? A moron could've figured this out. I must be a real dimwit, a pathetic nimnal, a wretched, idiotic excuse for a human being not to have figured out these simple puzzles in the first place." Try it and see!"
					)
					(5
						(salesPitch talkWidth: 160 x: 160 y: 10 say: 5 self) ; "It's the newest in the wacky Hymie Lipschitz series! Hymie, son of a wealthy New York furrier, has gone wild with Dad's Frequent Flier vouchers  again. Can you track  Hymie down and bring him home to meet the girl Mom's picked out for him? Hold on to your yarmulke, Hymie Lipschitz strikes again! 640k, Ronald-MT32 and 3.5" circumcision req'd."
					)
					(6
						(salesPitch talkWidth: 160 x: 160 y: 10 say: 6 self) ; "Presenting the latest in the award-winning King's Quest series, from the still-active mind of aging Roberta Williams III, latest in the award-winning Roberta Williams series. What happens when Old Man Graham and his family are kicked out of Daventry Condo Association? You'll meet the Fabulous Bernoulli Brothers, Prof. C.D. Romberg, and of course, Rumplestiltskin! Over 12 Gigabytes in length!"
					)
					(7
						(salesPitch talkWidth: 160 x: 160 y: 5 say: 7 self) ; "It's here at last! With a combination of SAI (Simulated Artificial Intelligence), and VRAI (Virtually Real Artificial Intelligence), we at MaxThis! Software have created a  simulated simulator experience that's unlike anything you've ever simulated playing before. With Sim Sim, you can create a simulated environment in which you can create any simulated environment you want!"
					)
					(8
						(salesPitch talkWidth: 160 x: 160 y: 5 say: 8 self) ; "Formerly entitled "Hero's Flyer," this is the flight simulator you've been waiting for. Tired of flight simulators that "load" and "run?" Still looking for a sim that really crashes? Featuring a stunning 3-D filled polygon, Stunt Flyer will have you going through the roof the moment you get it home."
					)
					(9
						(salesPitch talkWidth: 160 x: 160 y: 5 say: 9 self) ; "Head for the hills! It's coming, and this time, it's HUNGRY! IT CAME FOR  DESSERT is a thrilling  action/adventure in which a mob of pushy, overweight relatives invade your kitchen. Armed with only a Jello mold and a pastry bag, you must repel the invaders...always keeping an eye on your blood sugar level. It's the merriest mix-up since Enemaware's fabulous DEFENDER OF THE CROWN RIB ROAST."
					)
					(10
						(salesPitch talkWidth: 160 x: 160 y: 5 say: 10 self) ; "Imagine a character SO offensive, SO sexually inept, and SO lame-brained that you just can't wait to step into his shoes! That's Dacron Danny, first in the Sahara Off-Ramp's new educational series of true-life adventures from the team of Hal Lowe- Ken Hugo. Learn how others see YOU! Dacron Danny..... your computer guide to your inner self!"
					)
				)
			)
			(2
				(Message msgGET 398 97 0 1 1 @local12) ; "What do you want to do with this piece?"
				(Message msgGET 398 97 0 2 1 @local112) ; "Price"
				(Message msgGET 398 97 0 3 1 @local142) ; "Keep"
				(Message msgGET 398 97 0 4 1 @local172) ; "Resume"
				(Message msgGET 398 97 0 13 1 @local202) ; "Done"
				(switch
					(proc816_1
						@local12
						27
						0
						78
						@local112
						0
						78
						@local142
						1
						78
						@local172
						2
						78
						@local202
						3
					)
					(0
						(Message msgGET 398 99 0 14 1 @local272) ; "Only %d Buckazoids!"
						(Format @local232 @local272 (local9 myPrice:))
						(= temp0
							(Display
								@local232
								dsCOORD
								20
								180
								dsWIDTH
								120
								dsCOLOR
								global132
								dsSAVEPIXELS
							)
						)
						(-= state 1)
						(= cycles 1)
					)
					(1
						(if (!= local5 4)
							(gNarrator say: 12) ; "You don't have that much money!"
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
				(Display 398 0 dsRESTOREPIXELS temp0) ; UNINIT
				(= cycles 1)
			)
			(4
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 398)
				(= cycles 1)
			)
			(5
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

(class boxProp of Sq4Prop
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
			((== theVerb 4) ; Do
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
			((== theVerb 1) ; Look
				(if (and (!= local2 0) (!= local2 self))
					0
				else
					(= local5 (self boxID:))
					(= local9 self)
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
		(if (and (== local2 self) (== ((gTheIconBar curIcon:) message:) 4))
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
		view 399
		boxID 1
	)
)

(instance box2 of boxProp
	(properties
		view 399
		cel 1
		boxID 2
	)
)

(instance box3 of boxProp
	(properties
		view 399
		cel 2
		boxID 3
	)
)

(instance box10 of boxProp
	(properties
		view 399
		cel 3
		boxID 4
	)
)

(instance box5 of boxProp
	(properties
		view 399
		cel 4
		boxID 5
	)
)

(instance box6 of boxProp
	(properties
		view 399
		cel 5
		boxID 6
	)
)

(instance box7 of boxProp
	(properties
		view 399
		cel 6
		boxID 7
	)
)

(instance box9 of boxProp
	(properties
		view 399
		cel 8
		boxID 9
	)
)

(instance theRoom of Sq4Feature
	(properties
		x 159
		y 94
		nsTop -1
		nsBottom 189
		nsRight 319
		sightAngle 90
	)
)

(instance myIcon of Sq4Prop
	(properties
		x 280
		y 30
		view 399
		loop 1
	)

	(method (doVerb)
		(self setScript: doneWasClicked)
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

(instance salesPitch of Sq4Narrator
	(properties
		noun 99
		modNum 398
		modeless 1
		nMsgType 3
	)

	(method (display param1)
		(= local6
			(Display
				param1
				dsWIDTH
				talkWidth
				dsCOORD
				x
				y
				dsALIGN
				alLEFT
				dsFONT
				68
				dsCOLOR
				global132
				dsSAVEPIXELS
			)
		)
	)

	(method (dispose)
		(Display 398 0 dsRESTOREPIXELS local6)
		(super dispose: &rest)
	)
)

(instance scriptHandleEvent of Sq4Feature
	(properties)

	(method (handleEvent event)
		(event claimed: 1)
		(= local8 1)
	)
)

