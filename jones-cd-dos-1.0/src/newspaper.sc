;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 215)
(include sci.sh)
(use Main)
(use DialogScript)
(use Interface)
(use KeyMouse)
(use DCIcon)
(use Motion)
(use System)

(public
	newspaper 0
)

(procedure (localproc_0) ; UNUSED
	(Format @global100 215 0) ; "DUMMY"
	(Format @global100 215 1) ; "BANKS FALTER! SAVINGS LOST! JOBS LOST!"
	(Format @global100 215 2) ; "SCANDAL ON WALL ST. ECONOMY DROPS! UNEMPLOYMENT RISES"
	(Format @global100 215 3) ; "MORE S & L'S FAIL! ECONOMY SUFFERS"
	(Format @global100 215 4) ; "INFLATION IS UP PRICES COULD SOAR!"
	(Format @global100 215 5) ; "GOLD OUTLOOK IS GOOD"
	(Format @global100 215 6) ; "GOLD INVESTMENTS LOOK TARNISHED"
	(Format @global100 215 7) ; "GOOD TIMES AHEAD FOR SILVER"
	(Format @global100 215 8) ; "EXPERTS AGREE GET OUT OF SILVER"
	(Format @global100 215 9) ; "PRESIDENT EATS PORK RINDS"
	(Format @global100 215 10) ; "GENERAL POPULATION HATES PORK RINDS"
	(Format @global100 215 11) ; "BLUE CHIP STOCKS OUTLOOK ROSEY"
	(Format @global100 215 12) ; "HARD TIMES AHEAD FOR BIG BLUE"
	(Format @global100 215 13) ; "PENNY STOCKS ARE WISE INVESTMENT"
	(Format @global100 215 14) ; "PENNY STOCKS NOT WORTH A DIME"
	(Format @global100 215 15) ; "WILD WILLY RIPS OFF ANOTHER APARTMENT"
	(Format @global100 215 16) ; "WILD WILLY HAS LIFTED ANOTHER WALLET"
	(Format @global100 215 17) ; "BIG LOTTERY WINNER!"
	(Format @global100 215 18) ; "INVESTMENTS RECOMMENDED"
	(Format @global100 215 19) ; "INVESTMENTS NOT RECOMMENDED"
	(Format @global100 215 20) ; "ECONOMIC OUTLOOK GOOD"
	(Format @global100 215 21) ; "ECONOMIC OUTLOOK POOR"
	(Format @global100 215 22) ; "UNEMPLOYMENT IS ON THE RISE"
	(Format @global100 215 23) ; "UNEMPLOYMENT IS DOWN"
	(Format @global100 215 24) ; "NOBODY YOU KNOW WON THE LOTTO!"
	(Format @global100 215 25) ; "PRESIDENT HATES BROCCOLI"
	(Format @global100 215 26) ; "MORE FAST FOOD PLACES USING SOYBEANS"
	(Format @global100 215 27) ; "SCHOOL ENROLLMENT UP"
	(Format @global100 215 28) ; "SCHOOL ENROLLMENT DOWN"
	(Format @global100 215 29) ; "THERE IS MONEY IN COMPUTERS"
	(Format @global100 215 30) ; "HOUSING MARKET LOOKS GOOD"
	(Format @global100 215 31) ; "SALES OF NEWSPAPERS HAVE SKYROCKETED"
	(Format @global100 215 32) ; "PAWN SHOPS SERVE USEFUL PURPOSE"
	(Format @global100 215 33) ; "NORTH SHORE OF BASS LAKE SINKS"
	(Format @global100 215 34) ; "ALICE COOPER GIVES BIRTH TO TWIN BOYS"
	(Format @global100 215 35) ; "COARSEGOLD PURCHASED BY JAPAN"
	(Format @global100 215 36) ; "SPACE QUEST III WINS BIG AWARD"
	(Format @global100 215 37) ; "ELVIS SIGHTED AT KFC IN OAKHURST"
	(Format @global100 215 38) ; "TALKING BEAR KIDNAPPED! FBI INVESTIGATING"
	(Format @global100 215 39) ; "KINGS QUEST XXIX GOES TO PRODUCTION"
	(Format @global100 215 40) ; "MR. WHIPPLE FOUND SQUEEZED TO DEATH IN APARTMENT"
	(Format @global100 215 41) ; "REAGAN'S NAP INTERRUPTS SPEECH"
	(Format @global100 215 42) ; "MOTHER GOOSE GETS DIVORCE! FEATHERS RUFFLED"
	(Format @global100 215 43) ; "MOTHER GOOSE SUSPECTED OF FOWL PLAY"
	(Format @global100 215 44) ; "SALMON BITING OFF NORTH SHORE OF BASS LAKE"
	(Format @global100 215 45) ; "NIXON MAKES ROCK VIDEO"
	(Format @global100 215 46) ; "FORD STUMBLES ON CURE"
	(Format @global100 215 47) ; "NEW GOVT STUDY SHOWS GAME PLAYERS GET SICK TOO!"
	(Format @global100 215 48) ; "IMELDA M. LOOKING FOR A FEW GOOD SHOES"
	(Format @global100 215 49) ; "NANCY IS LOOKING FOR A NEW DRESS"
	(Format @global100 215 50) ; "TYpEsETTrs U ion shr ds Agre mNt!"
	(Format @global100 215 51) ; "FIREMEN ARE ALWAYS IN HEAT"
	(Format @global100 215 52) ; "PRESIDENT FINALLY EATS BROCCOLI"
	(Format @global100 215 53) ; "PRESIDENT EATS BROCCOLI AND LIVES!"
	(Format @global100 215 54) ; "STUDY SHOWS WE HAVE MORE LEISURE TIME"
	(Format @global100 215 55) ; "EXTRA! EXTRA!"
	(Format @global100 215 56) ; "TORNADO KILLS 8 THEN COMMITS SUICIDE!"
	(Format @global100 215 57) ; "CIGARETTES FOUND TO CAUSE LABORATORY ANIMALS!"
	(Format @global100 215 58) ; "COURTS JAMMED! WAPNER REINSTATED!"
	(Format @global100 215 59) ; "GRAND CANYON DESIGNATED NATIONAL LANDFILL!"
	(Format @global100 215 60) ; "CELEBRITY BULLFIGHTING DISASTER; LESLEY GORED"
	(Format @global100 215 61) ; "GURUKA SINGH GETS HAIRCUT! PHOTOS UNDER WRAPS!"
	(Format @global100 215 62) ; "RAP GROUP ARRESTED FOR NOT STARTING RIOT!"
	(Format @global100 215 63) ; "TRAILER PARK DEMOLISHES 6 TORNADOES!"
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance newspaper of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0 temp1 temp2)
		(= temp2 global557)
		(= global557 0)
		(= global568 1)
		(if global414
			(= global415 15)
		)
		(if (== (global302 playing:) 29)
			(SetMenu 513 112 0)
		)
		(if (not global518)
			(= prevTalker global413)
			(= global413 0)
			(proc0_17 3)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(compScript state: -1 cycles: 0 seconds: 0)
			(= client param1)
			(if (== (global302 playing:) 29)
				(self setScript: compScript)
			)
			(self window: global38 add: background doneButton newsPaper)
			(self
				eachElementDo: #init
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 -1
			)
			(if global534
				(newsPaper cue:)
			)
			(= temp1 (KeyMouse curItem:))
			(proc0_9 self keyMouseList doneButton)
			(KeyMouse setList: keyMouseList)
		else
			(KeyMouse setCursor: theItem)
		)
		(= temp0 (self doit: 0 0))
		(if (IsObject temp0)
			(if (self contains: temp0)
				(= temp0 0)
			)
		else
			(= temp0 1)
		)
		(KeyMouse
			setList:
				(if prevDialog
					(prevDialog keyMouseList:)
				else
					gMainKeyMouseList
				)
		)
		(KeyMouse curItem: temp1)
		(if global447
			(KeyMouse setCursor: temp1)
		)
		(keyMouseList release: dispose:)
		(= global502 prevDialog)
		(proc0_15 self 294)
		(self dispose:)
		(SetPort 0)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(proc0_17 0)
		(= global413 prevTalker)
		(proc0_1)
		(if (== (global302 playing:) 29)
			(SetMenu 513 112 1)
		)
		(= global568 0)
		(= global557 temp2)
		temp0
		(DisposeScript 215)
	)
)

