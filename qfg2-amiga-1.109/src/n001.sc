;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use User)

(public
	HandsOff 0
	HandsOn 1
	Face 2
	MouseClaimed 3
	OnButton 4
	ChooseFromCycle 5
	IsFlag 6
	SetFlag 7
	ClearFlag 8
	Rand200 9
	MakeSign 10
	cls 11
	HaveMem 12
	HighPrint 13
	LowPrint 14
	TimePrint 15
	CenterPrint 16
	Eval 17
	AskWhat 18
	NormalEgo 19
	EgoGait 20
	SaidInv 21
	WtCarried 22
	MaxLoad 23
	EgoDead 24
	PromptQuit 25
	PromptRestart 26
	PromptPause 27
	ShowCredits 28
	ShowHelp 29
	NoRoom 30
	InitFeatures 31
	StartTimer 32
	DontMove 33
	DontTalk 34
	ShowTheCursor 35
)

(local
	printLen
	[printRect 4]
	[askSpecs 33] = [0 '//shapeir' '//raseir' '//djinn' '//elemental<fire' '//elemental<water' '//elemental<air' '//elemental<earth' '//elemental' '//monster' '//magic,spell' '//harun' '//emir' '//wit,institute,(club<magic,technocery)' '//castle,castle' '//caravan' '//desert' '//hill,hill' '//alm,alm,alm,gold,dinar' '//thief,(club<thief)' '//(hall<club),club' '//hotel,bar,(tail,fable,parrot<catperson,tail,fable,blue)' '//weather,climate' '//fount' '//rumor,secret' '//dinarzad,changer' '//astrologer,abu' '//enchantress,aziza' '//poet,omar' '//merchant' '//catperson,cat' '//dervish,ermit' '//identity']
	[invNames 58] = ['/cent[<brass]' '/dinar[<golden]' '/food,provision' '/blade[<broad]' '/dagger[<!*]' '/leather,armor' '/shield' '/note,bulletin,scroll' '/boulder[<little]' '/lockpick[<lock]' '/kit[<thief,implement]' '/certificate[<thief,club]' '/frankincense,pouch' '/beard,whirl' '/chainmail,(chainmail<chain)' '/rope[<magic]' '/gold,(alm[<gold])' '/pill<healing,health' '/pill<mana,magic' '/pill<energy,stamina' '/potion<disenchant,disenchant' '/map' '/compass' '/blade[<fine]' '/bellows' '/bouquet,bouquet' '/pin,needle[<sapphire]' '/feather[<griffin]' '/tail[<scorpion]' '/claw[<ghoul]' '/soulforge,forge[<soul]' '/pan/dirt' '/lamp[<brass]' '/basket' '/pan<empty' '/fruit<compassion' '/(water[<!*]),waterbag,(skin<water)' '/bag<cloth' '/powder[<burn]' '/badge[<eof,member,secret]' '/visa' '/grease,(contain,bottle<grease)' '/(water<magic,elemental),(elemental<water)' '/ring[<djinn]' '/scarf[<silk]' '/mirror[<hand]' '/bird,falcon[<black]' '/pill<cure,poison' '/clothes' '/saurii' '/sand,bag[/sand]' '/(bag[<earth,elemental]),(earth,dirt<magic,elemental),(elemental<earth)[/earth,elemental]' '/samovar,(pan,service[<tea,silver])' '/glasses[<ray,fakir,ali,(fakir<ali)]' '/purse[<leather]' '/dagger<silver' '/bowl[<emerald,silver]' '/nail[<rusty]']
)

(procedure (ShowTheCursor xPos yPos &tmp newCurs showIt)
	(= showIt 1)
	(cond
		((and gCantMove gCantTalk)
			(= newCurs gWaitCursor)
		)
		(gCantMove
			(= newCurs gNoWalkCursor)
		)
		(gCantTalk
			(= newCurs gNoTalkCursor)
		)
		(else
			(= newCurs gNormalCursor)
			(= showIt (HaveMouse))
		)
	)
	(if argc
		(gGame setCursor: newCurs showIt xPos yPos)
	else
		(gGame setCursor: newCurs showIt)
	)
)

