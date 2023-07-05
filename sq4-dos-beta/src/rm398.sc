;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 398)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
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
)

(instance rm398 of SQRoom
	(properties
		picture 398
	)

	(method (init)
		(super init:)
		(HandsOn)
		(= local9 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(box1 init: stopUpd: posn: 218 125)
		(box2 init: stopUpd: posn: 175 123)
		(box3 init: stopUpd: posn: 50 150)
		(box4 init: stopUpd: posn: 140 170)
		(box5 init: stopUpd: posn: 130 143)
		(box6 init: stopUpd: posn: 216 83)
		(box7 init: stopUpd: posn: 142 94)
		(box8 init: stopUpd: posn: 106 114)
		(box9 init: stopUpd: posn: 152 164)
		(if (not (SetFlag 33))
			(box10 init: stopUpd: posn: 186 128)
		)
		(= local4 11)
		(gCast eachElementDo: #perform syncPriority)
	)

	(method (dispose)
		(= gUseSortedFeatures local9)
		(super dispose:)
	)
)

(instance showBox of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== local7 1)
			(= local7 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: (+ 699 local5) 100)
				(gCast eachElementDo: #hide)
				(scriptHandleEvent init:)
				(= cycles 1)
			)
			(1
				(switch local5
					(1
						(= local6
							(Display
								{From the folks who brought\nyou Astro Chicken! When it\ncomes to stimulating\nchickens, Cluck Egger is\nthe expert...and now YOU\ncan learn from him! Design\nthe chicken of your choice\n(over 40 options, including\nlips/no lips and laying\nfrequency) and take your\ncreation for a wild ride\nover real barnyard scenery.\nBased on an authentic flight\nmodel of a chicken. You're\nin for a peck of fun now!}
								dsWIDTH
								275
								dsCOORD
								160
								10
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								12
								dsSAVEPIXELS
							)
						)
					)
					(2
						(= local6
							(Display
								{Following closely on the\nheels of his hit "Tic-Tac-\nToe Construction Set," Phil\nPhudge does it again. Using\na simple point-and-click\ninterface, you construct the\ncheckerboard of you dreams!\nFill in an 8x8 grid with\nsquares of your choice....\nred or black, in any\narrangement as long it's\nalternating. Don't like it?\nErase it and start all over\nagain! Requires MCGA, CGA\nVGA, PGA or TA-RA-RA-BOOMGA}
								dsWIDTH
								275
								dsCOORD
								160
								10
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								12
								dsSAVEPIXELS
							)
						)
					)
					(3
						(= local6
							(Display
								{The latest bomb from master\nstoryteller Morrie Brianarty,\nBOOM is a post-holocaust\nadventure set in post-\nholocaust America after the\nholocaust. Neutron bombs\nhave eradicated all life,\nleaving only YOU to wander\nthrough the wreckage. No\nother characters, no\nconflict, no puzzles and\nno interface make this\nthe easiest-to- finish \ngame yet! Just boot it\nup and watch it explode!}
								dsWIDTH
								275
								dsCOORD
								160
								10
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								12
								dsSAVEPIXELS
							)
						)
					)
					(4
						(= local6
							(Display
								{The Two Guys from Andromeda's\nlatest sci-fi comedy, SPACE\nQUEST IV, will give you hours\nof frustration unless you have\nthis hintbook. Want to know\nhow to get the dog into the\nhanging basket? Want to find\nout how to attach the melon?\nBuy this hintbook and it all\nbecomes obvious. You'll hit\nyour head and say, "Boy, how\nstupid could I have been? A\nmoron could've figured this\nout. I must be a real dimwit,\na pathetic nimnal, a wretched,\nidiotic excuse for a human\nbeing not to have figured\nout these simple puzzles in\nthe first place." Try it\nand see!}
								dsWIDTH
								275
								dsCOORD
								150
								10
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								12
								dsSAVEPIXELS
							)
						)
					)
					(5
						(= local6
							(Display
								{It's the newest in the\nwacky Hymie Lipschitz\nseries! Hymie, son of a\nwealthy New York furrier,\nhas gone wild with Dad's\nFrequent Flier vouchers \nagain. Can you track \nHymie down and bring him\nhome to meet the girl Mom's\npicked out for him? Hold\non to your yarmulke, Hymie\nLipschitz strikes again!\n640k, Ronald-MT32 and\n3.5" circumcision req'd.}
								dsWIDTH
								275
								dsCOORD
								160
								5
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								12
								dsSAVEPIXELS
							)
						)
					)
					(6
						(= local6
							(Display
								{Presenting the latest in\nin the award-winning King's\nQuest series, from the\nstill-active mind of aging\nRoberta Williams III,\nlatest in the award-\nwinning Roberta Williams\nseries! What happens when\nOld Man Graham and his\nfamily are kicked out of\nDaventry Condo Association\nfor creating a fire hazard\nwith their old disks?\nYou'll meet the Fabulous\nBernoulli Brothers, Prof.\nC.D. Romberg, and of\ncourse, Rumplestiltskin!\nOver 12 Gigabytes in\nlength! 640 mhz or\ngreater recommended.}
								dsWIDTH
								275
								dsCOORD
								160
								5
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								12
								dsSAVEPIXELS
							)
						)
					)
					(7
						(= local6
							(Display
								{It's here at last! With\na combination of SAI\n(Simulated Artificial\nIntelligence), and VRAI\n(Virtually Real Artificial\nIntelligence), we at MaxThis!\nSoftware have created a \nsimulated simulator\nexperience that's unlike\nanything you've ever\nsimulated playing before.\nWith Sim Sim, you can\ncreate a simulated\nenviroment in which you\ncan create any simulated\nenviroment you want!}
								dsWIDTH
								275
								dsCOORD
								160
								5
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								12
								dsSAVEPIXELS
							)
						)
					)
					(8
						(= local6
							(Display
								{Formerly entitled "Hero's\nFlyer," this is the flight\nsimulator you've been\nwaiting for. Tired of\nflight simulators that\n"load" and "run?" Still\nlooking for a sim that\nreally crashes? Featuring\na stunning 3-D filled\npolygon, Stunt Flyer will\nhave you going through\nthe roof the moment you\nget it home.}
								dsWIDTH
								275
								dsCOORD
								160
								5
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								12
								dsSAVEPIXELS
							)
						)
					)
					(9
						(= local6
							(Display
								{Head for the hills! It's\ncoming, and this time, it's\nHUNGRY! IT CAME FOR \nDESSERTis a thrilling \naction/adventure in which\na mob of pushy, overweight\nrelatives invade your\nkitchen. Armed with only\na jello mod and a pastry\nbag, you must repel the\ninvaders...always keeping an\neye on your blood sugar\nlevel. It's the merriest\nmix-up since Enemaware's\nfabulous DEFENDER OF THE\nCROWN RIB ROAST.}
								dsWIDTH
								275
								dsCOORD
								160
								5
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								12
								dsSAVEPIXELS
							)
						)
					)
					(10
						(= local6
							(Display
								{Imagine a character SO\noffensive, SO sexually inept,\nand SO lame-brained that you\njust can't wait to step into\nhis shoes! That's Dacron\nDanny, first in the Sahara\nOff-Ramp's new educational\nseries of true-life adventures\nfrom the team of Hal Lowe-\nKen Hugo. Learn how others\nsee YOU! Dacron Danny.....\nyour computer guide to your\ninner self!}
								dsWIDTH
								275
								dsCOORD
								160
								5
								dsALIGN
								alLEFT
								dsFONT
								68
								dsCOLOR
								12
								dsSAVEPIXELS
							)
						)
					)
				)
			)
			(2
				(switch
					(Print ; "*** What do you want to do with this box?"
						398
						0
						#mode
						0
						#button
						{ Price }
						0
						#button
						{ Keep }
						1
						#button
						{ Resume }
						2
						#button
						{ Done }
						3
					)
					(0
						(Printf 398 1 (local8 myPrice:)) ; "This piece of fine software is %d buckazoids"
						(-= state 1)
						(= cycles 1)
					)
					(1
						(if (!= local5 4)
							(Print 398 2) ; "*** You don't have that much money!"
							(= global160 0)
							(-= state 1)
							(= cycles 1)
						else
							(= global160 local5)
						)
					)
					(2
						(= global160 0)
					)
					(3
						(gCurRoom newRoom: 397)
					)
				)
				(scriptHandleEvent dispose:)
				(= cycles 1)
			)
			(3
				(Display 398 3 dsRESTOREPIXELS local6)
				(= cycles 10)
			)
			(4
				(if (!= global160 0)
					(gCurRoom newRoom: 397)
				else
					(= cycles 1)
				)
			)
			(5
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 398)
				(= cycles 5)
			)
			(6
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
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(cond
					((== local2 0)
						(= local2 self)
						(gCast delete: self)
						(gCast addToFront: self)
						(self startUpd:)
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
					(else
						(Print 398 4) ; "error- report please"
					)
				)
				(self setPri: pIndex)
			)
			((== theVerb 1) ; Look
				(= local5 (self boxID:))
				(= local8 self)
				(gCurRoom setScript: showBox)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (== local2 self) (== ((gIconBar curIcon:) message:) 4))
			(= temp0 (User curEvent:))
			(= local0 (temp0 x:))
			(= local1 (temp0 y:))
			(cond
				((> local0 235)
					(self x: 235 y: (+ local1 10))
				)
				((< local0 50)
					(self x: 50 y: (+ local1 10))
				)
				((> local1 180)
					(self x: local0 y: 180)
				)
				(else
					(self x: local0 y: (+ local1 10))
				)
			)
		)
		(if (== global160 (self boxID:))
			(self delete:)
			(self dispose:)
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

(instance box8 of boxProp
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

(instance box4 of boxProp
	(properties
		description {bin full of cheap software}
		view 399
		cel 9
		boxID 10
	)
)

(instance scriptHandleEvent of Feature
	(properties)

	(method (handleEvent event)
		(event claimed: 1)
		(= local7 1)
	)
)

