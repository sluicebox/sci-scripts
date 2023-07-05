;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use eRS)
(use System)

(public
	rm310 0
)

(local
	[local0 4]
	local4
)

(procedure (localproc_0 param1)
	(TextSize @local0 param1 0 315)
	(return (/ (- 180 (- [local0 2] [local0 0])) 2))
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1)
	(gCurRoom drawPic: 98 13)
	(= temp1 (- (= temp0 (localproc_0 param1)) 20))
	(Display param2 dsCOLOR global125 dsCOORD 3 temp1 dsWIDTH 315 dsFONT 1 dsALIGN alCENTER)
	(Display param1 dsCOLOR global125 dsCOORD 3 temp0 dsWIDTH 315 dsFONT 0 dsALIGN alCENTER)
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1)
	(gCurRoom drawPic: 98 13)
	(= temp1 (- (= temp0 (localproc_0 param1)) 30))
	(Display 310 0 dsCOLOR global125 dsCOORD 137 temp1 dsFONT 1 dsALIGN alCENTER) ; "ACTORS:"
	(Display param1 dsCOLOR global125 dsCOORD 10 temp0 dsWIDTH 130 dsFONT 0 dsALIGN alRIGHT)
	(Display param2 dsCOLOR global125 dsCOORD 165 temp0 dsWIDTH 140 dsFONT 0 dsALIGN alLEFT)
)

(instance rm310 of PQRoom
	(properties
		picture 98
	)

	(method (init)
		(super init:)
		(gLongSong number: 50 loop: -1 play:)
		(Load rsFONT 0)
		(Load rsFONT 1)
		(HandsOff)
		(gCurRoom setScript: endScript)
	)
)

(instance endScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1
					{"LPD recently received this top-secret list of the names and occupations of the members of an alleged electronic terrorist group. The gang leader, one Jim "Pretty Boy" Walls, has been known to threaten to "shape Lytton's future like so much silly putty". It is not known at this time if the gang's intentions are for good or evil - or if they should even be taken seriously. Nevertheless, be on the lookout for the following gang members.\nThey're wanted for questioning."}
					{}
				)
				(= seconds 24)
			)
			(1
				(= start 3)
				(if (== local4 1)
					(gTheIconBar enable:)
					(HandsOff)
				)
				(= cycles 1)
			)
			(2
				(if (== local4 5)
					(= gQuit 1)
				else
					(= cycles 1)
				)
			)
			(3
				(localproc_1
					{Kim Bowdish\nChris Hoyt\nMike Larsen}
					{PROGRAMMERS:\n\n}
				)
				(= seconds 7)
			)
			(4
				(localproc_1
					{Jonathan Bock\nJeff Crowe\nFrank Ferrell\nJim Larsen\nSuzi LivenGood\nCindy Walker\nWillis Wong}
					{ARTISTS:\n\n}
				)
				(= seconds 10)
			)
			(5
				(localproc_1
					{Rob Atesalp\nMark Seibert}
					{SOUND EFFECTS & COMPOSERS:\n\n}
				)
				(= seconds 7)
			)
			(6
				(localproc_1 {Jane Jensen} {WRITER:\n\n})
				(= seconds 5)
			)
			(7
				(localproc_1
					{Jeff Stephenson\nRobert E. Heitman\nDan Foy\nLarry Scott\nJohn Rettig\nJ. Mark Hood\nChris Smith\nTerry McHenry\nEric Hart\nChad Bye\nMark Wilden\nKen Koch\nJohn Crane\nSteve Coallier\nRandy Moss}
					{SYSTEM DEVELOPMENT:\n}
				)
				(= seconds 17)
			)
			(8
				(localproc_1
					{Joe Carper\nMike Brosius}
					{QUALITY ASSURANCE:\n\n}
				)
				(= seconds 3)
			)
			(9
				(localproc_1 {Polly Starkey} {COSTUMES:\n\n})
				(= seconds 3)
			)
			(10
				(localproc_1
					{Sabine Duvall}
					{INTERNATIONAL PRODUCER:\n\n}
				)
				(= seconds 3)
			)
			(11
				(localproc_1
					{Ignacio Piquero de Lafuente}
					{TRANSLATOR:\n\n}
				)
				(= seconds 3)
			)
			(12
				(localproc_1
					{Gary Kamigawachi}
					{FOREIGN LANGUAGES PROGRAMMING:\n\n}
				)
				(= seconds 7)
			)
			(13
				(localproc_2
					{Sonny Bonds\nMarie Bonds\nPat Morales\nCaptain Tate\nKevin Miller\nSteve Rocklin\nMike Downs\nJuan Jose Ruiz\nZak, the Keymaker\nLeon, the Coroner\nHysterical Lady\nAllied Officer}
					{- Chris Barns\n- Cheri Loyd\n- Patty Lang\n- Robert Tapp\n- Roger Griffith\n- Mike Pickhinke\n- John Hartin\n- George Esparza\n- Bob Ballew\n- Josh Mandel\n- Mary Anne Larsen\n- Steve Parker}
				)
				(= seconds 18)
			)
			(14
				(localproc_2
					{Ms. Gibbs, Evidence Officer\nMr. Smith, Booking Officer\nMr. Stumps, Janitor\nSidney Aimes, Psychologist\nMr. Hanley, Speeder\nPregnant Lady\nArmy Recruiter\nDrunk\nFlorist\nDoctor Wagner\nChief Fireman}
					{- Cindy Walker\n- Craig Simmons\n- Bill Davis, Jr.\n- Corey Cole\n- Orpheus Hanley\n- Diane Haley\n- Zoltan Andahazy\n- Bob Fischbach\n- Nancy Bickley\n- Warren Cleeland\n- Craig Simmons}
				)
				(= seconds 18)
			)
			(15
				(localproc_2
					{Newspaper Reporter\nNut at Aspen Falls\nCourt Recorder\nCarla Reed, Bag lady\nMildred Simpson, Judge\nMr. Meyer, Defense Attorney\nMr. Cannon, D.A.}
					{- Nick Medici\n- Brian Brouillette\n- Veronica Oldfield\n- Nancy Smythe\n- Tara Ryan\n- Chris Garski\n- Ken Williams}
				)
				(= seconds 10)
			)
			(16
				(localproc_2
					{Spike, the K-9 unit\nTrainer\nAssistant Trainer\nSpike's Hairdresser\nSpike's Stunt Double\nSpike's Costume}
					{Spot, the Wonder-Dog\nF. Lee Bitten\nIma K. Nein\nSean Claude dePoo Del\nRalph, the Wonder Llama\nDog and Doggie of Beverly Hills}
				)
				(= seconds 10)
			)
			(17
				(localproc_1
					{"A representative of the SPCA was present at all times during the coding of the animal sequences. No animals were in any actual danger."}
					{}
				)
				(= seconds 11)
			)
			(18
				(localproc_1
					{"Thank you for playing Police Quest III. We hope it's been as entertaining as you have."}
					{}
				)
				(= seconds 6)
			)
			(19
				(++ local4)
				(self init:)
			)
		)
	)
)