(procedure (HandsOff)
	(DontMove 1)
	(DontTalk 1)
)

(procedure (HandsOn allHands)
	(if (and argc allHands)
		(= gCantMove 1)
		(= gCantTalk 1)
	)
	(DontMove 0)
	(DontTalk 0)
)

(procedure (DontMove yesNo &tmp showIt)
	(= showIt 0)
	(cond
		(yesNo
			(if (not gCantMove)
				(User canControl: 0)
				(= showIt 1)
			)
			(if (< argc 2)
				(gEgo setMotion: 0)
			)
			(++ gCantMove)
		)
		((<= (-- gCantMove) 0)
			(= gCantMove 0)
			(= showIt 1)
			(User canControl: 1)
		)
	)
	(if showIt
		(ShowTheCursor)
	)
)

(procedure (DontTalk yesNo &tmp showIt)
	(= showIt 0)
	(cond
		(yesNo
			(if (not gCantTalk)
				(User canInput: 0)
				(SetMenu 1289 112 0)
				(SetMenu 1290 112 0)
				(= showIt 1)
			)
			(++ gCantTalk)
		)
		((<= (-- gCantTalk) 0)
			(= gCantTalk 0)
			(= showIt 1)
			(SetMenu 1289 112 1)
			(SetMenu 1290 112 1)
			(User canInput: 1)
		)
	)
	(if showIt
		(ShowTheCursor)
	)
)

(procedure (Face actor1 actor2 both whoToCue &tmp ang1to2)
	(= ang1to2 (GetAngle (actor1 x:) (actor1 y:) (actor2 x:) (actor2 y:)))
	(if (and (>= argc 3) both)
		(actor2 setHeading: (+ 180 ang1to2))
	)
	(if (>= argc 4)
		(actor1 setHeading: ang1to2 whoToCue)
	else
		(actor1 setHeading: ang1to2)
	)
)

(procedure (MouseClaimed obj event shifts &tmp retVal) ; UNUSED
	(if (= retVal (MousedOn obj event shifts))
		(event claimed: 1)
	)
	(return retVal)
)

(procedure (OnButton x y left top right bottom) ; UNUSED
	(return
		(and
			(<= left x)
			(< x right)
			(<= top y)
			(< y bottom)
		)
	)
)

(procedure (Purchase itemPrice &tmp oldCents oldDinar retVal) ; UNUSED
	(= oldCents [gInvNum 1]) ; Centime
	(= oldDinar [gInvNum 2]) ; Dinar
	(= retVal 0)
	(if (u>= (+ oldCents (* oldDinar 100)) itemPrice)
		(= retVal 1)
		(for ((-= oldCents itemPrice)) (< oldCents 0) ((+= oldCents 100))
			(-- oldDinar)
		)
		(= [gInvNum 1] oldCents) ; Centime
		(= [gInvNum 2] oldDinar) ; Dinar
	)
	(return retVal)
)

(procedure (ChooseFromCycle index first last)
	(return (+ first (mod (- index 1) (+ (- last first) 1))))
)

(procedure (IsFlag flagEnum)
	(return (& [gGameFlags (/ flagEnum 16)] (>> $8000 (mod flagEnum 16))))
)

(procedure (SetFlag flagEnum &tmp oldState)
	(= oldState (IsFlag flagEnum))
	(= [gGameFlags (/ flagEnum 16)]
		(| [gGameFlags (/ flagEnum 16)] (>> $8000 (mod flagEnum 16)))
	)
	(return oldState)
)

(procedure (ClearFlag flagEnum &tmp oldState)
	(= oldState (IsFlag flagEnum))
	(= [gGameFlags (/ flagEnum 16)]
		(& [gGameFlags (/ flagEnum 16)] (~ (>> $8000 (mod flagEnum 16))))
	)
	(return oldState)
)

(procedure (Rand200)
	(return (+ 50 (Random 0 75) (Random 0 75)))
)