(instance background of DIcon
	(properties
		view 603
		loop 1
		cel 1
		priority 13
	)
)

(instance doneButton of ErasableDIcon
	(properties
		state 419
		nsTop 108
		nsLeft 143
		key 120
		view 250
		loop 2
		priority 15
	)
)

(instance newsPaper of DCIcon
	(properties
		nsTop 35
		nsLeft 56
		view 603
		priority 14
	)

	(method (init)
		(gASong stop: 1)
		(gASoundEffect loop: 1 play: 8)
		(if (not global534)
			(self cycleSpeed: 1 setCycle: End self)
		)
	)

	(method (draw)
		(if (or (not global534) (== loop 1))
			(super draw: &rest)
		)
	)

	(method (cue)
		(self setCycle: 0)
		(self
			loop: 1
			cel: 0
			nsTop: 0
			nsLeft: 0
			nsBottom: 112
			nsRight: 183
			draw:
		)
		(if (or (<= global415 0) (> global415 62))
			(repeat
				(if
					(or
						(!= (= global415 (Random 25 62)) 24)
						(>= global372 (+ global524 3))
					)
					(break)
				)
			)
		)
		(global502 add: newspaperText)
		(newspaperText draw:)
	)
)

(instance newspaperText of DText
	(properties)

	(method (draw &tmp [temp0 4] [temp4 50])
		(self setPort:)
		(= text (Format @temp4 215 64 215 global415)) ; "%s"
		(TextSize @[temp0 0] text 3 0)
		(Display
			text
			dsCOORD
			11
			(- 43 (/ [temp0 2] 2))
			dsCOLOR
			(if global535 72 else 0)
			dsWIDTH
			155
			dsBACKGROUND
			-1
			dsFONT
			3
			dsALIGN
			alCENTER
		)
		(self resetPort:)
		(if (not global563)
			(++ global563)
			(if (or (== (global302 playing:) 29) (== gTheCursor 997))
				(Timer set60ths: compScript (proc0_18 (+ (- global415 1) 460)))
			else
				(proc0_18 (+ (- global415 1) 460))
			)
		)
	)
)

(instance compScript of DialogScript
	(properties)

	(method (handleEvent event)
		(if register
			(= register 0)
			(= cycles 1)
			(event type: evKEYBOARD x: 160 y: 100)
			(switch state
				(2
					(= cycles 240)
				)
				(3
					(event message: KEY_x)
				)
				(else
					(super handleEvent: event 0)
				)
			)
		)
	)
)

