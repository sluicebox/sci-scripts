;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use Print)
(use Cursor)
(use System)

(public
	xaboutStuff 2
)

(local
	local0
	local1
)

(instance xaboutStuff of Code
	(properties)

	(method (doit &tmp temp0)
		(= temp0 (gGame setCursor: aboutArrowCurs 1))
		(Print addText: 29 0 8 1 0 0 0 init:) ; "GABRIEL KNIGHT: SINS OF THE FATHERS This entire work Copyright (c) 1993 Sierra On-Line, Inc. Contains technologies described in U.S. patent applications including 598,172 and 658,297.  DOS/4GW Professional Protected Mode Run-Time Copyright (c) Rational Systems, Inc. 1990-1993  Data Compression Software Copyright (c) 1988-92 Stac Electronics. U.S. patents including #5,016,009. Other patents pending."
		((= local0 (Print new:))
			addText: {About:} 66 0
			addButton: 1 {___Credits___} 0 20
			addButton: 2 { How To Play } 100 20
			addButton: 3 {____Hints____} 50 40
			modeless: 0
		)
		((local0 dialog:) mouseHiliting: 1)
		(switch (= local1 (local0 init:))
			(1
				(if
					(and
						(Print addText: 29 0 8 2 0 0 0 init:) ; "Gabriel Knight development team:  Designer/Director: Jane Jensen  Producer/Composer: Robert Holmes  Lead Programmer: Tom DeSalvo  Programmers:    Bob Andrews, Sean Mooney,    Greg Tomko-Pavia, Jerry Shaw  Illustration Director: John Shroades  Animation Director: Michael Hutchison  Backgrounds/Illustrations:    Darlou Gams, John Shroades,    Chris Willis, Deanna Yhalkee  Animation:    Michael Hutchison, Chris Willis,    Deanna Yhalkee, Darlou Gams,    John Shroades"
						(Print addText: 29 0 8 3 0 0 0 init:) ; "Text & Dialogue: Jane Jensen,    Bridget McKenna  3D Rendering & Animation:    Michael Hutchison  Lead QA: Judy Crites  QA: Judy Crites, Matt Genesi,    John Ratcliffe  Audio Engineers: Rick Spurgeon,    Kelli Spurgeon  Graphic Arts: Nathan Gams"
						(Print addText: 29 0 8 4 0 0 0 init:) ; "Hollywood Voice-Over Production (CD only):  Voice-Over Director: Stuart M. Rosen  Associate Producer: John E. Grayson  Starring:   Gabriel Knight: Tim Curry   Detective Mosely: Mark Hamill   Grace Nakimura: Leah Remini   Narrator: Virginia Capers   Dr. John: Michael Dorn   Malia Gedde: Leilani Jones   Wolfgang: Efrem Zimbalist, Jr.   Willy Walker: Rocky Carroll"
						(Print addText: 29 0 8 5 0 0 0 init:) ; "Madame Cazaunoux: Susan Silo   Crash: Chris Lytton   Desk Sergeant Frick: Jim Cummings   Gerde: Mary Kay Bergman   Grandma Knight: Linda Gary   Hartridge: Monte Markham   Magentia Moonbeam: Nancy Lenehan   Stonewall King: Monte Markham   Toussaint Gervais: Dorian Harewood"
						(Print addText: 29 0 8 6 0 0 0 init:) ; "Additional Voices:  Sam: Jeff Bennett  Markus: Monte Markham  Tetelo: Linda Gary  Little boy, Old lady: Mary Kay Bergman  Blues band leader, Cajun band leader,   Jazz band leader, Muscle man,   Dragon, Gunter: Jim Cummings  Technical Artist, Bruno,   Uniformed Officer, Lucky Dog Vendor,   Motorcycle Cop: Jeff Bennett  Priest, Phone Guy #5, Beignet Vendor:   Stuart M. Rosen  Gedde Butler: Tim Curry  Jeep Driver: Mark Hamill"
						(Print addText: 29 0 8 7 0 0 0 init:) ; "Additional Sierra-Online Production:  Brand Manager: Sherry Short,   Dan Rogers  Sound Effects: Chris Braymen,   Robert Holmes, Orpheus Hanley,   Rick Spurgeon, Mark Seibert  Music Conversions: Neal Grandstaff,   Jay Usher, Chris Braymen  Additional Art: Terry Falls,   Gloria Garland  Additional QA: Robin Bradley,   Dave Clingman, Susan Frischer  Director of Technology: Bill Crow  System Technologists: Dan Foy,   Brian K. Hughes, Larry Scott,   Chris Smith, Mark Wilden  Systems Programmers: Ed Critchlow,   Ken Koch, Terry McHenry,   Martin Peters"
						(Print addText: 29 0 8 8 0 0 0 init:) ; "Additional Sierra-Online Production:  "The Making of Gabriel Knight": Written,   directed, and produced by: Bill Crow  Photography: Bob Ballew  Manual Writer: Jane Jensen  Manual Designers: Nathan Gams,   Maria Fruehe  Customer Service: Debbie Catania  Video Capture Actors: Dave Artis,   Dana Dean, Max Deardorff,   Terry Falls, Robert Lindsley,   Mark Parker, Lorelei Shannon,   Ayesha Tidwell, Mike Weiner,   Karin Young"
						(Print addText: 29 0 8 9 0 0 0 init:) ; "QA Configuration:   Team Lead: Dave Clingman   Jon Meek, Daryle Smith,   Roger Clendenning, Lynne Dayton,   Doug Wheeler, John Trauger,   Leonard Salas, Ken Eaton,   Sharon Simmons, Mike Jones,   Catie Andrews Special Thanks:   Woodholly Productions,   Dan Kehler, Stuart Moulder,   Sabine Duvall, Mark Hood,   Jim Thomas, Bil Skirvin,   Lesa Spravka, Tony Caudill,   Terese Nielsen, Nathan Gams Napolean House Music:   Vivaldi    From "Lute Concerto in D""
					)
				)
			)
			(2
				(if
					(and
						(Print addText: 29 0 11 1 0 0 0 init:) ; "The GK icon interface: To play, use the icon bar cursors to try actions on objects on the screen. The Gabriel Knight icons include:"
						(Print addText: 29 0 11 2 0 0 0 init:) ; "WALK: To move Gabriel around LOOK: To get descriptive messages--and often game hints ASK: To go into Interrogation Mode with characters TALK: To chat with characters PICK-UP: To take items on screen OPEN/CLOSE: To open or close objects on screen OPERATE: To "use" an object on screen that has a specific function MOVE: To push or pull an object on screen"
						(Print addText: 29 0 11 3 0 0 0 init:) ; "Also on the icon bar is a question mark. Select the question mark button and then move the question mark over the other icons to get help messages."
						(Print addText: 29 0 11 4 0 0 0 init:) ; "Read your "Gabriel Knight: Sins of the Fathers" technical manual for strategy/playing tips, first few puzzles walkthrough, and a more thorough explanation of the icon bar, control panel, and other game interfaces."
					)
				)
			)
			(3
				(if (Print addText: 29 0 20 1 0 0 0 init:) ; ""Gabriel Knight" is a challenging game. Don't be afraid to take advantage of hints to avoid frustration and increase your enjoyment of the story. See page 32 and 33 of the "Gabriel Knight: Sins of the Fathers" technical manual for details on Sierra's hint line, the "Gabriel Knight" hint book, Sierra's hint Bulletin Board, and international hints."
				)
			)
		)
		(gGame setCursor: temp0 1)
		(DisposeScript 92)
	)
)

(instance aboutArrowCurs of Cursor
	(properties
		view 999
	)
)