(procedure (cls)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(procedure (HaveMem howMuch)
	(return (u> (MemoryInfo 0) howMuch)) ; LargestPtr
)

(procedure (measure findLen theString &tmp strAddr [printStr 500])
	(if (u< (= strAddr theString) 1000)
		(= strAddr @printStr)
		(Format @printStr theString &rest)
	)
	(if findLen
		(= printLen (StrLen strAddr))
	else
		(TextSize @[printRect 0] strAddr gUserFont 0)
	)
)

(procedure (CenterPrint theString moreStuff &tmp strWidth)
	(cls)
	(measure 0 theString moreStuff)
	(= strWidth (if (> [printRect 2] 24) 300 else 0))
	(cond
		((== argc 1)
			(Print theString #at -1 -1 #width strWidth #mode 1)
		)
		((u< theString 1000)
			(Print theString moreStuff #at -1 -1 #width strWidth #mode 1 &rest)
		)
		(else
			(Print theString 67 -1 -1 70 strWidth 30 1 moreStuff &rest)
		)
	)
)

(procedure (HighPrint theString)
	(CenterPrint theString &rest 67 -1 12)
)

(procedure (LowPrint theString &tmp boxHeight)
	(measure 0 theString &rest)
	(= boxHeight [printRect 2])
	(CenterPrint theString &rest 67 -1 (- 180 boxHeight))
)

(procedure (TimePrint numSeconds theString)
	(if (not numSeconds)
		(measure 1 theString &rest)
		(if (< (= numSeconds (/ printLen 9)) 3)
			(= numSeconds 3)
		)
	)
	(CenterPrint theString &rest 67 -1 12 103 25 numSeconds)
)

(procedure (Eval obj sel)
	(obj sel: &rest)
)

(procedure (AskWhat &tmp index)
	(for ((= index 1)) (< index 33) ((++ index))
		(if (Said [askSpecs index])
			(break)
		)
	)
	(if (>= index 33)
		(= index 0)
	)
	(return index)
)

(procedure (NormalEgo)
	(EgoGait -1 0)
	(gEgo
		setLoop: -1
		setLoop: gEgoLooper
		setPri: -1
		setMotion: 0
		setAvoider: 0
		illegalBits: -32768
		baseSetter: gEgoBaseSetter
		ignoreHorizon:
		ignoreActors: 0
	)
)

(procedure (EgoGait newGait gaitMsg &tmp theView walkNorm walkStop)
	(if gaitMsg
		(cond
			((not (User canControl:))
				(HighPrint 1 0) ; "You can't do that now."
				(return)
			)
			((== gEgoGait newGait)
				(HighPrint 1 1) ; "Go ahead. Just do it."
				(return)
			)
		)
	)
	(if (!= newGait -1)
		(= gEgoGait newGait)
	)
	(= walkNorm 0)
	(= walkStop 4)
	(gEgo cycleSpeed: 0 moveSpeed: 0)
	(switch gEgoGait
		(1 ; running
			(gEgo view: 1 setStep: 6 3 setCycle: gEgoStopWalk 4)
		)
		(2 ; sneaking
			(gEgo view: 2 setStep: 2 2 setCycle: gEgoWalk)
		)
		(3 ; riding
			(gEgo view: 12 setStep: 5 3 setCycle: gEgoWalk)
		)
		(4 ; holdingLamp
			(gEgo view: 585 setStep: 4 2 setCycle: gEgoWalk)
		)
		(else
			(gEgo view: walkNorm setStep: 4 2 setCycle: gEgoStopWalk walkStop)
		)
	)
)

(procedure (SaidInv event &tmp index obj)
	(for ((= index 0)) (< index 58) ((++ index))
		(if (Said [invNames index])
			(break)
		)
	)
	(if (> (++ index) 58)
		(event claimed: 1)
		(= index 0)
	)
	(return index)
)

(procedure (WtCarried &tmp tot index)
	(= index 1)
	(= tot 0)
	(while (<= index 58)
		(+= tot (* [gInvNum index] [gInvWeight index]))
		(++ index)
	)
	(= tot (/ (+ (+= tot (* gDrinksLeft 12)) 59) 60))
)

(procedure (MaxLoad)
	(return (+ 40 (/ [gEgoStats 0] 2))) ; strength
)

(procedure (EgoDead useRandomIcon &tmp printRet)
	(HandsOff)
	(Wait 100)
	(= gNormalCursor 999)
	(gGame setCursor: 999 1)
	(gSounds eachElementDo: #stop)
	(if gDeathMusic
		(gMiscSound number: gDeathMusic priority: 15 loop: 1 play:)
	)
	(repeat
		(cond
			((not useRandomIcon)
				(= printRet
					(Print
						&rest
						#width
						250
						#button
						{Restore}
						1
						#button
						{ Restart }
						2
						#button
						{ Quit }
						3
					)
				)
			)
			((or (== gSillyClowns 0) (and (== gSillyClowns 2) (not (Random 0 1))))
				(= printRet
					(Print
						&rest
						#width
						250
						#button
						{Restore}
						1
						#button
						{ Restart }
						2
						#button
						{ Quit }
						3
						#icon
						998
						2
						0
					)
				)
			)
			(else
				(gCIcon
					loop: (Random 0 1)
					cel: 0
					cycleSpeed: (if (== 6 1) 20 else 10)
				)
				(= printRet
					(Print
						&rest
						#width
						250
						#button
						{Restore}
						1
						#button
						{ Restart }
						2
						#button
						{ Quit }
						3
						#icon
						gCIcon
					)
				)
			)
		)
		(switch printRet
			(1
				(gGame restore:)
			)
			(2
				(gGame restart:)
			)
			(3
				(= gQuit 1)
				(break)
			)
		)
	)
)

(procedure (PromptQuit)
	(gCIcon loop: 2 cel: 0)
	(= gQuit
		(Print ; "do you mind if I join you?"
			1
			2
			#title
			{If it's time to split...}
			#button
			{Quit}
			1
			#button
			{Don't Quit}
			0
			#icon
			gCIcon
			4
			0
		)
	)
)

(procedure (PromptRestart &tmp oldPause)
	(= oldPause (Sound pause: 1))
	(if (or gDebugging (Print 1 3 #button {Restart} 1 #button {Continue} 0 #icon 998 1 0)) ; "Could you run that by me once more, please?"
		(gGame restart:)
	else
		(Sound pause: oldPause)
	)
)

(procedure (PromptPause &tmp oldPause)
	(= oldPause (Sound pause: 1))
	(Print 1 4 #title {Game Paused} #icon 998 0 0 #button {Let's be glorious} 1) ; "Every hero needs a break now and then. Have a nice nap."
	(Sound pause: oldPause)
)

(procedure (ShowCredits &tmp [str 300])
	(gCustomWindow color: 0 back: 15)
	(if (>= gNumColors 8)
		(gCustomWindow back: 12)
	)
	(Print
		(Format @str 1 5) ; "Written and Directed by: LORI ANN COLE and COREY COLE Lead Artist: KENN NISHIUYE Lead Programmer: BOB FISCHBACH Amiga Conversion: STEVE COALLIER and JOHN RETTIG Original Music and Sound Effects by: MARK SEIBERT and CHRIS BRAYMEN"
		#title
		{ Quest for Glory 2:  Trial By Fire }
		#width
		240
		#mode
		1
		#font
		gSmallFont
		#at
		-1
		20
		#window
		gCustomWindow
	)
	(Print
		(Format @str 1 6 gVersion) ; "Programmed by: COREY COLE MARK WILDEN BRIAN K. HUGHES JERRY SHAW and ROBERT MALLORY with RANDY MACNEILL and GARY KAMIGAWACHI Implementation Specialist: J. MARK HOOD Version %s Copyright 1990 Sierra On-Line, Inc."
		#title
		{ Quest for Glory 2:  Trial By Fire }
		#width
		240
		#mode
		1
		#font
		gSmallFont
		#at
		-1
		20
		#window
		gCustomWindow
	)
	(Print
		(Format @str 1 7) ; "Backgrounds and Animation by: JERRY MOORE CHERI LOYD DOUG HERRING NATE LARSEN ERIC KASNER DESIE HARTMAN DEAN LAROCCA TAMRA DAYTON and HARRY MCLAUGHLIN Quality Assurance by: MIKE PICKHINKE and MIKE HARIAN with Gordon, Dan S., Dan W., Joe, John, and more"
		#title
		{ Quest for Glory 2:  Trial By Fire }
		#width
		240
		#mode
		1
		#font
		gSmallFont
		#at
		-1
		20
		#window
		gCustomWindow
	)
	(Print
		(Format @str 1 8) ; "Development System by: JEFF STEPHENSON ROBERT E. HEITMAN PABLO GHENIS DAN FOY LARRY SCOTT ERIC HART COREY COLE and MARK WILDEN Special thanks to our long-suffering Beta testers: Neil, Janet, Linda, Gano, Todd, Dan, Paul, Tod, and Lance"
		#title
		{And last, but not least...}
		#mode
		1
		#width
		180
		#font
		gSmallFont
		#at
		-1
		20
		#window
		gCustomWindow
	)
)

(procedure (ShowHelp)
	(Print 1 9 #font gSmallFont) ; "DURING THE GAME: Click at the top of the screen or press ESC to use the menus. Additional shortcuts are shown there. Click Right or Shift-Click Left Mouse Button on an object to look at it.    IN TYPING WINDOWS: Arrows, Home and End move the cursor, or click anywhere with the mouse. Ctrl-C clears the line.    IN DIALOG WINDOWS: Select the outlined item with <Enter> and use Tab and Shift-Tab to move between choices. Or click with the mouse to select an item. ESC always cancels."
)

(procedure (NoRoom theDist theBits &tmp dist bits)
	(= bits -32768)
	(= dist 15)
	(if argc
		(= dist theDist)
		(if (>= argc 2)
			(= bits theBits)
		)
	)
	(return
		(&
			(OnControl
				CONTROL
				(- (gEgo x:) dist)
				(- (gEgo y:) dist)
				(+ (gEgo x:) dist)
				(+ (gEgo y:) dist)
			)
			bits
		)
	)
)

(procedure (InitFeatures)
	(gFeatures add: &rest eachElementDo: #init doit:)
)

(procedure (StartTimer theTimer startTime endTime &tmp theTime)
	(= theTime
		(if (> argc 2)
			(Random startTime endTime)
		else
			startTime
		)
	)
	(theTimer setReal: theTimer theTime)
)

(procedure (MakeSign)
	(if (or [gEgoStats 9] [gEgoStats 8]) ; pick locks, sneak
		(HighPrint 1 10) ; "You place your thumb upon your nose with the hand held perpendicular to the face and the fingers outspread. You then wiggle your fingers while focusing your eyes on the thumb and patting your belly with the other hand."
		(HighPrint 1 11) ; "(We don't show any of that here, in order not to embarrass those people with tender sensibilities.)"
		(return 1)
	else
		(switch (Random 0 3)
			(0
				(HighPrint 1 12) ; "You touch the palm of your right hand to your left shoulder, extend the third digit of your left hand until the pad of the finger touches the underside of your right eye, touch your left toe to your left wrist, and twiddle your thumbs furiously."
			)
			(1
				(HighPrint 1 13) ; "Placing the index finger of each hand in opposing corners of your mouth, you simultaneously pull your fingers outward, extending and wiggling your tongue vertically."
			)
			(2
				(HighPrint 1 14) ; "Sticking your shoomflufluf out sideways, you touch your bozombie (wet side up, of course) to your flanigoogle, being careful not to cut off the circulation to your capitalary artery."
				(HighPrint 1 15) ; "CAUTION: Do not try this at home!"
			)
			(3
				(HighPrint 1 16) ; "Using both hands, you touch your left knee, your right instep, both temples, and that small spot in between your shoulder blades that always itches."
			)
		)
		(return 0)
	)
)

